package com.jdc.goldern.members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.goldern.members.model.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class MembersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersApiApplication.class, args);
	}

}
