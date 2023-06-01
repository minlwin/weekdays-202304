package com.jdc.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.demo.model.dto.MemberListDto;

public class MemberService extends AbstractMemberService{
	
	private PostService postService;
	private CommentService commentService;

	public MemberService(DataSource dataSource) {
		super(dataSource);
		postService = new PostService(dataSource);
		commentService = new CommentService(dataSource);
	}

	public List<MemberListDto> findAll() {
		
		List<MemberListDto> result = new ArrayList<>();
		var sql = "select * from members where role = 'Member'";

		try (var conn = dataSource.getConnection(); 
				var stmt = conn.prepareStatement(sql)) {
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var member = getMemberDto(rs);
				result.add(new MemberListDto(member, 
						postService.findCountForMember(member.id()), 
						commentService.findCountForMember(member.id())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
