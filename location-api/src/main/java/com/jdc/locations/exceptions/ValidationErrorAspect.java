package com.jdc.locations.exceptions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import com.jdc.locations.exceptions.LocationAppException.Type;

@Aspect
@Configuration
public class ValidationErrorAspect {

	@Pointcut("within(com.jdc.locations.api.*)")
	public void apiClasses() {}
	
	@Before(value = "apiClasses() and args(.., result)", argNames = "result")
	public void handle(BindingResult result) {
		if(result.hasErrors()) {
			throw new LocationAppException(Type.Validation, 
					result.getFieldErrors().stream().map(a -> a.getDefaultMessage()).toList());
		}
	}
}
