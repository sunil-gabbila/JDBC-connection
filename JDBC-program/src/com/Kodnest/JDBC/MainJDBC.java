package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MainJDBC {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			
            //	Driver Connection
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");	
			
			Thread.sleep(3000);
			
			//	Establish Connection.
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			
			Thread.sleep(3000);
			
			//	create a medium(Statement)
			
			Statement stmt = conn.createStatement();
			System.out.println("Medium Created...");
			
			Thread.sleep(3000);
			
			// Writing a Query
			
			String sql = "select * from batches";
			
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Querry Written and sent to execute..");
			
			Thread.sleep(3000);
			
			// Displaying the results 
			
			while(rs.next()== true) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3));
				Thread.sleep(3000);
			}
			
			// close the resources 
			
			conn.close();
			stmt.close();
			rs.close();
			
			System.out.println("Resources are closed..");
			
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
