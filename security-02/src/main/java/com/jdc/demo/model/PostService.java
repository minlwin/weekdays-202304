package com.jdc.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.MemberDto;
import com.jdc.demo.model.dto.PostDetailsDto;
import com.jdc.demo.model.dto.PostDto;
import com.jdc.demo.model.dto.PostListDto;

public class PostService {

	private DataSource dataSource;
	
	private PhotoService photoService;
	private CommentService commentService;

	public PostService(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		this.photoService = new PhotoService(dataSource);
		this.commentService = new CommentService(dataSource);
	}

	public List<PostListDto> search(String loginId, String keyword) {

		List<PostListDto> result = new ArrayList<>();
		var sql = new StringBuffer("""
				select p.id, p.title, p.post_date, p.memebers_id, m.name, m.loginId from posts p 
				join members m on m.id = p.members_id where 1 = 1""");
		
		var params = new ArrayList<Object>();
		
		if(null != loginId && !loginId.isBlank()) {
			sql.append(" and p.members_id = ?");
			params.add(loginId);
		}
		
		if(null != keyword && !keyword.isBlank()) {
			sql.append(" and lower(p.title) like lower(?)");
			params.add(keyword.concat("%"));
		}

		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql.toString())) {
			
			for(var i = 0; i < params.size(); i ++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var post = getPost(rs);
				result.add(new PostListDto(post, 
						this.photoService.getCoverPhoto(post.id()), 
						this.commentService.getCommentSize(post.id()), 
						this.photoService.getPhotoSize(post.id())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public PostDetailsDto findDetailsById(int id) {

		var sql = """
				select p.id, p.title, p.post_date, p.memebers_id, m.name, m.loginId from posts p 
				join members m on m.id = p.members_id where p.id = ?""";

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return getDetails(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private PostDto getPost(ResultSet rs) throws SQLException {
		return new PostDto(rs.getInt("id"), 
				rs.getString("title"), 
				rs.getTimestamp("post_date").toLocalDateTime(), 
				new MemberDto(rs.getInt("memebers_id"), 
						rs.getString("loginId"), 
						rs.getString("loginId")));
	}

	private PostDetailsDto getDetails(ResultSet rs) throws SQLException {
		var post = getPost(rs);
		return new PostDetailsDto(post, 
				photoService.getPhotos(post.id()), 
				commentService.getComment(post.id()));
	}

}
