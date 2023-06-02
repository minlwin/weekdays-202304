package com.jdc.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.PostPhotoDto;

public class PhotoService {

	private DataSource dataSource;

	public PhotoService(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public PostPhotoDto getCoverPhoto(int id) {
		
		var sql = "select * from posts_photos where posts_id = ? limit 1";

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return getPostPhoto(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public long getCountForPost(int id) {
		var sql = "select count(id) from posts_photos where posts_id = ?";

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

	public List<PostPhotoDto> getPhotos(int id) {
		
		List<PostPhotoDto> result = new ArrayList<>();
		var sql = "select * from posts_photos where posts_id = ?";

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.add(getPostPhoto(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}	
	
	private PostPhotoDto getPostPhoto(ResultSet rs) throws SQLException {
		return new PostPhotoDto(
				rs.getInt("id"), 
				rs.getString("path"), 
				rs.getString("description"));
	}

	public void create(int id, List<String> images) {
		
		var sql = "insert into posts_photos(posts_id, path) values (?, ?) ";

		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql)) {
			
			for(var image : images) {
				stmt.setInt(1, id);
				stmt.setString(2, image);
				
				stmt.addBatch();
			}
			
			stmt.executeBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
