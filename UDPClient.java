import java.io.*;
import java.net.*;
public class UDPClient
{
	public static void main(String args[]) throws IOException
	{
		try{
			int outport=8005,inport=8006;
			//datagram socket for establishing the server object connection
			DatagramSocket ds=new DatagramSocket(inport);
			InetAddress ip = InetAddress.getLocalHost();
			//input string from user ----strinput
			String strinput="";
			String stroutput="";
			byte[] bytearray=new byte[1024];
			//reads the character stream of data
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number: ");
			strinput=bf.readLine();
			//for holding the user data in datagram packets 
			DatagramPacket dpout=new DatagramPacket(strinput.getBytes(),strinput.length(),ip,outport);
			ds.send(dpout);
			DatagramPacket dpin=new DatagramPacket(bytearray, bytearray.length);
			ds.receive(dpin);
			stroutput= new String(dpin.getData(),0,dpin.getLength());
			System.out.println(stroutput);
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}