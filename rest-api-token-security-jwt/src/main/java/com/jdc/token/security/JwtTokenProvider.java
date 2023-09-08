package com.jdc.token.security;

import java.security.Key;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {
	
	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	@Value("${com.jdc.jwt.issuer}")
	private String issuer;

	@Value("${com.jdc.jwt.expiration}")
	private int expireAt;

	public Authentication parse(String token) {
		
		if(StringUtils.hasLength(token)) {
			var jws = Jwts.parserBuilder()
				.requireIssuer(issuer)
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token.substring("Bearer ".length()));
			
			var username = jws.getBody().getSubject();
			var authoritieString = jws.getBody().get("roles").toString();
			var authorities = Arrays.stream(authoritieString.split(","))
						.map(a -> new SimpleGrantedAuthority(a))
						.toList();
			
			return UsernamePasswordAuthenticationToken.authenticated(username, null, authorities);
		}
		
		return null;
	}

	public String generate(Authentication authentication) {
		
		if(null != authentication 
				&& authentication.isAuthenticated() 
				&& !(authentication instanceof AnonymousAuthenticationToken)) {
			
			var now = new Date();
			var calendar = Calendar.getInstance();
			calendar.setTime(now);
			calendar.add(Calendar.MINUTE, expireAt);
			
			var jwtToken = Jwts.builder()
					.setIssuer(issuer)
					.setIssuedAt(now)
					.setExpiration(calendar.getTime())
					.setSubject(authentication.getName())
					.claim("roles", authentication.getAuthorities()
							.stream().map(a -> a.getAuthority()).collect(Collectors.joining(",")))
					.signWith(secretKey)
					.compact();
			
			return "Bearer %s".formatted(jwtToken);
		}
		
		return null;
	}
	
}
