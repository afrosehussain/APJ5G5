import java.io.*;
import java.net.*;
import java.util.*;

public class URLDemo
{
	public static void main(String args[])
	{
		try
		{
			System.out.println("Enter the URLbelow:");
			Scanner sc=new Scanner(System.in);
			String msg=sc.nextLine();
			URL url=new URL(msg);
			System.out.println("The information in given url is:"+url);
			System.out.println("Protocol is:"+url.getProtocol());
			System.out.println("Hostname is:"+url.getHost());
			System.out.println("Authority is:"+url.getAuthority());
			System.out.println("Port number is:"+url.getPort());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}