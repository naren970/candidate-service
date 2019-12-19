package com.shortlist.models;


public class Employer {

	private String companyName;
	private String jobTitle;
	private String jobLocation;
	private float jobSalary;
	
	public Employer(String companyName, String jobTitle, String jobLocation, float jobSalary) {
		super();
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobLocation = jobLocation;
		this.jobSalary = jobSalary;
	}
	
}
