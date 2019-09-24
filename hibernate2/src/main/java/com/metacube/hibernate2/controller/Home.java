package com.metacube.hibernate2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.hibernate2.dto.SearchStudentDto;
import com.metacube.hibernate2.dto.StudentDto;
import com.metacube.hibernate2.entity.StudentEntity;
import com.metacube.hibernate2.services.StudentService;
import com.metacube.hibernate2.util.DtoUtil;


@Controller
public class Home {
	
	@Autowired
	private StudentService studentObj;
	
	@Value("${home.message}")
	private String message;

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("message" ,message);
		return "home";
	}

	@GetMapping("/showStudent")
	public String displayStudent(Model model) {
		model.addAttribute("studentDetails", studentObj.getAll());
		return "showStudent";
		
	}
	

	@GetMapping("/signUp")
	public String doSignUp(Model model) {
		model.addAttribute("studentCommand", new StudentDto());
		return "addStudent";
	}
	
	@PostMapping("/signUp")
	public String doSignupByPost(@ModelAttribute("studentCommand") @Validated StudentDto student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			ObjectError oe = new  ObjectError("Email","Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {
			List<StudentEntity> studentData = studentObj.duplicateEmail(DtoUtil.map(student,StudentEntity.class));
			if(studentData.size()>0) {
				model.addAttribute("succes", "Student Email Exit");
				return "addStudent";
			} 
			studentObj.insertData(DtoUtil.map(student,StudentEntity.class));
			model.addAttribute("succes", "Student Add Succefulyy");
			return "addStudent";
		}
	}

	@GetMapping("/searchStudent") 
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDto());
		return "Search";
	}
	
	
	@PostMapping("/searchStudent") 
	public String searchStudentByPost(@ModelAttribute("SearchCommand") @Validated SearchStudentDto student , BindingResult errorResult , Model model) {
		List<StudentEntity> studentData = studentObj.findByID(DtoUtil.map(student,StudentEntity.class));
		if(studentData.size()>0) {
			model.addAttribute("studentData", studentData);
			return "Search";
		}
		model.addAttribute("succes", "No Student  Find");
		return "Search";
	}
}