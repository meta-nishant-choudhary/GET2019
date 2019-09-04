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
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = getConnection();
			Integer id = Integer.parseInt(request.getParameter("id"));
			String query = "select * from employee where id = " + id;
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);
			Employee emp = new Employee();
			while(res.next()) {
				emp.setId(res.getInt("id"));
				emp.setName(res.getString("Name"));
				emp.setGender(res.getString("gender"));
				emp.setEmail(res.getString("Email"));
				emp.setContact(res.getInt("Contact"));
				emp.setOrganization(res.getString("Organization"));
			}
			request.setAttribute("UpdateEmployee", emp);
			request.getRequestDispatcher("updateEmployee.jsp").forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "Pra@ajm123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
