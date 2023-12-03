package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class SbootJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbootJpa2Application.class, args);
	}

}
