package com.metacube.parkingsystem.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.parkingsystem.entities.Employee;
import com.metacube.parkingsystem.entities.Pass;
import com.metacube.parkingsystem.entities.Vehicle;
import com.metacube.parkingsystem.fascade.EmployeeFascade;
import com.metacube.parkingsystem.fascade.VehicleFascade;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeFascade empfac;
	@Autowired
	VehicleFascade vehfac;
	
	@RequestMapping("/index")
	public String onIndex(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("employee") == null) {
			session.setAttribute("employee", new Employee());
		}
		model.addAttribute("employee", new Employee());
		return "registration_form";
	}
	
	@RequestMapping("/insertEmployee")
	public String enterEmployee(@ModelAttribute("employee") Employee employee ,HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("vehicle") == null) {
			session.setAttribute("vehicle", new Vehicle());
		}
		//password validation
		if(!employee.getPassword().equals(employee.getCpassword())) {
			model.addAttribute("errormessage", "password and confirm password should be same");
			return "registration_form";
		}
		
		List<Employee> empList =  empfac.fetchEmployee();
		for(Employee emp : empList) {
			if(employee.getEmail().equals(emp.getEmail())) {
				model.addAttribute("errormessage", "email already exist");
				return "registration_form";
			}
		}
		
		
		//insert employee in DB
		empfac.insertEmployee(employee);
		int id = empfac.getLastInsertedId();
		Vehicle vehicle = new Vehicle();
		vehicle.setEid(id);
		model.addAttribute("vehicle", vehicle);
		return "vehicle_form";
	}
	
	@RequestMapping("/insertVehicle")
	public String employeeVehicle(@ModelAttribute("vehicle") Vehicle vehicle, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("pass") == null) {
			session.setAttribute("pass", new Pass());
		}
		vehfac.insertVehicle(vehicle);
		Pass pass = new Pass();
		pass.setType(vehicle.getType());
		pass.seteId(vehicle.getEid());
		pass.setvId(vehfac.fetchVehicle());
	
		model.addAttribute("pass", pass);
		return "pass_form";
	}
	
	@RequestMapping("/login")
	public String loginPage(HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping("/logincheck")
	public String loginCheck(HttpServletRequest request, Model model) {
		String email = request.getParameter("Email");
		String password = request.getParameter("password");
		List<Employee> empList =  empfac.fetchEmployee();
		HttpSession session = request.getSession();
		for(Employee emp : empList) {
			if(email.equals(emp.getEmail()) && password.equals(emp.getPassword())) {
				session.setAttribute("email", email);
				session.setAttribute("emp_id", emp.getId());
				model.addAttribute("emp", emp);
				profilepicture(request, model);
				return "homepage";
			}
		}
		model.addAttribute("message", "wrong email and password");
		return "login";
	}
	
	
	@RequestMapping("/homepage")
	public String getEmployeeDetails(@ModelAttribute("employee") Employee employee ,HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("employeeList") == null) {
			session.setAttribute("employeeList", new ArrayList<Employee>());
		}
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList = (ArrayList<Employee>) empfac.fetchEmployee();
		model.addAttribute("employee", employeeList);
		return "homepage";
	}
	
	@ModelAttribute
	public void profilepicture(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		if(session.getAttribute("email")!=null){
			File file = new File("C:\\Users\\Nishant\\Desktop\\parkingsystem\\src\\main\\webapp\\images\\"+session.getAttribute("emp_id").toString()+".jpg");
			if(file.exists()){
				model.addAttribute("image", session.getAttribute("emp_id").toString()+".jpg");
			}
			else{
				model.addAttribute("image", "default.jpg");
			}
		}
	}
	
	@RequestMapping("/changepicture")
	public String changepicture(@RequestParam("image") MultipartFile file,HttpServletRequest request){
		HttpSession session = request.getSession();
		if (!file.isEmpty()) {
		String path=session.getServletContext().getRealPath("/");  
		       String filename=file.getOriginalFilename();  
		      try{  
		       byte barr[]=file.getBytes();  
		         
		       BufferedOutputStream bout=new BufferedOutputStream(  
		                new FileOutputStream(path+"/images/"+session.getAttribute("emp_id").toString()+".jpg"));  
		       bout.write(barr);  
		       bout.flush();  
		       bout.close();  
		         
		       }catch(Exception e){System.out.println(e);}  

		}
		return "homepage";

		}

	
	@RequestMapping("/friend")
	public String getFriendDetails(@RequestParam("id") int id,@RequestParam("Organization") String org, HttpServletRequest request, Model model) {
		List<Employee> friendList =  empfac.fetchFriend(id, org);
		model.addAttribute("friendList", friendList);
		return "friend";
	}
	
	@RequestMapping("/editEmployee")
	public String editEmployee(@RequestParam("id") int id, HttpServletRequest request, Model model) {
		Employee employee = empfac.getEmployeeToEdit(id);
		model.addAttribute("employee", employee);
		return "editEmployee";
	}
	
	@RequestMapping("/UpdateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request, Model model) {
		empfac.updateEmployee(employee);
		Employee emp =  empfac.getEmployeeById(employee.getId());
		model.addAttribute("emp", emp);
		return "homepage";
	}
	
	@RequestMapping("/profile")
	public String profile(@RequestParam("id") int id, HttpServletRequest request, Model model) {
		Employee employee = empfac.getEmployeeToEdit(id);
		model.addAttribute("emp", employee);
		return "profile";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
