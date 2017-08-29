package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class CallableStatement
{

	public static void main(String[] args)
	{
	
		Connection con=null;
		java.sql.CallableStatement stmt=null;
		ResultSet rs=null;
		
	
		try 
		{
		
			
			/*
			 * load the driver
			 */
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			/*
			 * get db connection via driver
			 */
			
			String url="jdbc:mysql://localhost:3306/test?user=root&password=root";
			con=DriverManager.getConnection(url);
			
			/*
			 * issue sql query via driver
			 */
			
			String query="call studentupsert112(4,'abhishek','manani')";
			
			
			
		//	String query="call studentupsert1(?,?,?)";
			
			stmt=con.prepareCall(query);
			
			/*stmt.setInt(1,Integer.parseInt(args[0]));
			stmt.setString(2,args[1]);
			stmt.setString(3,args[2]);
			*/
			
		  boolean isdbresult = stmt.execute();
					
		  if(isdbresult)	
		  {
			 System.out.println("result is type of dbresult"); 
			 
			rs= stmt.getResultSet();
			 
			 while(rs.next())
			 {
				 
				String regno=rs.getString("reg_no"); 
				String fnm=rs.getString("f_name");
				String lnm=rs.getString("l_name");
			
				
				System.out.println(regno);
				System.out.println(fnm); 
				System.out.println(lnm);
				 
				  
			 }
			 
		  }
		  else
		  {
			  System.out.println("result is type of integer count:");
			
			  int count=stmt.getUpdateCount();
  
			  System.out.println("no of row affected: "+count);
			  
		  }
			
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				if(stmt!=null)
				{
					stmt.close();
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
