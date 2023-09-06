package com.jdc.token.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberApi {

	@GetMapping
	String index() {
		return "Hello from Member API";
	}

}
