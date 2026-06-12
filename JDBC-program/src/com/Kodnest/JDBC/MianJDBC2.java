package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MianJDBC2 {

	static Scanner sc = new Scanner(System.in);
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
			
		   // Setting the Medium
			
			String sql = "Select * from batches where name = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			System.out.println("Medium created fr prepared Statement..");
			
			Thread.sleep(3000);
			
			System.out.println("Enter the batch name");
			String name  = sc.next();
			
			
			psmt.setString(1, name);
			ResultSet rs = psmt.executeQuery();
			
			// Displaying the results 
			
			while(rs.next() == true) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3));
				Thread.sleep(3000);
			}
			
			// closing the resources 
			
			conn.close();
			psmt.close();
			rs.close();
			sc.close();
			System.out.println("Resources are closed..");
		}
		
		catch(Exception e) {
			
		}

	}

}
