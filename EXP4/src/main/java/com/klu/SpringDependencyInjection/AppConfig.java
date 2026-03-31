package com.klu.SpringDependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Student student() {

        // Constructor Injection
        Student s = new Student(202, "Rahul", "Spring Boot", 2);

        // Setter Injection
        s.setCourse("Spring Framework");
        s.setYear(4);

        return s;
	}

}
