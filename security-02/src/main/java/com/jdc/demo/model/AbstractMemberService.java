package com.jdc.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.LoginUser;
import com.jdc.demo.model.dto.MemberDto;

public abstract class AbstractMemberService {

	protected DataSource dataSource;

	public AbstractMemberService(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	protected LoginUser getLoginUser(ResultSet rs) throws SQLException {
		
		while(rs.next()) {
			return new LoginUser(rs.getInt("id"), 
					rs.getString("loginId"), 
					rs.getString("name"), 
					rs.getString("role"));
		}
		
		return null;
	}
	
	protected MemberDto getMemberDto(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
