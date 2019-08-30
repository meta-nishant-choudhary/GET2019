package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String query;
		try {
			name = request.getParameter("name");
			if(request.getParameter("type").equals("f_name")) {
				name = request.getParameter("name");
				query = "select * from student_detail where first_name ='" + name+"'";
			}
			else {
				query = "select * from student_detail where last_name = '" + name+"'";
			}
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);
			List<Student> searchedStudent = new ArrayList<Student>();
			while(res.next()) {
				Student student = new Student();
				student.setfName(res.getString("first_name"));
				student.setlName(res.getString("last_name"));
				student.setFatherName(res.getString("father_name"));
				student.setEmail(res.getString("E_mail"));
				student.setStudentClass(res.getInt("class"));
				student.setAge(res.getInt("Age"));
				searchedStudent.add(student);
			}
			if(!searchedStudent.isEmpty()) {
				request.setAttribute("Student", searchedStudent);
				request.getRequestDispatcher("Search.jsp").forward(request,response);
			}
			else {
				request.setAttribute("message", "Student not found");
				request.getRequestDispatcher("Search.jsp").forward(request,response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Pra@ajm123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
