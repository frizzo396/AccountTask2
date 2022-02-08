package com.transactions.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class TransactionApplication extends SpringBootServletInitializer  {
	
		public static void main(String[] args) {
			SpringApplication.run(TransactionApplication.class, args);
		}
}
