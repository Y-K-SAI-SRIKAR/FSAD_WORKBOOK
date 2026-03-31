package com.klu.SpringAutowiring;

import org.springframework.stereotype.Component;

@Component
public class Certification {
	private int id = 101;
    private String name = "Spring Certification";
    private String dateOfCompletion = "12-02-2026";

    public void display() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Date Of Completion: " + dateOfCompletion);
    }

}
