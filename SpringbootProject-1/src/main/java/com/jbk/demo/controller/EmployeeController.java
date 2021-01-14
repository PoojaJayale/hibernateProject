package com.jbk.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.demo.domain.Employee;
import com.jbk.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/load")
	public ResponseEntity<Employee> getEmployee() {
		List<Employee> list=employeeService.loadEmployee();
		if(list==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity(list, HttpStatus.OK);
			}
	}
	
	@GetMapping("/loadid/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) {
		System.out.println("getId :"+id);
		List<Employee> employee= employeeService.loadEmployeeById(id);
		
		if(employee==null) {
			return	new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity(employee,HttpStatus.OK);
		}
	}
	
	 @GetMapping(value = "/loadname/{name}")
	    public ResponseEntity<Employee>getUserByName(@PathVariable("name")String name)
	    {
	    List<Employee> employee=employeeService.findByName(name);
	    	if(employee.isEmpty())
	    	{
	            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

	    	}
			return new ResponseEntity( employee,HttpStatus.OK);
	    }
	
	@DeleteMapping(value = "/employees/{empId}")
	public String deleteEmpById(@PathVariable int empId) {
		System.out.println("deleteById in controller....");
		return employeeService.deleteEmpById(empId);
	}
	
	@PostMapping("/addallFieldOfEmp")
	public ResponseEntity<?> addAllFieldOfEmployee(@Valid @RequestBody Employee e) {
		System.out.println("AddallFieldofEmp in Controller....");
        employeeService.addAllFieldOfEmp(e);
        return ResponseEntity.ok("User is valid");
    
	}
	
	/* @PutMapping(value="/update", headers="Accept=application/json")
	    public ResponseEntity<String> updateUser(@RequestBody Employee e)
	    {
	        System.out.println("sd");
	       Employee employee = employeeService.update(e);
	        if (e==null) {
	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        }
	        else {
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }
	    }*/

	/*@RequestMapping("/updateByEmpId/{id},{name}")
	public String updateEmployeeById(@PathVariable int id,@PathVariable String name) {
		System.out.println("updatedById in Controller.....");
		return employeeService.updateByEmpId(id,name);
	}*/
	
	@GetMapping(value = "/status/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getStatus(@PathVariable("status") String status)
	{
		List<Employee> employee=employeeService.findStatus(status);
		if(employee==null)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(employee,HttpStatus.OK);
		
	}
	
//	@GetMapping(value = "/status/active",produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Employee> getActiveEmpList()
//	{
//		List<Employee> employee=employeeService.getActiveEmpList();
//		if(employee==null)
//		{
//			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity(employee,HttpStatus.OK);
//		
//	}
//	
//	
	
	
	
	
	    }

	

