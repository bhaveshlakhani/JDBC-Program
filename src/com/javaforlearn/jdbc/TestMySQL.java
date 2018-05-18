package com.javaforlearn.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class TestMySQL 
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
		
		

		   String url="jdbc:mysql://localhost:3306/test"+"?user=root&password=root";
	    
		   con=DriverManager.getConnection(url);
		   
		   System.out.println("connection successfull"+con);
		
		
     
		
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
	

