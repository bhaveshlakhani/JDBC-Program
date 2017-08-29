package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class PrepareStatement 
{
public static void main(String[] args)
{

	Connection con=null;
	PreparedStatement p =null;
	ResultSet rs=null;
	
	
	/*
	 * load the driver
	 */
	
	try 
	{

		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		/*
		 * get db connection via driver
		 * dburl-
		 * jdbc:mysql://[host:port],[host:port].../[database] »
                     [?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]
		 */
		
		String dburl="jdbc:mysql://bhavesh-pc:3306/test?user=j2ee&password=j2ee";
		con=DriverManager.getConnection(dburl);
		
		/*
		 * issue sql query via driver
		 */
		
		String q = "insert into student(fname,mname,lname) values(?,?,?)";
		
		 p= con.prepareStatement(q);
		 
		 p.setString(1,args[0]);
		 p.setString(2,args[1]);
		 p.setString(3,args[2]);
			
		 
		
			
	  int count= p.executeUpdate();
	  
		
	  System.out.print(count);
	  
	  System.out.print(" row updated");
		/*
		 * process result return by sql query
		 */
		
	/*	if(rs.next())
		{
			
			System.out.println("successfully inserted");
			
			String fname=rs.getString("fname");
			String mname=rs.getString("mname");
			String lname=rs.getString("lname");
			
			System.out.println("first name: "+fname);
			System.out.println("middle name: "+mname);
			System.out.println("last name: "+lname);
			
		}
		else
		{
			System.out.println("entry not found");
		}
		
		*/
	}
	
	catch (Exception e)
    {
		
		e.printStackTrace();
	}
		/*
		 * close all jdbc object
		 */
		
		finally
		{
		
			try {
				if(con!=null)
				{
					con.close();
				}
				if(p!=null)
				{
					p.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
					
		}
		
		
  }
		
}
	
	

