package com.javaforlearn.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Studentupser2
{
public static void main(String[] args) 
{

	    Connection con=null;
	    CallableStatement cstmt=null;
	    
	    ResultSet rs=null;
	    
	    
	
	    try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			
			
			String dburl="jdbc:mysql://localhost:3306/test?user=root&password=root";
			con=DriverManager.getConnection(dburl);

			
			String query="call studentupsert22(8,'neel','patel',8,'rohan','desai',8,'N','abc8')";
			cstmt=con.prepareCall(query);
			
	       	boolean isdbresult=	cstmt.execute();
	       	
	       	
	       	if(isdbresult)
	       	{
	       		System.out.println("result is type of db result");
	       		
	       	  rs=cstmt.getResultSet();
	       	  
	       	  while(rs.next())
	       	  {
	       		String regno=rs.getString("reg_no");
				String fname=rs.getString("f_name");
				String lname=rs.getString("l_name");
				
				
				
				String regno1=rs.getString("reg_no");
				String fname1=rs.getString("f_name");
				String lname1=rs.getString("l_name");
				
				String regno2=rs.getString("reg_no");
				String isadmin=rs.getString("isadmin");
				String pass=rs.getString("password");
				
			   
				System.out.println("registration no: "+regno);
				System.out.println("first name:"+fname);
				System.out.println("last name: "+lname);
				
				System.out.println("---------------------------");
				
				System.out.println("registration no: "+regno);
				System.out.println("first name:"+fname);
				System.out.println("last name: "+lname);
				
				System.out.println("---------------------------");
				
				System.out.println("registration no: "+regno1);
				System.out.println(" gurdian first name:"+fname1);
				System.out.println("guardian last name: "+lname1);
				
				System.out.println("---------------------------");
				
				       		  
	       		  
	       	  }
	
	       	}
	
	       	
	       	else 
	       	{
	       		System.out.println("result is type of integer count");
	       	   
	       		int count=cstmt.getUpdateCount(); 
	       		
	       		System.out.println("no of rows affected: "+count);
	       		
	       	
	       	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
					
					
					if(cstmt!=null)
					{
						cstmt.close();
					}
					
					
					
					
					if(rs!=null)
					{
						rs.close();
					}
					
					
				} 
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  
			}
	
			
	
	
    }
	
}
