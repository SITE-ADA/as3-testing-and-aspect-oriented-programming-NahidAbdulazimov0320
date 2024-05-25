package com.demo.springboot.assignment_three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class AssignmentThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentThreeApplication.class, args);
	}
}
