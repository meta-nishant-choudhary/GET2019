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
 * Servlet implementation class Friends
 */
@WebServlet("/Friends")
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friends() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = getConnection();
		Statement stmt = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		String org = request.getParameter("Organization");
		String query = "select * from employee where Organization ='" + org + "' AND id != " + id + ";";
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);
			List<Employee> empList = new ArrayList<Employee>();
			if(res.next()) {
				Employee employee = new Employee();
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getInt("Contact"));
				employee.setOrganization(res.getString("Organization"));
				empList.add(employee);
			}
			request.setAttribute("employee", empList);
			request.getRequestDispatcher("friends.jsp").forward(request, response);
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
			e.printStackTrace();
		}
		return conn;
	}
}
