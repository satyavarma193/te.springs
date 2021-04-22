package com.te.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_boot.beans.EmployeeBean;
import com.te.spring_boot.beans.EmployeeResponse;
import com.te.spring_boot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
	public EmployeeResponse getEmp(int id) {
		EmployeeResponse response = new EmployeeResponse();
		EmployeeBean bean = service.getEmployeeData(id);
		if (bean != null) {
			response.setMsg("sucess");
			response.setStatusCode(100);
			response.setDescription("Employee data found for id: " + id);
			response.setBean(bean);
		} else {
			response.setMsg("sucess");
			response.setStatusCode(100);
			response.setDescription("Employee data found for id: " + id);
		}
		return response;
	}// End of getEmp method

	@GetMapping(path = "/getAllEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public EmployeeResponse getAllEmp() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> bean = service.getAllEmp();
		if (bean != null) {
			response.setMsg("sucess");
			response.setStatusCode(100);
			response.setDescription("Employees data found ");
			response.setEmployeeBeans(bean);
		} else {
			response.setMsg("failure");
			response.setStatusCode(404);
			response.setDescription("Employees  data not found  ");
		}
		return response;
	}// End of getAllEmp method

	@PostMapping(path = "/addEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		Boolean data = service.addEmpData(employeeBean);
		if (data) {
			response.setMsg("sucess");
			response.setStatusCode(100);
			response.setDescription("added sucessfully ");
		} else {
			response.setMsg("failure");
			response.setStatusCode(404);
			response.setDescription("Something went wrong ");
		}
		return response;
	}// End of addEmp method

	@DeleteMapping(path = "/deleteEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(int id) {
		EmployeeResponse response = new EmployeeResponse();
		Boolean data = service.deleteEmpData(id);
		if (data) {
			response.setMsg("sucess");
			response.setStatusCode(100);
			response.setDescription("deleted sucessfully ");
		} else {
			response.setMsg("failure");
			response.setStatusCode(404);
			response.setDescription("Something went wrong ");
		}
		return response;
	}// End of deleteEmp method

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmployee(employeeBean)) {
			response.setStatusCode(100);
			response.setMsg("sucess");
			response.setDescription("Employee data updated sucessfully");
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Something went wrong");
		}
		return response;
	}// End of updateEmp method
}// End of controller class
