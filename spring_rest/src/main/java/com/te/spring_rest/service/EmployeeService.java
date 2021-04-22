package com.te.spring_rest.service;

import java.util.List;

import com.te.spring_rest.beans.EmployeeBean;

public interface EmployeeService {


	public EmployeeBean getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public List<EmployeeBean> getAllEmp();

	public boolean addEmpData(EmployeeBean employeeBean);

	public boolean updateEmployee(EmployeeBean employeeBean);

}
