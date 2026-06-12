package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MainJDBC3 {
	static Connection conn;
	static PreparedStatement psmt;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			//	Driver Connection
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			
			
			
			//	Establish Connection.
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			
			Thread.sleep(3000);		
			
			// medium creation 
			
			String sql = "insert into batches values(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			
			System.out.println("Enter the Bacth Id, name, count");
			int id = sc.nextInt();
			String name = sc.next();
			int count = sc.nextInt();
			
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, count);
			
			int rowInSerted = psmt.executeUpdate();
			
			if(rowInSerted == 1) {
				System.out.println(rowInSerted + " row affected");
			} else {
				System.out.println(rowInSerted + " rows affected");
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
