package com.metacube.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.springmvc.entities.Student;

@Controller
public class StudentController {

	@Value("${message.default.welcome}")
	String welcome_message;
	
	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("welcome", welcome_message);
		return "home";
	}
	
	@RequestMapping("/AddStudentDetail")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "AddStudentDetail";
	}
	
	@RequestMapping("/InsertStudent")
	public String insertStudentRecord(@Valid @ModelAttribute("student") Student student,BindingResult result, HttpServletRequest request,Model model) {
		if(result.hasErrors()){
			return "AddStudentDetail";
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("studentList") == null) {
			session.setAttribute("studentList", new ArrayList<Student>());
		}
		ArrayList<Student> student_list = (ArrayList<Student>) session.getAttribute("studentList");
		student_list.add(student);
		session.setAttribute("studentList", student_list);
		model.addAttribute("message","Record Added Successfully");
		return addStudent(model);
	}
	
	@RequestMapping("/ShowAllStudent")
	public String showStudent(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		ArrayList<Student> studentList = (ArrayList<Student>)session.getAttribute("studentList");
		model.addAttribute("studentlist", studentList);
		return "ShowStudent";
	}
	
}
