package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "First_Name" , length=20)
	private String fName;
	@Column(name = "Last_Name" , length=20)
	private String lName;
	@Column(name = "City" , length=20)
	private String city;
	@Column(name = "Company_Name" , length=20)
	private String companyName;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", city=" + city + ", companyName="
				+ companyName + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Employee() {
		super();
	}
	public Employee(Integer id, String fName, String lName, String city, String companyName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.city = city;
		this.companyName = companyName;
	}
	
	
}
