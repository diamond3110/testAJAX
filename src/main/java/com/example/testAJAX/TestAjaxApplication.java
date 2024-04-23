package com.example.testAJAX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TestAjaxApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(TestAjaxApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TestAjaxApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigured() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // Разрешаем доступ от всех источников
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешаем указанные методы
						.allowedHeaders("*"); // Разрешаем все заголовки
			}
		};
	}

}
