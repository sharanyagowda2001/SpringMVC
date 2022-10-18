package com.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring")
public class MyConfig {
	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sharanya");
		return emf;
	}
}
