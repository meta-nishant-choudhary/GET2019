package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		ResultSet res = null;
		Connection conn = null;
		Integer rollNo = Integer.parseInt(request.getParameter("roll_no"));
		String firstName = request.getParameter("f_name");
		String lastName = request.getParameter("l_name");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("Email");
		Integer studentClass = Integer.parseInt(request.getParameter("Class"));
		Integer age = Integer.parseInt(request.getParameter("Age"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Pra@ajm123");	
			
			stmt = conn.createStatement();
			String query = "update student_detail set first_name=?, last_name=?, father_name=?, E_mail=?, class=?, Age=? where roll_no="+rollNo;
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, firstName);
			preStmt.setString(2, lastName);
			preStmt.setString(3, fatherName);
			preStmt.setString(4, email);
			preStmt.setInt(5, studentClass);
			preStmt.setInt(6, age);
			
			int rs = preStmt.executeUpdate();
			response.sendRedirect("showStudents");
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
