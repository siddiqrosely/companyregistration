package com.mgt.ent.savingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class SavingappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SavingappApplication.class, args);
	}
}