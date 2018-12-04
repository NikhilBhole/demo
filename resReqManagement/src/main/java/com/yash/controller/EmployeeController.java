package com.yash.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Address;
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
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ManagerService managerService;

	@GetMapping(value = "/profile")
	public String showProfilePage(Model model, HttpSession session) {
		model = getModel((Integer) session.getAttribute("userId"), model);
		return "profile";
	}

	@GetMapping(value = "/showAddAddress")
	public String showAddAddressPage() {
		return "addAddress";
	}

	@GetMapping(value = "/showAddEducation")
	public String showAddEducationPage() {
		return "addEducation";
	}

	@GetMapping(value = "/showAddSkill")
	public String showAddSkillPage() {
		return "addSkill";
	}

	@GetMapping(value = "/showAddExperience")
	public String showAddExperiencePage() {
		return "addExperience";
	}

	@GetMapping(value = "/updateEducation")
	public String showUpdateEducationPage(@RequestParam("id") int educationDetailId, Model model, HttpSession session) {
		model.addAttribute("education", employeeService.getEducationById(educationDetailId));
		return "editEducation";
	}

	@GetMapping(value = "/updateSkill")
	public String showUpdateSkillPage(@RequestParam("id") int skillId, Model model, HttpSession session) {
		model.addAttribute("skill", employeeService.getSkillById(skillId));
		return "editSkill";
	}

	@GetMapping(value = "/updateExperience")
	public String showUpdateExperiencePage(@RequestParam("id") int workExpId, Model model, HttpSession session) {
		model.addAttribute("experience", employeeService.getExperienceById(workExpId));
		return "editExperience";
	}

	@PostMapping(value = "/addAddress")
	public String addAddress(HttpSession session, Model model, @ModelAttribute Address address) {
		if (address == null) {
			model.addAttribute("msg", "please put details...");
			return "addAddress";
		} else {
			address.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.addAddress(address);

			if (returnValue <= 0) {
				model.addAttribute("msg", "please put valid details...");
				return "addAddress";
			} else {
				model.addAttribute("msg", "Address added successfully...");
				return "addAddress";
			}
		}
	}

	@PostMapping(value = "/addEducation")
	public String addEducation(HttpSession session, Model model, @ModelAttribute Education education) {
		if (education == null) {
			model.addAttribute("msg", "please put details...");
			return "addEducation";
		} else {
			education.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.addEducation(education);

			if (returnValue <= 0) {
				model.addAttribute("msg", "please put valid details...");
				return "addEducation";
			} else {
				model.addAttribute("msg", "Address added successfully...");
				return "addEducation";
			}
		}
	}

	@PostMapping(value = "/addSkill")
	public String addSkill(HttpSession session, Model model, @ModelAttribute Skill skill) {
		if (skill == null) {
			model.addAttribute("msg", "please put details...");
			return "addSkill";
		} else {
			skill.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.addSkill(skill);

			if (returnValue <= 0) {
				model.addAttribute("msg", "please put valid details...");
				return "addSkill";
			} else {
				model.addAttribute("msg", "Address added successfully...");
				return "addSkill";
			}
		}
	}

	@PostMapping(value = "/addExperience")
	public String addExperience(HttpSession session, Model model, @ModelAttribute WorkExperience experience) {
		if (experience == null) {
			model.addAttribute("msg", "please put details...");
			return "addExperience";
		} else {
			experience.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.addExperience(experience);

			if (returnValue <= 0) {
				model.addAttribute("msg", "please put valid details...");
				return "addExperience";
			} else {
				model.addAttribute("msg", "Address added successfully...");
				return "addExperience";
			}
		}
	}

	@GetMapping(value = "/deleteSkill")
	public String deleteSkill(@RequestParam("id") int skillId, Model model, HttpSession session) {

		if (skillId < 0) {
			model.addAttribute("msg", "select valid skill");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			int returnValue = employeeService.deleteSkill(skillId);
			if (returnValue <= 0) {
				model.addAttribute("msg", "skill not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "skill deleted..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}
	}

	@GetMapping(value = "/deleteExperience")
	public String deleteExperience(@RequestParam("id") int workExpId, Model model, HttpSession session) {

		if (workExpId < 0) {
			model.addAttribute("msg", "select valid skill");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			int returnValue = employeeService.deleteExperience(workExpId);
			if (returnValue < 0) {

				model.addAttribute("msg", "skill not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "skill deleted..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}

	}

	@GetMapping(value = "/deleteEducation")
	public String deleteEducation(@RequestParam("id") int educationDetailId, Model model,
			HttpSession session) {

		if (educationDetailId < 0) {
			model.addAttribute("msg", "select valid skill");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			int returnValue = employeeService.deleteEducation(educationDetailId);
			if (returnValue < 0) {
				model.addAttribute("msg", "skill not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "skill deleted..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}
	}

	@PostMapping(value = "/updateSkill")
	public String updateSkill(@ModelAttribute Skill skill, @RequestParam("id") int skillId, Model model, HttpSession session) {

		System.out.println("in controller update : "+skill);
		if (skill == null) {
			model.addAttribute("msg", "edit valid skill");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			skill.setSkillId(skillId);
			skill.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.updateSkill(skill);

			if (returnValue <= 0) {
				model.addAttribute("msg", "skill not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "skill updated..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}
	}

	@PostMapping("/updateEducation")
	public String updateEducation(@ModelAttribute Education education, @RequestParam("id") int educationDetailId, Model model, HttpSession session) {

		if (education == null) {
			model.addAttribute("msg", "edit valid education");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			education.setEducationDetailId(educationDetailId);
			education.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.updateEducation(education);

			if (returnValue <= 0) {
				model.addAttribute("msg", "education not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "education updated..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}
	}

	@PostMapping(value = "/updateExperience")
	public String updateExperience(@ModelAttribute WorkExperience experience, @RequestParam("id") int workExpId, Model model, HttpSession session) {

		if (experience == null) {
			model.addAttribute("msg", "edit valid education");
			model = getModel((Integer) session.getAttribute("userId"), model);
			return "profile";
		} else {
			experience.setWorkExpId(workExpId);
			experience.setEmployeeId((Integer) session.getAttribute("userId"));
			int returnValue = employeeService.updateExperience(experience);

			if (returnValue <= 0) {
				model.addAttribute("msg", "education not available");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			} else {
				model.addAttribute("msg", "education updated..");
				model = getModel((Integer) session.getAttribute("userId"), model);
				return "profile";
			}
		}
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
