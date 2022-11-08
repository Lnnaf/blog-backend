//package com.nvlinh.blog.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class CORSConfiguration {
//	@Bean
//	public WebMvcConfigurationSupport corsConfigurer() {
//		return new WebMvcConfigurationSupport() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("PUT", "DELETE");
//			}
//		};
//	}
//}
