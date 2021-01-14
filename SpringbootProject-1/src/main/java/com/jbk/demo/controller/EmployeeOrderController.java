package com.jbk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.domain.Employee;
import com.jbk.demo.service.EmployeeService;

@RestController
@RequestMapping("/order")
public class EmployeeOrderController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/desc")
	public ResponseEntity<Employee> desc(){
		List<Employee> list=employeeService.desc();
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

}
