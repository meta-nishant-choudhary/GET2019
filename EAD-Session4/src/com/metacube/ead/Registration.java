package com.metacube.ead;

import java.io.IOException;
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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("empName");
		String gender = request.getParameter("gender");	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Integer contact = Integer.parseInt(request.getParameter("contact"));
		String org = request.getParameter("type");
		String query = "insert into employee(Name, gender, Email, password, Contact, Organization) values('" +name+"','"+gender+"','"+email+"','"+password+"',"+contact+",'"+org+"');";
		String fetchQuery = "select id from employee where Email='" + email + "';";
		Connection conn = getConnection();
		if(conn == null) {
			System.exit(0);
		}
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
			Integer id = getResult(fetchQuery);
			if(id == null) {
				System.exit(0);
			}
			request.setAttribute("id", id);
			request.setAttribute("message", "registered successfully");
			request.getRequestDispatcher("vehicle.jsp").forward(request,response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("registration.jsp").forward(request,response);
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "Pra@ajm123");
		} catch (Exception e) {
			e.getMessage();
		}
		return conn;
	}
	
	public Integer getResult(String fetchQuery) {
		Statement stmt = null;
		Connection conn= getConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(fetchQuery);
			if(rs.next()){
				Integer id = rs.getInt("id");
				return id;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();;
		}
		return null;
	}

}
