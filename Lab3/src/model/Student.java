package model;

import java.util.Scanner;

import view.Validation;

public abstract class Student {
	private String id;
	private String name;
	private Address address;
	
	Scanner sc = new Scanner(System.in);
	public Validation dv = new Validation();

	public Student() {

	}

	public Student(String id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public abstract double avgScore();
	
}
