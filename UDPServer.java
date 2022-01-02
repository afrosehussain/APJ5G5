// a java Application for Datagram server and Client interaction.
/* 

	Author		:	Afrose
	Date		:	08/11/2021
	Program Name:	UDPServer.java
	Lab Cycle	:	04
	Description	:	Network Programming
	Topics		:	UDP, DatagramSocket, DatagramPacket
	
*/
// Import required packages
import java.io.*;
import java.net.*;
public class UDPServer
{
	public static void main(String args[]) throws IOException
	{
		try{
			int port=8005;
			byte[] bytearray=new byte[1024];
			int n=0,flag=0;
			String strinput="";
			String stroutput="";
			DatagramSocket ds= new DatagramSocket(port);
			System.out.println("Server established!!");
			DatagramPacket indp=new DatagramPacket(bytearray, bytearray.length);
			ds.receive(indp);
			strinput=new String(indp.getData(),0,indp.getLength());
			n=Integer.parseInt(strinput);
			stroutput="Prime numbers from 1 to "+n+" is ";
			for(int j=2;j<=n;j++)
        	{ 
            	flag=0;
            	for(int i=2;i<=(j/2);i++)  
            	{  
                	if(j%i==0)  
                	{  
                    	flag=1;  
                    	break;  
                	}  
            	}  
            	if(flag==0)  
            	{  
                	stroutput+=j+" ";  
            	}   
       	 	}	
			
			DatagramPacket dpout = new DatagramPacket(stroutput.getBytes(),stroutput.length(),indp.getAddress(),indp.getPort());
			ds.send(dpout);
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}