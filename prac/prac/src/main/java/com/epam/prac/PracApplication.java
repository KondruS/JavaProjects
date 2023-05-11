package com.epam.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracApplication.class, args);
		System.out.println("Welcome");
	}

}
