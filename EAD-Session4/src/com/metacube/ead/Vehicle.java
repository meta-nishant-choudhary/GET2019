package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vehicle
 */
@WebServlet("/Vehicle")
public class Vehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Integer number = Integer.parseInt(request.getParameter("number"));
		Integer empId = Integer.parseInt(request.getParameter("employeeid"));
		String identification = request.getParameter("identification");	
		String query = "insert into vehicle(name, type, number, E_id, Identification) values('" + name + "','" + type +"',"+number + "," + empId + ",'" + identification + "');";
		String fetchQuery = "select id from vehicle where number='" + number + "';";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
			ResultSet res = stmt.executeQuery(fetchQuery);
			if(res.next()) {
				request.setAttribute("id", res.getInt("id"));
			}
			
			request.setAttribute("eid", empId);
			request.setAttribute("type", type);
			request.getRequestDispatcher("genratePass.jsp").forward(request,response);
		} catch (Exception e) {
			request.setAttribute("id", empId);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("vehicle.jsp").forward(request,response);
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
