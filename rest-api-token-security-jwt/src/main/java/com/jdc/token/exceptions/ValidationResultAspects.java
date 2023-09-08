package com.jdc.token.exceptions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Configuration
@Aspect
public class ValidationResultAspects {

	@Pointcut(value = "within(com.jdc.token.api.*)")
	public void apiMethods() {}
	
	@Before(value = "apiMethods() and args(..,result)", argNames = "result")
	public void checkResult(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationFailureException(result);
		}
	}
}
