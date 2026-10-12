package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id, name,  age, marks, geneder");
		Student s = new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next());
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// Driver Loading..
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			
			//	Establish Connection.
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			
			String sql = "insert into student values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s.id);
			psmt.setString(2, s.name);
			psmt.setInt(3, s.age);
			psmt.setInt(4, s.marks);
			psmt.setString(5, s.gender);
			
			int rowInserted = psmt.executeUpdate();
			if(rowInserted == 1) {
				System.out.println(rowInserted + " row affected");
			} else {
				System.out.println(rowInserted + " rows affected");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
				psmt.close();
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Resources closed..");
		}

	}

}
