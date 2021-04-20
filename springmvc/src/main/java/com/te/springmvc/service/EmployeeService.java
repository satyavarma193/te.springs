package com.te.springmvc.service;

import java.util.List;

import com.te.springmvc.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public List<EmployeeBean> getAllEmp();
	
	public boolean addEmpData(EmployeeBean employeeBean);
	
	public boolean updateEmployee(EmployeeBean employeeBean);

}
