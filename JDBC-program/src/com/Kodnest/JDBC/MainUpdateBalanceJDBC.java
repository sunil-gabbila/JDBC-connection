package com.Kodnest.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainUpdateBalanceJDBC {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		try {
			// Driver Connection
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			
			//	Establish Connection.
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/novbatch", "root", "Sunil@2003");
			System.out.println("Connection Established..");
			
			// Medium connection
			
			String sql1 = "Update bank set salary = salary - ? where accNo = ?";
			String sql2 = "Update bank set salary = salary + ? where accNo = ?";
			
			psmt1 = conn.prepareStatement(sql1);
			psmt2 = conn.prepareStatement(sql2);
			
			System.out.println("Enter the from accNo, to accNo and balnce to update");
			int fromAccNo = sc.nextInt();
			int toAccNo = sc.nextInt();
			int amount = sc.nextInt();
			
			psmt1.setInt(1, amount);
			psmt1.setInt(2, fromAccNo);
			psmt2.setInt(1, amount);
			psmt2.setInt(2, toAccNo);
			
			conn.setAutoCommit(false);
			int res1 = psmt1.executeUpdate();
			int res2 = psmt2.executeUpdate();
			
			if(res1 == 1 && res2 == 1) {
				conn.commit();
				System.out.println("Transaction succesfull..");
			}
			else {
				conn.rollback();
				System.out.println("Transaction failed..");
			}
			
			System.out.println("Balance Updated and Transfered from  -> " + res1 + " account to another -> " + res2 + " account");
			
			
		}
		
		catch (Exception e) {
			System.out.println("Some issues occured. Transaction Faied..");
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally {
			sc.close();
			try {
				psmt1.close();
				psmt2.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Resources were Closed..");
		}
	}

}
