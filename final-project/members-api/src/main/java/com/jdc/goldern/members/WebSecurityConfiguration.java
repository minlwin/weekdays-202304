package com.jdc.goldern.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdc.goldern.members.model.utils.security.JwtTokenAuthenticationFilter;
import com.jdc.goldern.members.model.utils.security.SecurityExceptionResolver;

@Configuration
@EnableMethodSecurity
@PropertySource(value = "classpath:/jwt-token.properties")
public class WebSecurityConfiguration {
	
	@Autowired
	private SecurityExceptionResolver securityExceptionResolver;
	
	@Autowired
	private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

	@Value("${com.jdc.goldern.members.photo.path}")
	private String photoPath;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());
		http.cors(cors -> {});
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/public/**", "%s/**".formatted(photoPath)).permitAll();
			request.requestMatchers("/customer/**").hasRole("CUSTOMER");
			request.requestMatchers("/employee/**").hasRole("EMPLOYEE");
			request.requestMatchers("/manager/**").hasRole("MANAGER");
			request.requestMatchers("/owner/**").hasRole("OWNER");
			request.anyRequest().denyAll();
		});
		
		http.exceptionHandling(config -> {
			config.accessDeniedHandler(securityExceptionResolver);
			config.authenticationEntryPoint(securityExceptionResolver);
		});
		
		http.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	RoleHierarchy roleHierarchy() {
		var roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy("""
				ROLE_ADMIN > ROLE_OWNER
				ROLE_OWNER > ROLE_MANAGER
				ROLE_MANAGER > ROLE_EMPLOYEE
				ROLE_EMPLOYEE > ROLE_CUSTOMER
				""");
		return roleHierarchy;
	}
	
}
