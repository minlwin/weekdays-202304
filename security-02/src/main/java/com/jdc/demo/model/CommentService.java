package com.jdc.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.MemberDto;
import com.jdc.demo.model.dto.PostCommentDto;

public class CommentService {
	
	private DataSource dataSource;

	public CommentService(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public long getCommentSize(int id) {
		var sql = "select count(id) from comments where posts_id = ?";

		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return rs.getLong(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PostCommentDto> getComment(int id) {
		
		List<PostCommentDto> result = new ArrayList<>();
		var sql = """
				select c.id, c.details, c.comment_at, c.members_id, m.loginId, m.name  
				from comments c join members m on m.id = c.members_id where c.posts_id = ?
				""";

		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.add(getData(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private PostCommentDto getData(ResultSet rs) throws SQLException {
		return new PostCommentDto(
				rs.getInt("id"), 
				rs.getString("details"), 
				rs.getTimestamp("comment_at").toLocalDateTime(),
				new MemberDto(rs.getInt("members_id"), 
						rs.getString("loginId"), 
						rs.getString("name")));
	}

}
