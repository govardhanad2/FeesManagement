package com.DXC_feesManagementSystem;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Accountant {
	
	public void addStudent(BufferedReader buff) throws SQLException, IOException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		
		PreparedStatement stmtInsert = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name:");
		String name=br.readLine();
		System.out.println("Enter your Email:");
		String email=br.readLine();
		System.out.println("Enter your Course:");
		String course=br.readLine();
		System.out.println("Enter your Fees:");
		String fees=br.readLine();
		System.out.println("Enter your Paid:");
		String paid=br.readLine();
		System.out.println("Enter your Due:");
		String due=br.readLine();
		System.out.println("Enter your Address:");
		String address=br.readLine();
		System.out.println("Enter your City:");
		String city=br.readLine();
		System.out.println("Enter your State:");
		String state=br.readLine();
		System.out.println("Enter your Country:");
		String country=br.readLine();
		System.out.println("Enter your Contact:");
		String contact=br.readLine();
		
		stmtInsert.setString(1,name);
		stmtInsert.setString(2,email);
		stmtInsert.setString(3,course);
		stmtInsert.setString(4,fees);
		stmtInsert.setString(5,paid);
		stmtInsert.setString(6,due);
		stmtInsert.setString(7,address);
		stmtInsert.setString(8,city);
		stmtInsert.setString(9,state);
		stmtInsert.setString(10,country);
		stmtInsert.setString(11,contact);
		System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
	}
	public  void viewStudent(BufferedReader buff) throws SQLException, IOException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from accountant_db");
		while (rs.next())
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4)+
					","+rs.getString(5)+ ", " + rs.getString(6)+ ", " + rs.getString(7)+ ", " + rs.getString(8)
					+ ", " + rs.getString(9)+ ", " + rs.getString(10)+ ", " + rs.getString(11));
		
	}
	public void editStudent(BufferedReader buff) throws SQLException, IOException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		PreparedStatement stmtUpdate = con.prepareStatement("update accountant_db set name=? where name=");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the name you want to update");
		String update=br.readLine();
		stmtUpdate.setString(1,update);
		System.out.println("enter the name you want to replace");
		String replace=br.readLine();
		stmtUpdate.setString(2,replace);
		System.out.println(stmtUpdate.executeUpdate() + " No of Records Updated");

	}
	public  void  dueFees(BufferedReader buff) throws SQLException, IOException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc_jdbc", "root", "Chitti@123");
		String query="select Due from accountant_db where name=?";
		
		PreparedStatement preparedStatement=con.prepareStatement(query);
	
		

		System.out.println("enter student name");
		String name=buff.readLine();
		preparedStatement.setString(1,name);

    
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
		
		String sDue=resultSet.getString("Due");
		
		System.out.println(sDue);
		}
	}
	public  void logOut(BufferedReader buff)
	{
	  System.out.println("You are Loged Out");
	}
}
