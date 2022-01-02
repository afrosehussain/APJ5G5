import java.rmi.*;
import java.io.*;

public class rmiClient {
	public static void main(String a[]) {
		try {
			int potatoes=0;
			int tomatoes=0;
			int onions=0;
			int spinach=0;
			int carrots=0;			
			totalBill stub=(totalBill)Naming.lookup("rmi://localhost:5556/tejaswini");
			DataInputStream in =new DataInputStream(System.in);
			System.out.println("Enter no. of kgs of potatos: ");
			potatoes=Integer.parseInt(in.readLine());
			System.out.println("Enter no. of kgs of tomatoes: ");
			tomatoes=Integer.parseInt(in.readLine());
			System.out.println("Enter no. of kgs of onions: ");
			onions=Integer.parseInt(in.readLine());
			System.out.println("Enter no. of kgs of spinach: ");
			spinach=Integer.parseInt(in.readLine());
			System.out.println("Enter no. of kgs of carrots: ");
			carrots=Integer.parseInt(in.readLine());
			System.out.println("Total Bill: Rs. "+stub.total(potatoes,tomatoes,onions,spinach,carrots));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}