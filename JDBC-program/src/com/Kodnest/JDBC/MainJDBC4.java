package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainJDBC4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// Driver Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			Thread.sleep(3000);
			
			// Establish Connection.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			Thread.sleep(3000);
			
			// medium creation 
			
			String sql = "delete from batches where id = ?";
			psmt = conn.prepareStatement(sql);
			System.out.println("Enter the Bacth Id");
			int id = sc.nextInt();
			psmt.setInt(1, id);
			
			int rowDeleted = psmt.executeUpdate();
			
			if(rowDeleted == 1) {
				System.out.println(rowDeleted + " row affected");
			} else {
				System.out.println(rowDeleted + " rows affected");
			}
			System.out.println("Querry executed and updated..");
			Thread.sleep(3000);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
				psmt.close();
				sc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Resources closed..");
		}
	}

}
