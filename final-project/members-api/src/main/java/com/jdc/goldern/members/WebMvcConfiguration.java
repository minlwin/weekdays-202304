package com.jdc.goldern.members;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource(value = "classpath:/catalog.properties")
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Value("${com.jdc.goldern.members.photo.storage}")
	private String photoStorage;
	@Value("${com.jdc.goldern.members.photo.path}")
	private String photoPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("%s/**".formatted(photoPath))
			.addResourceLocations("file:%s".formatted(photoStorage));
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOriginPatterns("*")
			.allowedMethods("*")
			.exposedHeaders("*")
			.allowedHeaders("*");
	}
}
