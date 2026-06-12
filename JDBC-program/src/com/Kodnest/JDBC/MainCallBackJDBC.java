package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

@SuppressWarnings("unused")
public class MainCallBackJDBC {	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		java.sql.CallableStatement csmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			
			String sql = "call bank_procedure(?)";
			csmt = conn.prepareCall(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
