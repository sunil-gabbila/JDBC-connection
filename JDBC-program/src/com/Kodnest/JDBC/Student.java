package com.Kodnest.JDBC;

public class Student {
	int id;
	String name;
	int age;
	int marks;
	String gender;
	
	public Student(int id, String name, int age, int marks, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + ", gender=" + gender
				+ "]";
	}
	
	
}
