package com.javaforlearn.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Myfirstjdbcprog1
{

	public static void main(String[] args) 
	{
	
		Connection con=null;
		Statement stmt=null;
		Statement stmt1=null;
		
		ResultSet rs=null;
		ResultSet rs1=null;
		try {
			
			
			
			/*
			 * load the driver1
			 * driver class:com.mysql.jdbc.Driver
			 */
			
			
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
		
	    	/*
			 * get db connection via driver
			 * 
			 * dburl format:
			 * 
			 * jdbc:mysql://[host][,failoverhost...][:port]/[database] »
               [?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]
			 * 
			 */
			
			String dburl="jdbc:mysql://localhost:3306/test?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			/*
			 * issue sql query via connection
			 * 
			 */
			String query="Select *from student_info,students_info where student_info.reg_no=students_info.reg_no ";
					  
			stmt=con.createStatement();
			stmt1=con.createStatement();
			
			rs=stmt.executeQuery(query);
			rs1=stmt1.executeQuery(query);
			
			/*
			 * process result return by ql query
			 * 
			 */
			
			while(rs.next() && rs1.next())
			{
				/*
				String regno=rs.getString(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				
				*/
				
				String regno=rs.getString("reg_no");
				String fname=rs.getString("f_name");
				String lname=rs.getString("l_name");
				
				String regno1=rs1.getString("reg_no");
				String isadmin=rs1.getString("isadmin");
				String pass=rs1.getString("password");
				
				
				
			
				System.out.println("reg no:"+regno);
				System.out.println("first name:"+fname);
				System.out.println("last name:"+lname);
				
				System.out.println("is admin ??: "+isadmin);
				System.out.println("password "+pass);

			
			}
			
			
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
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
				if(stmt1!=null)
				{
					stmt1.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
				if(rs1!=null)
				{
					rs1.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
