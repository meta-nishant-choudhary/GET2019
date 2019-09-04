package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PreparedStatement stmt = null;
		
		String dbEmail = null;
		String dbPassword = null;
		Integer id = null;
		try {
			Connection conn = getConnection();
			String email = request.getParameter("Email");
			String password = request.getParameter("password");
			String query = "select * from employee where Email='" + email + "' AND password='" + password + "';";
			Statement stmt = conn.createStatement();
		
			
			ResultSet result =  stmt.executeQuery(query);
			
			Employee emp = new Employee();
			if(result.next()) {
				dbEmail = result.getString("Email");
				dbPassword = result.getString("password");
			}
			result.beforeFirst();
			if(dbEmail.equals(email) && dbPassword.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(1000);
				if(result.next()) {
					emp.setId(result.getInt("id"));
					emp.setName(result.getString("Name"));
					emp.setGender(result.getString("gender"));
					emp.setEmail(dbEmail);
					emp.setPassword(dbPassword);
					emp.setContact(result.getInt("Contact"));
					emp.setOrganization(result.getString("Organization"));
				}
				request.setAttribute("Employee", emp);
				request.getRequestDispatcher("homepage.jsp").forward(request,response);
			}
			request.setAttribute("message","invalid email or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.getMessage();
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
	
}
