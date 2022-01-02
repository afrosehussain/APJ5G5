//1. import JDBC package
import java.io.*;
import java.sql.*;			//for standard jdbc programs
import oracle.jdbc.driver.*;	//only imports type oracle driver
//import oracle/sql.*;

//2. Load and register JDBC driver in Driver Manager service
public class JDBCTest{
	public static void main(String...args){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
		
		
		//load driver
		OracleDriver d = new OracleDriver();
		
		//register the driver in driver manager service
		DriverManager.registerDriver(d);
			System.out.println("Yepp");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		//3. Open a connection to a database software
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "admin";
		con = DriverManager.getConnection(url,username,password);
		
		//4. Create a statement object and prepare a SQL command
		String query = "Select * from customer1";
		st = con.createStatement();
		
		//5. Submit and execute the SQL statrement which in returns a resultant data
		rs = st.executeQuery(query);
		
		//6. Process the resultant data via ResultSet
		System.out.println("Customer Details");
		while(rs.next()){
			System.out.println("Customer name: "+rs.getString(1)+"                "+"Customer Mobile No: "+rs.getString(2));
		}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}






//7. Handle the errors


//8. Close the ResultSet and Statement objects


//9. Close the connection