package com.jdc.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import com.jdc.token.security.JwtTokenProvider;

@SpringBootTest
@WithMockUser(
		username = "admin@gmail.com", 
		authorities = {"Admin", "Read", "Write"})
class RestApiTokenSecurityJwtApplicationTests {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Test
	void tokenGenerationTest() {
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		assertNotNull(authentication);
		assertTrue(authentication.isAuthenticated());
		assertEquals("admin@gmail.com", authentication.getName());
		assertEquals("Admin,Read,Write", 
				authentication.getAuthorities().stream()
					.map(a -> a.getAuthority())
					.collect(Collectors.joining(",")));
		
		var token = jwtTokenProvider.generate(authentication);
		assertNotNull(token);
		
		System.out.println(token);
		
		var parsedResult = jwtTokenProvider.authenticate(token);
		assertEquals("admin@gmail.com", parsedResult.getName());
		assertEquals("Admin,Read,Write", 
				parsedResult.getAuthorities().stream()
					.map(a -> a.getAuthority())
					.collect(Collectors.joining(",")));
		
	}

}
