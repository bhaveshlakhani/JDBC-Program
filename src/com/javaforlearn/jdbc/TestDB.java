package com.javaforlearn.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class TestDB
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
		
	
		     /*
		      * get the db connection via driver
		      * 
		      * 
		      * dburl-protocol:subprotocol:subname
		      * 
		      * sub name consist:
		      * --hostname
		      * --port number;
		      * --db name
		      * --user&password		 
		     */
		
		
		
		
		// String url="jdbc:oracle:thin:@localhost:1521:mkyong","username","password";
	     // String url="jdbc:mysql://bhavesh-pc:3306/test?user=j2ee&password=j2ee";
		
  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:hr", "hr","hr");
		
		
      
		
		
		
		
		/*
		 * 
		 * issues sql query via connection
		 * 
		 */
		
		
		String query="select *from employees";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		
		
		
		
		/*
		 * 
		 * process the result return by sql query
		 */
		
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
	

