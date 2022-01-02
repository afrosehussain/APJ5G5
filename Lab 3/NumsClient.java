import java.io.*;
import java.net.*;
import java.util.*;
public class NumsClient
{
	public static void main(String args[])
	{
		try
		{
			Socket s=new Socket("localhost",6666);
			DataOutputStream dout =new DataOutputStream(s.getOutputStream());
			int myNums = 0;
			System.out.println("Enter 10 elements: ");
			Scanner sc=new Scanner(System.in);
			for(int i=0;i<10;i++){
				myNums = sc.nextInt();
				dout.writeUTF(Integer.toString(myNums));
			}
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}