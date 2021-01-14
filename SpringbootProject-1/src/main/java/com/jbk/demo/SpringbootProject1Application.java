package com.jbk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jbk")
public class SpringbootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProject1Application.class, args);
		System.out.println("Hello....");
	}

}
