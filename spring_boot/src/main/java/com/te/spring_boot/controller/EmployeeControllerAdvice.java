package com.te.spring_boot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.spring_boot.beans.EmployeeResponse;
import com.te.spring_boot.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse exceptionhandler(EmployeeException exception) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(500);
		response.setMsg(exception.getMessage());
		return response;
	}

}
