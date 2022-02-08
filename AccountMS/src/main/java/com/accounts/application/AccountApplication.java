package com.accounts.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.accounts.*"})
@EnableJpaRepositories(basePackages = "com.accounts.repository")
@EntityScan("com.accounts.entities")
public class AccountApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	
}