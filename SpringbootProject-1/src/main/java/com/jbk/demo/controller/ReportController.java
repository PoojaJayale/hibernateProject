package com.jbk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/{format}")
	public String generateReport(@PathVariable(name="format") String format) {
		String msg=employeeService.generateReport(format);
		return msg;
		
	}
	
	@GetMapping("/name/{format}")
	public String generateReport1(@PathVariable (name="format") String format) {
		String msg=employeeService.generateReport1(format);
		return msg;
	}
	@GetMapping("/status/{format}")
	public String generateReport2(@PathVariable (name="format") String format) {
		String msg=employeeService.generateReport2(format);
		return msg;
	}

}
