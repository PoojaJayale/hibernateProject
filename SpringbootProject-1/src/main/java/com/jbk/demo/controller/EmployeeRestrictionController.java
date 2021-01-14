package com.jbk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.domain.Employee;
import com.jbk.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/restriction")
public class EmployeeRestrictionController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/less/{id}")
	public ResponseEntity<Employee> lessThan(@PathVariable int id){
		List<Employee> employee=employeeService.lessThan(id);
		if(employee.isEmpty()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(employee, HttpStatus.OK);
		
	}
	@GetMapping("/like/{name}")
	public ResponseEntity<Employee> likeName(@PathVariable String name){
		List<Employee> list=employeeService.likeName(name);
		if(list.isEmpty()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list, HttpStatus.OK) ;
	}
	
	@GetMapping("/between/{first}/{second}")
	public ResponseEntity<Employee> betweenQry(@PathVariable int first,@PathVariable int second){
		List<Employee> employee=employeeService.betweenQry(first,second);
		if(employee.isEmpty()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(employee,HttpStatus.OK);
		
	}
	
	@GetMapping("/andOr/{first}/{second}")
	public ResponseEntity<Employee> andOr(@PathVariable int id,@PathVariable String name){
		List<Employee> list=employeeService.andOr(id,name);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}
		
	}
