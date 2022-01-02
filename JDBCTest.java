// Import the JDBC package

import java.sql.*;
import oracle.jdbc.driver.*;
/*
sql package -->
DriverManager class
Driver class
Connection interface
Statement interface 
ResultSet interface
driver package --> 
OracleDriver class
*/

// Define Main method class

public class JDBCTest
{
	public static void main(String args[])
	{
		// Create references for all classes and interfaces
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
//step1 load the driver class  
			// 1.a Load a driver
			OracleDriver d=new OracleDriver();
			//1.b Register driver in DriverManager service
			DriverManager.registerDriver(d);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Open a connection to database software 
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="admin";
			
			con = DriverManager.getConnection(url,username,password);
			// 3 Create a statement object and Prepare an SQL statement
			
	PreparedStatement stmt=con.prepareStatement("insert into Department values(?,?)");  
			stmt.setInt(1,101);//1 specifies the first parameter in the query  
			stmt.setString(2,"Pratap");
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
  	}  
}  
