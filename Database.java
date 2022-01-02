// A Java program that creates a Java Swing GUI application and connects with database for Employee details.
/* 
    Author      :   Afrose
    Date        :   25-10-2021
    Program Name:   Database.java
    Lab Cycle   :   02
    Description :   Java Swings, JDBC
    Topics      :   Driver, Connection, Statement, Resultset, JButton and all other components of Swing
*/
// Import required packages
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import oracle.jdbc.driver.*;
public class Database extends JFrame {
    JPanel p;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JTextField jtf1;
    JTextField jtf2;
    JTextField jtf3;
    JTextField jtf4;
    JTextField jtf5;
    JTextField jtf6;
    public Database() {
        //create it
        p = new JPanel();
        b1 = new JButton("Insert");
        b2 = new JButton("Select by ID");
        b3 = new JButton("Delete");
       // b4 = new JButton("Select by ID");
        l1 = new JLabel("Empid:");
        l2 = new JLabel("Empname:");
        l3 = new JLabel("City:");
        l4 = new JLabel("Salary:");
        l5 = new JLabel("Designation:");
        l6 = new JLabel("Deptid:");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();
        jtf4 = new JTextField();
        jtf5 = new JTextField();
        jtf6 = new JTextField();
        //configure it
        p.setBounds(0, 0, 500, 300);
        p.setLayout(null);
        l1.setBounds(60, 150, 100, 30);
        jtf1.setBounds(200, 150, 150, 30);

        l2.setBounds(60, 200, 100, 30);
        jtf2.setBounds(200, 200, 150, 30);
        l3.setBounds(60, 250, 100, 30);
        jtf3.setBounds(200, 250, 150, 30);
        l4.setBounds(60, 300, 100, 30);
        jtf4.setBounds(200, 300, 150, 30);
        l5.setBounds(60, 350, 100, 30);

        jtf5.setBounds(200, 350, 150, 30);
        l6.setBounds(60, 400, 100, 30);
        jtf6.setBounds(200, 400, 150, 30);

        b1.setBounds(60, 450, 150, 30);
        b2.setBounds(250, 450, 150, 30);
        b3.setBounds(60, 500, 150, 30);
        //b4.setBounds(400, 150, 150, 30);
        b1.addActionListener(new Connector());
        b2.addActionListener(new Connector());
        b3.addActionListener(new Connector());
        //add it
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(jtf1);
        p.add(jtf2);
        p.add(jtf3);
        p.add(jtf4);
        p.add(jtf5);
        p.add(jtf6);
        p.add(b1);
        p.add(b2);
        p.add(b3);
       // p.add(b4);
        add(p);
        //Frame settings
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class Connector implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            String empid = jtf1.getText();
            String empname = jtf2.getText();
            String city = jtf3.getText();
            String salary = jtf4.getText();
            String des = jtf5.getText();
            String depid = jtf6.getText();
            try{
                OracleDriver d = new OracleDriver();
                DriverManager.registerDriver(d);
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String username = "system";
                String password = "admin";
                con = DriverManager.getConnection(url, username, password);
                if (evt.getSource() == b1) {
                    PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
                    ps.setString(1, empid);
                    ps.setString(2, empname);
                    ps.setString(3, city);
                    ps.setString(4, salary);
                    ps.setString(5, des);
                    ps.setString(6, depid);
                    int i = ps.executeUpdate();
                } else if (evt.getSource() == b2) {
                    st = con.createStatement();
                    rs = st.executeQuery("select * from Employee where empid='"+empid+"'");
                    while(rs.next()){
                        jtf1.setText(rs.getString(1));
                        jtf2.setText(rs.getString(2));
                        jtf3.setText(rs.getString(3));
                        jtf4.setText(rs.getString(4));
                        jtf5.setText(rs.getString(5));
                        jtf6.setText(rs.getString(6));
                    }
                } else{
                    st = con.createStatement();
                    st.executeUpdate("delete from Employee where empid='"+empid+"'");
                }
            } catch (Exception e) {
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
            
        }
    }
    public static void main(String args[]) {
        new Database();
    }
}