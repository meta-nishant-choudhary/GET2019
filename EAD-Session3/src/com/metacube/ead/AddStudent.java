package com.metacube.ead;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rollNo = Integer.parseInt(request.getParameter("roll_no"));
		String firstName = request.getParameter("f_name");
		String lastName = request.getParameter("l_name");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("Email");
		Integer studentClass = Integer.parseInt(request.getParameter("Class"));
		Integer age = Integer.parseInt(request.getParameter("Age"));
		String query = "insert into student_detail values(" + rollNo + ",'" + firstName + "','" + lastName + "','" + fatherName + "','" + email + "'," + studentClass + "," + age + ")";
		int res = addStudent(query);
		if(res>0){
			request.setAttribute("message", "record inserted successfully");
		}
		else{
			request.setAttribute("message", "roll no/email already exist");
		}
		request.getRequestDispatcher("AddStudent.jsp").forward(request,response);
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
	
	public int addStudent(String query) {
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
  