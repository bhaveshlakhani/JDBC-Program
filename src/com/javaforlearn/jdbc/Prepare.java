package com.javaforlearn.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class Prepare {

	
	
	public static void main(String[] args) {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://bhavesh-pc:3306/test?user=j2ee&password=j2ee";
			Connection con = DriverManager.getConnection(url);
			String query="select * from student where fname = ?";
			
			PreparedStatement p = con.prepareStatement(query);
			p .setString(1, args[0]);
			
			
			ResultSet rs = p.executeQuery();
			
			while(rs.next())
			
			{
				System.out.println("successfully inserted");
				
				String fname=rs.getString("fname");
				String mname=rs.getString("mname");
				String lname=rs.getString("lname");
				
				System.out.println("first name: "+fname);
				System.out.println("middle name: "+mname);
				System.out.println("last name: "+lname);}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
