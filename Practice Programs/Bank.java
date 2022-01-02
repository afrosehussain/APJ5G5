/***************
    Author		:	Afrose
	Program Name:	Bank.java
	Lab Cycle	:	03
	Description	:	JDBC Connectivity

***************/
import java.sql.*;
import java.util.*;
public class Bank
{
	
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			Scanner sc=new Scanner(System.in);
			
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="admin";
			con=DriverManager.getConnection(url,username,password);
	
			System.out.println("1.Insert new account \n 2.Update records(withdraw or deposit) \n 3.Delete a record\n 4.Retrieve accounts whose balance is 12000\n");
			int num=sc.nextInt();
			switch(num)
			{
				case 1:	System.out.println("Enter Account No of new record:\n");
						int accno=sc.nextInt();
						System.out.println("Enter balance of new record:\n");
						int balance=sc.nextInt();
						System.out.println("Enter Customer name of new record:\n");
						String name=sc.nextLine();
						
						String query1="INSERT INTO banker VALUES(?,?,?)";
						PreparedStatement pt1=con.prepareStatement(query1);
						pt1.setInt(1,accno);
						pt1.setString(3,name);
						pt1.setInt(2,balance);
						int rows1=pt1.executeUpdate();
						if(rows1>0)
							System.out.println("New record inserted succesfull!!!\n");
						else
							System.out.println("New record not inserted!!!!\n");
		
		
						break;
						
				case 2: System.out.println("Enter Account No of the record:");
						int accn=sc.nextInt();
						System.out.println("1.withdraw \n 2.deposit\n");
						String ch=sc.nextLine();
						if(ch.equals("1"))
						{
							System.out.println("Enter how much you want to withdraw:\n");
							int w_amt=sc.nextInt();
							String q1="select amount from banker";
							st=con.createStatement();
							rs=st.executeQuery(q1);
							int bal=rs.getInt(1);
							bal=bal-w_amt;
						
							String query2="UPDATE banker SET amount=? WHERE acc_no=?";
							PreparedStatement pt2=con.prepareStatement(query2);
							pt2.setInt(1,bal);
							pt2.setInt(2,accn);
							int rows2=pt2.executeUpdate();
							if(rows2>0)
								System.out.println("Record updated succesfully!!!! \n");
							else
								System.out.println("Record not updated!!!!\n");
								
							
						}
						else{
							System.out.println("Enter how much you want to deposit:\n");
							int w_amt=sc.nextInt();
							String q1="select balance from Bank";
							st=con.createStatement();
							rs=st.executeQuery(q1);
							int bal=rs.getInt(1);
						
							bal=bal+w_amt;
						
							String query2="UPDATE Bank SET balance=? WHERE acc_no=?";
							PreparedStatement pt3=con.prepareStatement(query2);
							pt3.setInt(1,bal);
							pt3.setInt(2,accn);
							int rows3=pt3.executeUpdate();
							if(rows3>0)
								System.out.println("Record updated succesfully~!!! \n");
							else
								System.out.println("Record not updated!!!\n");
							
						}
						break;
				case 3: System.out.println("Enter Account No of the record:");
						int acc=sc.nextInt();
						String query3="DELETE FROM banker WHERE acc_no=?";
						PreparedStatement pt4=con.prepareStatement(query3);
						pt4.setInt(1,acc);
						int rows=pt4.executeUpdate();
						if(rows>0)
							System.out.println("Record deleted succesfully!!!\n");
						else
							System.out.println("Record not deleted!!!\n");
						break;
				case 4: String query="select * from banker WHERE amount>20000";
						st=con.createStatement();
						rs=st.executeQuery(query);
						System.out.println("Bank Details");
						while(rs.next())
						{
							System.out.println("Account No:"+rs.getString(1)+"\tBalance:"+rs.getString(2));
						}
						break;
		
			}
		}
		catch(Exception ex)
		{
			System.out.println("Connection is unsuccessful");
		}
		finally
		{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	}
}
			



