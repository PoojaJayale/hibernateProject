package com.jbk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.domain.Employee;
import com.jbk.demo.service.EmployeeService;

@RestController
@RequestMapping("/pagination")
public class EmployeePaginationController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/createdbeforeToday/{from}/{to}")
	public ResponseEntity<Employee> page(@PathVariable int from,@PathVariable int to){
		System.out.println("Employee controller.....");
		
		List<Employee> list=employeeService.paging(from,to);
		if(list.isEmpty()) {
		        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		        return new ResponseEntity(list, HttpStatus.OK);
	
	
		
	}
}
