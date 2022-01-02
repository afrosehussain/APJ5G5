import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class stringOperationsRemote extends UnicastRemoteObject implements stringOperations{
	stringOperationsRemote() throws RemoteException{
		super();
	}

	public long findStringLength(String s) {
		return s.length();
	}
	
	public boolean checkPalindrome(String str){
		int i = 0, j = str.length() - 1;
        while (i < j) {
            
            if (str.charAt(i) != str.charAt(j))		// If there is a mismatch
                return false;
            // Increment first pointer and decrement the other
            i++;
            j--;
        } 
        return true;	// Given string is a palindrome
	}
}