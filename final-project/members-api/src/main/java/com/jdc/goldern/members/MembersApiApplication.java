package com.jdc.goldern.members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MembersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersApiApplication.class, args);
	}

}
