// an RMI application for getting the final total price of the shopping list.
/* 

	Author		:	Afrose
	Date		:	22/11/2021
	Program Name:	totalBill.java
	Lab Cycle	:	06
	Description	:	RMI Programming
	Topics		:	Remote, stub
	
*/
// Import required packages
import java.rmi.*;

public interface totalBill extends Remote {
	public int total(int potatoes,int tomatoes,int onions,int spinach,int carrots) throws RemoteException;
}
