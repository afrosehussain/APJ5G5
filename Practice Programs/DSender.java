import java.net.*;  
import java.util.*;

public class DSender{  
  public static void main(String[] args) throws Exception {  
    DatagramSocket ds = new DatagramSocket();  
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a message to send");
    String str = sc.nextLine();  
    InetAddress ip = InetAddress.getByName("D70.cse.com");  
     
    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);  
    ds.send(dp);  
    ds.close();  
  }  
}  