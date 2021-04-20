package com.te.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvc.exceptions.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public String exceptionHandler(EmployeeException exception, HttpServletRequest request) {
		request.setAttribute("msg", exception.getMessage());
		return "errorPage";

	}

}
