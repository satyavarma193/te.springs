package com.te.spring_rest.dao;

import java.util.List;

import com.te.spring_rest.beans.EmployeeBean;

public interface EmployeeDao {
	

	public EmployeeBean getEmployeeData(int id);

	public boolean deleteEmpData(int id);
	
	public List<EmployeeBean> getAllEmp();
	
	public boolean addEmpData(EmployeeBean employeeBean);
	
	public boolean updateEmployee(EmployeeBean employeeBean);

}
