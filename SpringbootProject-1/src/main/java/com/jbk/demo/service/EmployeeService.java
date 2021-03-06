package com.jbk.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jbk.demo.domain.Employee;

public interface EmployeeService {
	
	public List<Employee> loadEmployee();
	
	public List<Employee> loadEmployeeById(int Id);
	
	public List<Employee> findByName(String name);
	
	public String deleteEmpById(int empId);
	
	public String addAllFieldOfEmp(Employee e);
	
	//public Employee update(Employee e,int id);

	//public String updateByEmpId(int id,String name);
	
	public List<Employee> findStatus(String status);
	
	
	public List<Employee> paging(int from,int to);
	
	public List<Employee> rowCount();
	
	public List<Employee> desc();
	
	public List<Employee> lessThan(int id);
	
	public List<Employee> likeName(String name);
	
	public List<Employee> betweenQry(int first,int second);
	
	public List<Employee> andOr(int id,String name);
	
	public String generateReport(String format);
	
	public String generateReport1(String format);
	
	public List<Employee> getActiveEmpList();

	public String generateReport2(String format);
	
	public String read_excel() throws EncryptedDocumentException, InvalidFormatException, IOException;
	
	//public String write_excel();
		
	}
	

	
	

	
