package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample 
{
public static void main(String[] args)
{
	Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	
	try 
	{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	    String db="jdbc:mysql://localhost:3306/test?user=root&password=root";
	    con=DriverManager.getConnection(db);
	    
	    
	    /*
	     * 1.begin transaction by setting con.autocmmit(false) method
	     */
	    con.setAutoCommit(false);
	    
	    
	    /*
	     * 2.issue set of sql query
	     */
	    
	    String query1="insert into student_info values(?,?,?)";
	    pstmt1=con.prepareStatement(query1);
	    
	    pstmt1.setInt(1,Integer.parseInt(args[0]));
	    pstmt1.setString(2,args[1]);
	    pstmt1.setString(3,args[2]);
	     
	    
	    int count1= pstmt1.executeUpdate();
	    
	    System.out.println("rows affected in student_info"+count1);
	    
	
	    
	    
	    String query2="insert into guardian_info values(?,?,?)";
	    pstmt2=con.prepareStatement(query2);
	    
	    pstmt2.setInt(1,Integer.parseInt(args[3]));
	    pstmt2.setString(2,args[4]);
	    pstmt2.setString(3,args[5]);
	     
	   
	    int count2= pstmt2.executeUpdate();
	    
	    System.out.println("rows affected in guardian_info"+count2);
	    
	    
	    
	    //int a=5/0;
	    
	    
	    String query3="insert into students_info values(?,?,?)";
	    pstmt3=con.prepareStatement(query3);
	    pstmt3.setInt(1,Integer.parseInt(args[6]));
	    pstmt3.setString(2,args[7]);
	    pstmt3.setString(3,args[8]);
	     
	    
	    int count3= pstmt3.executeUpdate();
	    
	    System.out.println("rows affected in students_info"+count3);
	    
	
      con.commit();
      System.out.println("profile successfully created ");
	    
	    
	    
	    
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("unable to create profile:");
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
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	
		
	  }
	
	}

}
