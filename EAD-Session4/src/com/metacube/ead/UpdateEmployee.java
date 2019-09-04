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
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement stmt = null;
		Connection conn = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("Email");
		Integer Contact = Integer.parseInt(request.getParameter("Contact"));
		String org = request.getParameter("organization");
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String query = "update employee set Name=?, Email=?, Contact=?, Organization=? where id=" + id;
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, name);
			preStmt.setString(2, email);
			preStmt.setInt(3, Contact);
			preStmt.setString(4, org);
			
			int rs = preStmt.executeUpdate();
			
			String fetchQuery = "select * from employee where id = " + id;
			Statement stmt2 = conn.createStatement();
			ResultSet res = stmt2.executeQuery(fetchQuery);
			Employee employee = new Employee();
			if(res.next()) {
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getInt("Contact"));
				employee.setOrganization(res.getString("Organization"));
			}
			request.setAttribute("Employee", employee);
			request.getRequestDispatcher("homepage.jsp").forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
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
