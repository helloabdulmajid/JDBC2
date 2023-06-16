package com.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Launch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		try
		{
			Scanner s=new Scanner(System.in);
			String sql="insert into advjava1.students(roll,name,phone) values(?,?,?)";  //dynamic incomplete query
			    Connection con=createConnection();
				PreparedStatement p=con.prepareStatement(sql);
				System.out.println("Enter Roll");
				int roll=s.nextInt();
				System.out.println("Enter Name");
				String name=s.next();
				System.out.println("Enter Phone");
				int phone=s.nextInt();
				p.setInt(1,roll);
				p.setString(2,name);
				p.setInt(3,phone);
				int row=p.executeUpdate();
				
				System.out.println(row + "Rows Affected");
			}
		catch(Exception e)
		{
			System.out.println("main method -->catch"+e);
		}
    
	}
	private static Connection createConnection() throws ClassNotFoundException, SQLException {
		//url
		String url ="jdbc:mysql://localhost:3306";    //mysql
		//String url ="jdbc:oracle:thin@localhost:1521:xe";    //oracle
		
		//username
		String username="root";
		//password
		String password="";
		
		//driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");   //mysql driver loading
		// Class.forName("oracle.jdbc.driver.OracleDriver");    //oracle driver loading
		
		//Factory Design Pattern
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
}
