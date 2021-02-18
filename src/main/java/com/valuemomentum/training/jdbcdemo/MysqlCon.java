package com.valuemomentum.training.jdbcdemo;

import java.sql.*;

public class MysqlCon 
{
	public static void main(String[] args)
	{
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try 
		{
			// Register JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a Connection
			System.out.println("Connecting to Database............");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Ck@jacky9");
			
			//Execute a query
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from employees");
			
			//Extract data from result set
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
				
			}
			rs.close();
			stmt.close();
			con.close();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
