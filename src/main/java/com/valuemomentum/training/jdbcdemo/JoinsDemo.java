package com.valuemomentum.training.jdbcdemo;

import java.sql.*;

public class JoinsDemo 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try 
		{
			// Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Open a Connection
			System.out.println("Connecting to Database............");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Ck@jacky9");
			//Execute a query
			stmt=con.createStatement();
			rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  candidate_skills s ON c.id=candidate_id  INNER JOIN  skills sk ON s.skill_id=sk.id  ;");
			
			//Extract data from result set
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
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
