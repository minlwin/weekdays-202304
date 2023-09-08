package com.jdc.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:/jwt-token.properties")
public class RestApiTokenSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiTokenSecurityJwtApplication.class, args);
	}

}
