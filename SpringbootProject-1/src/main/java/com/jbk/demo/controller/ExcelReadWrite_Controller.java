package com.jbk.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.service.EmployeeService;

@RestController
@RequestMapping("/excel")
public class ExcelReadWrite_Controller {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/read")
	public String read_excel() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String msg=employeeService.read_excel();
		return msg;
	}
	
	/*@RequestMapping(value="/write")
	public String write_excel()  {
		String msg=employeeService.write_excel();
		return msg;
	}*/

}
