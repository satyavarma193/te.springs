package com.te.spring_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.spring_rest.beans.EmployeeBean;
import com.te.spring_rest.dao.EmployeeDao;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeDao employee;

	@Override
	public EmployeeBean getEmployeeData(int id) {

		return employee.getEmployeeData(id);
	}

	@Override
	public boolean deleteEmpData(int id) {

		return employee.deleteEmpData(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {

		return employee.getAllEmp();
	}

	@Override
	public boolean addEmpData(EmployeeBean employeeBean) {

		return employee.addEmpData(employeeBean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean employeeBean) {

		return employee.updateEmployee(employeeBean);
	}

}
