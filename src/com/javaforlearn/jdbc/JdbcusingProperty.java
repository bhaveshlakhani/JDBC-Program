package com.javaforlearn.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import  com.mysql.jdbc.Driver;

public class JdbcusingProperty
{
	public static void main(String[] args)
	{
	
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
		
		//1.Load the Driver
		java.sql.Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//get the db connection via driver
		
		
		String dburl="jdbc:mysql://localhost:3306/test";
		FileReader f=new FileReader("E:\\myjdbc.properties");
		Properties prop=new Properties();
		prop.load(f);
		
		con=DriverManager.getConnection(dburl,prop);
		
		//issue sql query
		
		String query="Select *from Student";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		
		//process result return by mysql query
		
		while(rs.next())
		{
			
			String fname=rs.getString("fname");
			String mname=rs.getString("mname");
			String lname=rs.getString("lname");
			
			System.out.println("first name: "+fname);
			System.out.println("middle name: "+mname);
			System.out.println("last name: "+lname);
			
			
		
		  }
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		finally
		{
			try
			{
		
			if(con!=null)
		
			{
			con.close();
		
			}
		
		if(stmt!=null)
		{
			stmt.close();
		}
		
		if(rs!=null)
		{
			rs.close();
		}
		
	     }
		catch(SQLException e)
		{
			
		}
		
		}
		
	 }	
			
	}
	
	


