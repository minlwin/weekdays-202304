package com.jdc.token.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

	@GetMapping("admin")
	String adminHome() {
		return "Hello from Admin";
	}

	@GetMapping("member")
	String memberHome() {
		return "Hello from Member";
	}
}
