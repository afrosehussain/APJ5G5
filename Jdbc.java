// 1. import jdbc package
import java.sql.*;
import oracle.jdbc.driver.*;
//import oracle/sql.*;
// 2. Load and register jdbc diver in driver manager service
public class Jdbc {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public Jdbc(String empid, String empname, String city, String salary, String des, String depid) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            // Load a driver
            OracleDriver d = new OracleDriver();
            // Register the driver in DriverManager
            DriverManager.registerDriver(d);
            // 3. open a connection to a database software
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "admin";
            con = DriverManager.getConnection(url, username, password);
            // 4. create a statement object and prepare a sql command

            PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
            ps.setString(1, empid);
            ps.setString(2, empname);
            ps.setString(3, city);
            ps.setString(4, salary);
            ps.setString(5, des);
            ps.setString(6, depid);
            int i = ps.executeUpdate();
            System.out.println(i + " record inserted");
        }
        // 7. Handle the errors
        catch (Exception e) {
            System.out.println("Connection was unsuccessful");
            e.printStackTrace();
        }
        // 8. close the resultset and statment objects
        finally {
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception ee) {}
        }
        // 9. close the connection
    }
}