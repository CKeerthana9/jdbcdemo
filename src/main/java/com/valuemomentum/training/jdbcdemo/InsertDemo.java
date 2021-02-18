package com.valuemomentum.training.jdbcdemo;

import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		
		try 
		{
			// Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Open a Connection
			System.out.println("Connecting to Database............");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Ck@jacky9");
			
			String str="Insert into skills(name)"+"values('HTML5')";
			
			//Execute a query
			stmt=con.createStatement();
			int rowcount=stmt.executeUpdate(str);
			if(rowcount>0)
			{
				System.out.println("Resord Inserted Successfully");
			}
			
			String str1="Select count(id) from skills";
			rs=stmt.executeQuery(str1);
			
			//Extract data from result set
			while(rs.next())
			{
				cnt=rs.getInt(1);
			}
			System.out.println("Total no of records is: "+cnt);
			con.close();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

}
