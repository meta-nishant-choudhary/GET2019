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

/**
 * Servlet implementation class Pass
 */
@WebServlet("/Pass")
public class Pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pass() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		Integer eid = Integer.parseInt(request.getParameter("emp_id"));
		String type = request.getParameter("v_type");
		Integer vId = Integer.parseInt(request.getParameter("vehicle_id")) ;
		String price = request.getParameter("change");
		String plan = request.getParameter("plan");
		
		String query = "insert into pass(E_id, type, v_id, price, plan) values(" + eid + ",'" + type + "'," + vId +",'" + price + "','" + plan + "');";
		
		try {
			conn = getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
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
