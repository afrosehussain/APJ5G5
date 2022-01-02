// A Server side network program that runs more than 1 client to reverse a string.
/* 

	Author		:	Afrose
	Date		:	01/11/2021
	Program Name:	StrServer.java
	Lab Cycle	:	03
	Description	:	Network Programming
	Topics		:	Socket, ServerSocket, Threads
	
*/
// Import required packages
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class StrServer
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(5056);
		
		while (true) {
			Socket s = null;
			try {
				s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				Thread t = new ClientHandler(s, dis, dos);
				t.start();
			}
			catch (Exception e){
				s.close();
				e.printStackTrace();
			}
		}
	}
}

// ClientHandler class
class ClientHandler extends Thread {
	
	final DataInputStream dis;
	final DataOutputStream dos;
	final Socket s;
	
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}

	public void run() {
		String received;
		String toreturn="";
		char ch;
		while (true) {
			try {
				dos.writeUTF("Enter string to reverse:(Type Exit to terminate connection): ");
				
				received = dis.readUTF();
				
				if(received.equals("Exit"))
				{
					System.out.println("Closing this connection.");
					this.s.close();
					System.out.println("Connection closed");
					break;
				}
				toreturn="";
				for (int i=0; i<received.length(); i++) {
		        ch= received.charAt(i); 
		        toreturn= ch+toreturn; 
		      }
				dos.writeUTF(toreturn);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
