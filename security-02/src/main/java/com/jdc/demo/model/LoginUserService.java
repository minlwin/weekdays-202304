package com.jdc.demo.model;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.LoginUser;

public class LoginUserService extends AbstractMemberService{
	
	public LoginUserService(DataSource dataSource) {
		super(dataSource);
	}

	public LoginUser findUserByLoginId(String loginId) {
		
		var sql = "select * from members where loginId = ?";
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, loginId);
			
			var rs = stmt.executeQuery();
			
			return getLoginUser(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
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
