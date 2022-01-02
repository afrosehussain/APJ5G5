/*a simple UDP application with client to server message transmission*/
/**********************************************
*Lab session number      : 04
*Type of lab             : In Lab
*Problem No.             : 01
*Programmer              : Afrose
*Date                    : 08/11/2021
*Program name            : MyServer.java
*Topics                  : Networking programming
************************************************/
import java.io.*;
import java.net.*;

public class MyServer{
	public static void main(String...args){
		try{
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept(); // establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Message from Client: " + str);
			ss.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}