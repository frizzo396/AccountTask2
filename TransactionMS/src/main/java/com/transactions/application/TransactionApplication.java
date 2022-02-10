package com.transactions.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.transactions.*"})
@EnableJpaRepositories(basePackages = {"com.transactions.repository"})
@EntityScan(basePackages = {"com.common.entities"})
public class TransactionApplication extends SpringBootServletInitializer  {
	
		public static void main(String[] args) {
			SpringApplication.run(TransactionApplication.class, args);
		}
}
