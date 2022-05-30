package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent"; 
		
		String jdbcUrl = "jdbc:mysql://localhost/web_customer_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get connection
		try {
			PrintWriter out = response.getWriter();
			
			Class.forName(driver);
			
			out.println("\nConnecting to database: \n" + jdbcUrl + "\n\n");
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("\nSUCCESS!!!"); 
			
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
