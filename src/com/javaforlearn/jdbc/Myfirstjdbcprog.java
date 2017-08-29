package com.javaforlearn.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Myfirstjdbcprog 
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
			
			
		Driver rf1 = new Driver();
		DriverManager.registerDriver(rf1);
		
	
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
		
		
		
		
		//String url="jdbc:mysql://localhost:3306/test"+"?user=j2ee&password=j2ee";
	      String url="jdbc:mysql://bhavesh-pc:3306/test?user=j2ee&password=j2ee";
		
		con=DriverManager.getConnection(url);
		
		
      
		
		
		
		
		/*
		 * 
		 * issues sql query via connection
		 * 
		 */
		
		
		String query="select *from student";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		
		
		
		
		/*
		 * 
		 * process the result return by sql query
		 */
		
		while(rs.next())
		{
			String fname=rs.getString("fname");
			String mname=rs.getString("mname");
			String lname=rs.getString("lname");
			
			
			
			System.out.println("first name:"+fname);
			System.out.println("middle name:"+mname);
			System.out.println("last name:"+lname);
			
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
	

