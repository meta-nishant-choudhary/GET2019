package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = getConnection();
		Statement stmt = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		String query = "select * from employee where id = " + id + ";";
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);
			Employee employee = new Employee();
			if(res.next()) {
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getInt("Contact"));
				employee.setOrganization(res.getString("Organization"));
			}
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		catch(Exception e) {
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
