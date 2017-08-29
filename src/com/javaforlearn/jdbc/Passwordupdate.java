package com.javaforlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Passwordupdate
{

	public static void main(String[] args)
	{
		
	 Connection con=null;
	 PreparedStatement pstmt=null;
	
	
  try{ 
	    
	     /*
	      * 1.load the driver
	      */
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
		/*
		 * 2.get the db connection via driver
		 */
		String dburl="jdbc:mysql://localhost:3306/test?user=root&password=root";
	    con=DriverManager.getConnection(dburl);
	    
	    /*
	     * 3.issue sql query via connection
	     */
		String query="update password_info "
	                 + " set current_password=? "
				     + " where user=? and "
	                 + " regno=?";
		
		       pstmt=con.prepareCall(query);
		       
		       pstmt.setString(1,args[2]);
		       pstmt.setString(2,args[1]);
		       pstmt.setInt(3,Integer.parseInt(args[0]));
		       
		       
		       int count=pstmt.executeUpdate();
		   
		      if(count>0)
		      {
		    	  System.out.println("password successfully changed");
		      }
		      else
		      {
		    	  System.out.println("unable to change password, provide right crendential");
		      }
         }
  
        catch(Exception e)
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
				   if(pstmt!=null)
				   {
					   
					  pstmt.close();  
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }  
  
	}
}
