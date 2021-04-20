package com.te.springmvc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		webDataBinder.registerCustomEditor(Date.class, dateEditor);

	}// End of initBinder method

	@Autowired
	EmployeeService employee;

	@GetMapping("/emplogin")
	public String getLogin() {
		return "login";
	}// End of getLogin Method

	@PostMapping("/empLogin")
	public String authenticate(int id, String pwd, HttpServletRequest request, ModelMap map) {
		EmployeeBean bean = employee.authenticate(id, pwd);
		if (bean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", bean);
			return "homePage";
		} else {
			map.addAttribute("errmsg", "Invalid credentials");
			return "login";
		}

	}// End of authenticate Method

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getSearchForm Method

	@GetMapping("/empsearch")
	public String getEmpSearch(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean bean = employee.getEmployeeData(id);
			if (bean != null) {
				map.addAttribute("data", bean);
			} else {
				map.addAttribute("msg", "Data not found for id: " + id);
			}
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "login";
		}

	}// End of getEmpSearch Method

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg", "Logout Sucessfully");
		return "login";
	}// End of logout Method

	@GetMapping("/showDeletePage")
	public String getdeleteForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			return "deleteForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}
	}// End of getdeleteForm Method

	@GetMapping("/deleteEmp")
	public String deleteEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			Boolean dataBoolean = employee.deleteEmpData(id);
			if (dataBoolean) {
				map.addAttribute("msg", "Deleted successfully");
			} else {
				map.addAttribute("msg", " Data not found ");
			}
			return "deleteForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of deleteEmp Method

	@GetMapping("/alldata")
	public String getAllEmpData(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			List<EmployeeBean> data = employee.getAllEmp();
			if (data != null) {
				map.addAttribute("data", data);
			} else {
				map.addAttribute("errmsg", "Empty Table");
			}
			return "showAll";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getAllEmpData Method

	@GetMapping("/addemp")
	public String getAddEmpForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			return "addEmpForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getAddEmpForm Method

	@PostMapping("/addingdata")
	public String addingEmpData(EmployeeBean bean, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) throws ParseException {
		if (employeeBean != null) {
			Boolean addData = employee.addEmpData(bean);
			if (addData) {
				map.addAttribute("msg", "Added successfully");
			} else {
				map.addAttribute("msg", " Data not added ");
			}
			return "addEmpForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of addingEmpData Method

	@GetMapping("/updateemp")
	public String getUpdateForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			map.addAttribute("id", employeeBean.getId());
			return "update";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}
	}// End of getUpdateForm Method

	@PostMapping("/updateempdata")
	public String updateEmployee(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean,EmployeeBean bean) {
		if (employeeBean != null) {
			if (employee.updateEmployee(bean)) {
				map.addAttribute("id", employeeBean.getId());
				map.addAttribute("msg", "updated successfully");
			} else {
				map.addAttribute("id", employeeBean.getId());
				map.addAttribute("msg", "Data not updated");
			}
			return "update";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of updateEmployee Method
}
