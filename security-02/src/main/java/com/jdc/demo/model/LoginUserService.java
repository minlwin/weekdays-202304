package com.jdc.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.LoginUser;

public class LoginUserService {
	
	private DataSource dataSource;
	
	public LoginUserService(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public LoginUser findUserByLoginId(String loginId) {
		
		var sql = "select * from members where loginId = ?";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, loginId);
			
			var rs = stmt.executeQuery();
			
			return getData(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private LoginUser getData(ResultSet rs) throws SQLException {
		
		while(rs.next()) {
			return new LoginUser(rs.getInt("id"), 
					rs.getString("loginId"), 
					rs.getString("name"), 
					rs.getString("role"));
		}
		
		return null;
	}

	public void createMember(String name, String loginId, String password) {
		
		var sql = "insert into members(name, loginId, password, role) values (?, ?, ?, 'Member')";

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, name);
			stmt.setString(2, loginId);
			stmt.setString(3, password);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
