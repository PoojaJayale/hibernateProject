package com.jbk.demo.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Employee {

	public Employee(int eid, String name, double salary, String profile, String department, String status,
			Date join_date) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.profile = profile;
		this.department = department;
		this.status = status;
		this.join_date = join_date;
	}

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	
	@Column
	@NotNull(message = "Name can not be null...")
	@Pattern(regexp = "^[A-Za-z]+$",message = "No Special Character Allowed...")
	@Size(min =3,max = 8,message = "3-8 character allowed...")
	private String name;
	
	@Column
	private double salary;
	@Column
	private String profile;

	@Column
	private String department;

	@Column
	private String status;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date join_date;
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + ", profile=" + profile + "]";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
