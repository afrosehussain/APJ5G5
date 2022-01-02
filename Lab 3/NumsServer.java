/*a Java Application for client server program using TCP where client 
sends 10 numbers to server program and server program responds with the 
numbers in ascending order to respective client*/
/**********************************************
*Lab session number      : 03
*Type of lab             : In Lab
*Problem No.             : 01
*Programmer              : Afrose
*Date                    : 18/01/2021
*Program name            : NumsServer.java
*Topics                  : Networking programming
************************************************/
import java.io.*;
import java.net.*;
import java.util.*;
public class NumsServer
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			DataInputStream dis =new DataInputStream(s.getInputStream());
			int newNums[] = new int[10];
			for(int i=0;i<10;i++){
				newNums[i] = Integer.parseInt(dis.readUTF());
			}
			Arrays.sort(newNums);
			System.out.println("The given elements in ascending order are: ");
			for(int i=0;i<10;i++){
				System.out.print(newNums[i]+" ");
			}
			System.out.println();
			s.close();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}