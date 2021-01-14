package com.jbk.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.hql.internal.ast.tree.IdentNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jbk.Exceptions.IdNotValidException;

@ControllerAdvice
public class ServiceValidation{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptio(MethodArgumentNotValidException ex) {
		
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String errorMessage=error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
	});
	return errors;
}
      @ExceptionHandler(IdNotValidException.class)
	public ResponseEntity<String> method1(IdNotValidException exception){
		return new ResponseEntity<String>("Entered id is not found...plz give valid id..",HttpStatus.BAD_REQUEST);
		
	}
	
}