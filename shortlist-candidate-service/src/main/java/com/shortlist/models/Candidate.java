package com.shortlist.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Candidate")
public class Candidate {

	@Id
	private String id;
	private String name;
	private String location;
	private float salary;

	private Employer employerDetails;
	
	public Employer getEmployerDetails() {
		return employerDetails;
	}
	public void setEmployerDetails(Employer employerDetails) {
		this.employerDetails = employerDetails;
	}
	public Candidate(String id, String name, String location, float salary, Employer employerDetails) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.salary = salary;
		this.employerDetails = employerDetails;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
