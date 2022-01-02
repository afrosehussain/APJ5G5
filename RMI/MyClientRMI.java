import java.rmi.*;
import java.io.*;

public class MyClientRMI{
	public static void main(String...args){
		try{
			int intNumber1 = 0;
			int intNumber2 = 0;
			Adder stub = (Adder)Naming.lookup("rmi://localhost:1099/afrose");
			DataInputStream in = new DataInputStream(System.in);
			System.out.println("Enter number 1: ");
			intNumber1 = Integer.parseInt(in.readLine());
			System.out.println("Enter number 2: ");
			intNumber2 = Integer.parseInt(in.readLine());
			System.out.println(stub.add(intNumber1,intNumber2));
		} catch(Exception e){
			System.out.println(e);
		}
	}
}