package com.klu.SpringDependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Bean
        Student student = ctx.getBean("student", Student.class);

        // Print Values
        student.display();
	}

}
