package com.yash.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;
import com.yash.service.EmployeeService;
import com.yash.service.ManagerService;

@Controller
@Scope("session")
@SessionAttributes("userId")
@RequestMapping(value = "/user")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/managerProfile")
	public String showManagerProfilePage(Model model, HttpSession session) {
		model = getModel((Integer) session.getAttribute("userId"), model);
		return "managerProfile";
	}

	@GetMapping(value = "/showEmployeeList")
	public String showEmployeeListPage(Model model) {

		List<Employee> employeeList = managerService.getAllEmployee();
		//Employee newEmployee = (Employee) employeeList.stream().filter(employee -> employee.getDesignation().equalsIgnoreCase("manager"));
		
		if (employeeList.isEmpty()) {
			model.addAttribute("msg", "there is no employee available");
			return "employeeList";
		} else {
			model.addAttribute("employeeList", employeeList);
			return "employeeList";
		}
	}

	@GetMapping(value = "/employeeProfile")
	public String showEmployeeProfilePage(@RequestParam("id") int userId, Model model) {
		Employee employee = managerService.getEmployeeById(userId);
		List<WorkExperience> experienceList = managerService.getExperienceListById(userId);
		List<Skill> skillList = managerService.getSkillListById(userId);

		model.addAttribute("employee", employee);
		model.addAttribute("experienceList", experienceList);
		model.addAttribute("skillList", skillList);

		return "employeeProfile";
	}
	
	private Model getModel(int employeeId, Model model) {

		Employee employee = employeeService.getEmployeeById(employeeId);

		List<WorkExperience> experienceList = managerService.getExperienceListById(employee.getEmployeeId());
		System.out.println("experience list size : " + experienceList.size());
		List<Skill> skillList = managerService.getSkillListById(employee.getEmployeeId());
		System.out.println("skill list size : " + skillList.size());
		List<Education> educationList = managerService.getEducationListById(employee.getEmployeeId());
		System.out.println("education list size : " + educationList.size());

		model.addAttribute("employee", employee);
		model.addAttribute("experienceList", experienceList);
		model.addAttribute("skillList", skillList);
		model.addAttribute("educationList", educationList);

		return model;
	}

}
