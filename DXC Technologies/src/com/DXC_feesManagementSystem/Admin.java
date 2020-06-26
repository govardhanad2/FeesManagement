package com.DXC_feesManagementSystem;

import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
	
	Scanner sc=new Scanner(System.in);
	String name,password,email,contact;
	public void addAccount(BufferedReader buff) throws SQLException, IOException
	{
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		
		PreparedStatement stmtInsert = con.prepareStatement("insert into admin_db values(?,?,?,?)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name:");
		String name=br.readLine();
		System.out.println("Enter your Password:");
		String password=br.readLine();
		System.out.println("Enter your Email:");
		String email=br.readLine();
		System.out.println("Enter your Contact:");
		String contact=br.readLine();
		
		stmtInsert.setString(1,name);
		stmtInsert.setString(2,password);
		stmtInsert.setString(3,email);
		stmtInsert.setString(4,contact);
		
		System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
	}
	public void viewAccount(BufferedReader buff)throws SQLException, IOException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		Statement stmt = con.createStatement(); // Statement interface used for Creating SQL Query to be executed
		ResultSet rs = stmt.executeQuery("select * from admin_db");
		while (rs.next())
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
		
	}
	public void logOut(BufferedReader buff)
	{
		System.out.println("You are Loged Out");
	}
}