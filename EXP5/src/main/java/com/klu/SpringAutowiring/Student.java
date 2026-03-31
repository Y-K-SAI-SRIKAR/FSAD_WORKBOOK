package com.klu.SpringAutowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	 private int id = 32911;
	    private String name = "Mithun";
	    private String gender = "Male";

	    @Autowired
	    private Certification certification;

	    public void display() {
	        System.out.println("Student ID: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("Gender: " + gender);
	        System.out.println("---- Certification Details ----");
	        certification.display();
	    }
}
