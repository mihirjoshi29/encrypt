package com.mudit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mudit"})
public class EncryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptApplication.class, args);
		System.out.println("spring started");
	}

}
