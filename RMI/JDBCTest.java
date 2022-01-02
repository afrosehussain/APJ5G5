//1)Import JDBC package.
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;
//2)Load and register JDBC driver in driver manager service.
public class JDBCTest
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			
			//Load a driver
			OracleDriver d=new OracleDriver();
			//register the driver in driver manager service.
			DriverManager.registerDriver(d);
			//3)Open a connection to database software.
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="admin";
			con=DriverManager.getConnection(url,username,password);
			//4)Create a statement object and prepare a sql command.
			String query="select * from customer1";
			st=con.createStatement();
			//5)Submit and execute the sql statement which in results in resultant data.
			rs=st.executeQuery(query);
			//6) Process the resultant data via resultSet.
			System.out.println("User details:");
			while(rs.next())
			{
				System.out.println("name:"+rs.getString(1)+" username:"+rs.getInt(2));
			}
		}
		catch(Exception e)
		{
			System.out.println("Connection was unsuccessful");
		}
		finally
		{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("Connection finally");
			}
		}
	}
}




//7)Handle the errors.
//8)close resultSet,close statement object.
//9)close the connection.
