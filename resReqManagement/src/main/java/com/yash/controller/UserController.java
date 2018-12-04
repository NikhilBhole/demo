package com.yash.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;
import com.yash.service.ManagerService;
import com.yash.service.UserService;

@Controller
@Scope("session")
@SessionAttributes("userId")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ManagerService managerService;

	@GetMapping(value = "/home")
	public String showHomePage() {
		return "home";
	}

	@GetMapping(value = "/userLogin")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping(value = "/userRegistration")
	public String showRegistrationPage() {
		return "userRegistration";
	}

	@GetMapping(value = "/logout")
	public String logoutApplication(HttpSession session) {
		session.invalidate();
		return "home";
	}

	@PostMapping(value = "/login")
	public String showProfilePage(HttpSession session, Model model, @RequestParam("loginName") String userName,
			@RequestParam("password") String password) {

		if (userName == null && password == null) {
			return "login";
		} else {
			Employee employee = userService.userLogin(userName, password);
			System.out.println("employee.getDesignation() == \"manager\" : "
					+ employee.getDesignation().equalsIgnoreCase("manager"));

			if (employee == null) {
				return "login";
			} else if (employee.getDesignation().equalsIgnoreCase("manager")
					|| employee.getDesignation().equalsIgnoreCase("Manager")
					|| employee.getDesignation().equalsIgnoreCase("MANAGER")) {
				System.out.println("in login manager profile :" + employee);
				session.setAttribute("userId", employee.getEmployeeId());
				session.setAttribute("userName", employee.getFirstName());
				session.setMaxInactiveInterval(30 * 60);
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
				System.out.println("session attribute " + session.getAttribute("userName"));
				return "managerProfile";
			} else {
				System.out.println("in controller : " + employee);
				session.setAttribute("userId", employee.getEmployeeId());
				session.setAttribute("userName", employee.getFirstName());
				session.setMaxInactiveInterval(30 * 60);
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
				System.out.println("session attribute " + session.getAttribute("userName"));
				return "profile";
			}
		}
	}

	@PostMapping(value = "/registration")
	public String userRegistration(@ModelAttribute Employee employee) {
		if (employee == null) {
			return "userRegistration";
		} else {
			int returnValue = userService.userRegistration(employee);

			if (returnValue < 0) {
				return "userRegistration";
			}

			return "login";
		}
	}

}
