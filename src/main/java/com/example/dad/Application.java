package com.example.dad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// test lombok
		TestLombok obj = new TestLombok();
		obj.setName("Lombok works!");
		System.out.println(obj.getName());
	}

}
