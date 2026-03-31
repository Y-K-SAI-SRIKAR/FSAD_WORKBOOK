package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class student {
	@Id
	private int id;
	private String name;
	private int age;
	public student() {
		
	}
	public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	public student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
    

}
