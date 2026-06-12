package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainUpdateJDBC5 {

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
			
			String sql = "update batches set count = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			System.out.println("Enter the Bacth name, count");
			int count = sc.nextInt();
			String name = sc.next();
			
			psmt.setInt(3, count);
			psmt.setString(2, name);
			
			int rowUpdate = psmt.executeUpdate();
			
			if(rowUpdate == 1) {
				System.out.println(rowUpdate + " row affected");
			} else {
				System.out.println(rowUpdate + " rows affected");
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
