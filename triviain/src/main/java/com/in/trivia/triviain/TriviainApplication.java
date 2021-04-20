package com.in.trivia.triviain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TriviainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriviainApplication.class, args);
	}

}
