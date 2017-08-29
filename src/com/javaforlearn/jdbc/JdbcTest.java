package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JdbcTest
{
public static void main(String[] args) 
{

	Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;

	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	
	
	try
	{
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		String dburl="jdbc:mysql://localhost:3306/test?user=root&password=root";
	    con=DriverManager.getConnection(dburl);
		
	    
	    
	    
	    String query1="select *from student_info where reg_no=?";
	    
	    pstmt1=con.prepareStatement(query1);
	    pstmt1.setInt(1,Integer.parseInt(args[0]));
	    
	
	    
	    rs1=pstmt1.executeQuery();

	    
	   
	    
	    
	    
     String query2="select *from guardian_info where reg_no=?";
	    
        pstmt2=con.prepareStatement(query2);
	    pstmt2.setInt(1,Integer.parseInt(args[1]));
	    
	 
	    
	    rs2=pstmt2.executeQuery();
	    
	   
	    
	    
       String query3="select *from students_info where reg_no=?";
	    
         pstmt3=con.prepareStatement(query3);
	    pstmt3.setInt(1,Integer.parseInt(args[2]) );
	    
	  
	    
	    rs3=pstmt3.executeQuery();

	    
	   
		
		 
	     if(rs1.next())
	     {
	    	 
	    String reg1 =rs1.getString("reg_no");
	    String fname=rs1.getString("f_name");
	    String lname= rs1.getString("l_name");
	    
	    System.out.println("reg_no "+reg1);
	    System.out.println("first name "+fname);
	    System.out.println("last name "+lname);
	    
	     }
	    
	     else
	     {
	    	 System.out.println("registration is not found for student_info");
	     }
	     
	     
	     if(rs2.next())
	     {
	    	 
	    String reg2 =rs2.getString("reg_no");
	    String fname2=rs2.getString("f_name");
	    String lname2= rs2.getString("l_name");
	    
	    System.out.println("reg_no "+reg2);
	    System.out.println("first name "+fname2);
	    System.out.println("last name "+lname2);
	    
	     }
	    
	     else
	     {
	    	 System.out.println("registration is not found for guardian_info");
	     }
	     
	     if(rs3.next())
	     {
	    	 
	    String reg3 =rs2.getString("reg_no");
	    String fname3=rs2.getString("isadmin");
	    String lname3= rs2.getString("password");
	    
	    System.out.println("reg_no "+reg3);
	    System.out.println("is admin "+fname3);
	    System.out.println("password"+lname3);
	    
	     }
	    
	     else
	     {
	    	 System.out.println("registration is not found for students_info");
	     }  		
	} 
	
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		
		try {
			if(con!=null)
			{
				con.close();
			}
			if(pstmt1!=null)
			{
				pstmt1.close();
			}
			if(pstmt2!=null)
			{
				pstmt2.close();
			}
			if(pstmt3!=null)
			{
				pstmt3.close();
			}
			
			if(rs1!=null)
			{
				rs1.close();
			}
			if(rs2!=null)
			{
				rs2.close();
			}
			if(rs3!=null)
			{
				rs3.close();
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
  }
}
