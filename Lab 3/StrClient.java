// A Client side network program.
/* 

	Author		:	Afrose
	Date		:	01/11/2021
	Program Name:	StrClient.java
	Lab Cycle	:	03
	Description	:	Network Programming
	Topics		:	Socket, ServerSocket, Threads
	
*/
// Import required packages
import java.io.*;
import java.net.*;
import java.util.*;

// Client class
public class StrClient {
	public static void main(String[] args) throws IOException {
		try {
			Scanner scn = new Scanner(System.in);
			Socket s=new Socket("localhost",5056);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	
			while (true) {
				System.out.println(dis.readUTF());
				String tosend = scn.nextLine();
				dos.writeUTF(tosend);
				
				if(tosend.equals("Exit")){
					s.close();
					System.out.println("Connection closed");
					break;
				}

				String received = dis.readUTF();
				System.out.println(received);
			}
			
			scn.close();
			dis.close();
			dos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
