// an RMI client server String operations application.
/* 

	Author		:	Afrose
	Date		:	15/11/2021
	Program Name:	stringOperations.java
	Lab Cycle	:	05
	Description	:	RMI Programming
	Topics		:	Remote, stub
	
*/
// Import required packages
import java.rmi.*;

public interface stringOperations extends Remote
{
	public long findStringLength(String s) throws RemoteException;  //returns length of a String parameter
	public boolean checkPalindrome(String s) throws RemoteException; //determines whether a String parameter is palindrome or not
}

 