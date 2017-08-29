package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle_DBTest 
{


	public static void main(String[] args) throws ClassNotFoundException
	{
	
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try
		{
			
			/*
			 * load the driver
			 */
			
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:hr", "hr","hr");
		
		

		
		
		String query="select *from employees";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		
		
		while(rs.next())
		{
			String fname=rs.getString("first_name");
			
			
			
			System.out.println("first name:"+fname);
		
			
			System.out.println("-----------------------------------------");
			
				
		}
		
		}
		catch(SQLException e)
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
				e.printStackTrace();
			 }
			
		
			}
					
		}
	
}
