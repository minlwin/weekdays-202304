package com.jdc.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdc.token.exceptions.CustomAccessDeinedHandler;
import com.jdc.token.security.JwtTokenAuthenticationFilter;

@Configuration
public class SecurityConfigurations {
	
	@Autowired
	private CustomAccessDeinedHandler customAccessDeinedHandler;
	@Autowired
	private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());
		http.cors(cors -> {});
		http.sessionManagement(session -> 
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.exceptionHandling(handler -> {
			handler.accessDeniedHandler(customAccessDeinedHandler);
		});
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/public/**").permitAll();
			request.requestMatchers("/admin/**").hasAuthority("Admin");
			request.requestMatchers("/member/**").hasAuthority("Member");
			request.anyRequest().denyAll();
		});
		
		http.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
