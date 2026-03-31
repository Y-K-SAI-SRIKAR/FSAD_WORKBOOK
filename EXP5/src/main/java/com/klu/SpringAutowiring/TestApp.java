package com.klu.SpringAutowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		 ApplicationContext context =
	                new ClassPathXmlApplicationContext("applicationContext.xml");

	        Student student = context.getBean(Student.class);

	        student.display();
	}
	
}
