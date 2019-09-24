package com.metacube.security1.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.security1.dto.StudentForm;
import com.metacube.security1.model.Student;
import com.metacube.security1.repository.StudentRepository;
import com.metacube.security1.util.DTOUtil;


@Controller
public class AppController {
	
	StudentRepository repository;
	
	List<Student> listOfStudents = new ArrayList<>();
	@Value("${home.notice}")
	private String notice;
	
	@Autowired
	public AppController(StudentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "students/login";
    }
	
	/**
	 * Method to show the failure page
	 * @return {String} view name
	 */
	@GetMapping("/failurePage")
	public String showFailurePage()
	{
		return "students/failure_page";
	}
	
	/**
	 * Method to show the home page
	 * @return {String} view name
	 */
	@GetMapping("/home")
	public String showHomePage(Model model)
	{
		model.addAttribute("notice", notice);
		model.addAttribute("message", "Login Succesfull");
		return "students/home";
	}
	
	/**
	 * Method to show the Student Entry Form
	 * @return {String} view name
	 */
	@GetMapping("/home/studentForm")
	public String showUserForm(Model model) 
	{
		model.addAttribute(new StudentForm());
		return "students/student_form"; 
	}
	
	/**
	 * Method to show the details entered in Student Entry Form
	 * @return {String} view name
	 */
	@PostMapping("/home/studentForm")
	public String signUp(@Validated StudentForm student, BindingResult result, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "students/student_form";
		}
		else
		{
			if(repository.findByEmailContainingIgnoreCase(student.getEmail()).size()!=0)
			{
				attribute.addFlashAttribute("message", "Student already exist");
			}
			else
			{
				repository.save(DTOUtil.map(student, Student.class));
				attribute.addFlashAttribute("message", "Student added");
			}
			return "redirect:/home";
		}
	}
	
	
	@GetMapping("/home/showStudents")
	public String showStudents(Model model)
	{
		List<Student> studentList = new ArrayList<>();
		studentList = repository.findAll();
		model.addAttribute("students", studentList);
		return "students/student_list";
	}
}