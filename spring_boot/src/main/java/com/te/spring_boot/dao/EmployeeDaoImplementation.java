package com.te.spring_boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.spring_boot.beans.EmployeeBean;
import com.te.spring_boot.exception.EmployeeException;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	EntityManager manager = null;
	EntityTransaction transaction = null;

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
	}// End of getEmployeeData Method

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
	}// End of deleteEmpData Method

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
	}// End of getAllEmp Method

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
			throw new EmployeeException("Already data added");
		} finally {
			if (manager != null) {
				manager.close();
			}
		}

	}// End of addEmpData Method

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
	}// End of updateEmployee Method
}
