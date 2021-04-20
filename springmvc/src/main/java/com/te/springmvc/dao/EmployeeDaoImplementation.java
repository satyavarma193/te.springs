package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.exceptions.EmployeeException;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory factory;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public EmployeeBean authenticate(int id, String password) {

		try {
			manager = factory.createEntityManager();
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("Login Sucess");
					return bean;
				} else {
					System.out.println("wrong password");
					return null;
				}

			} else {
				System.out.println("Invalid credentials");
				throw new EmployeeException("Employee not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		throw new EmployeeException("Employee not found");
	}

	@Override
	public EmployeeBean getEmployeeData(int id) {
		try {
			manager = factory.createEntityManager();
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmpData(int id) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		transaction.begin();
		try {
			if (bean != null) {
				manager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		try {
			manager = factory.createEntityManager();
			String read = " from EmployeeBean ";
			Query query = manager.createQuery(read);
			List<EmployeeBean> data = query.getResultList();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public boolean addEmpData(EmployeeBean employeeBean) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			if (employeeBean != null) {
				manager.persist(employeeBean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeBean employeeBean) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeeBean info = manager.find(EmployeeBean.class, employeeBean.getId());
			if (employeeBean.getName() != null && !employeeBean.getName().isEmpty()) {
				info.setName(employeeBean.getName());
			}
			if (employeeBean.getBirthDate() != null) {
				info.setBirthDate(employeeBean.getBirthDate());
			}
			if (employeeBean.getPassword() != null && !employeeBean.getPassword().isEmpty()) {
				info.setPassword(employeeBean.getPassword());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

}
