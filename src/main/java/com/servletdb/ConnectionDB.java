package com.servletdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	

	 public Connection dbConnection() throws ClassNotFoundException, SQLException
	 {
		 Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
			
		 Connection con=DriverManager.getConnection( "jdbc:mysql://root@localhost:3306/JavaServletCURDOp","root","Password@123"); //create connection 
		return con;
		 
		 
	 }
	
}

