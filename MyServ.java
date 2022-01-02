import java.net.*;
import java.io.*;
public class MyServ
{
	public static void main(String ar[])
	{
		try
		{
			ServerSocket ss=new ServerSocket(6666);
			
				Socket s=ss.accept();//establishes connection
				DataInputStream dis=new DataInputStream(s.getInputStream());
				String str=(String)dis.readUTF();
				int ms=Integer.parseInt(str);
				int res=1;
				for(int i=1;i<=ms;i++)
				{
					res=res*i;
				}
				String result=res+" ";
				System.out.println( "Factorial of " +ms+ " is " + result);
			
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
