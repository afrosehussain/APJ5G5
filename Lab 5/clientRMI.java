import java.rmi.*;
import java.io.*;

public class clientRMI {
	public static void main(String a[]) {
		try {
			stringOperations stub=(stringOperations)Naming.lookup("rmi://localhost:5556/afrose");
			DataInputStream in =new DataInputStream(System.in);
			System.out.println("Enter a string: ");
			String s=in.readLine();
			System.out.println("String Length is "+stub.findStringLength(s));
			if(stub.checkPalindrome(s))
				System.out.println(s+" is a Palindrome");
			else
				System.out.println(s+" is not a Palindrome");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}