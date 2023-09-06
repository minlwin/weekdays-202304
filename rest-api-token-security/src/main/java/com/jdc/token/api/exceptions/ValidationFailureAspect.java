package com.jdc.token.api.exceptions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class ValidationFailureAspect {

	@Pointcut("within(com.jdc.token.api.*)")
	public void apiMethods() {}
	
	@Before(value = "apiMethods() && args(..,result)", argNames = "result")
	public void validationFailureAdvice(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationFailureException(result);
		}
	}
}
