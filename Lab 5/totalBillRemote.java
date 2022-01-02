import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class totalBillRemote extends UnicastRemoteObject implements totalBill {
	totalBillRemote() throws RemoteException {
		super();
	}

	public int total(int potatoes,int tomatoes,int onions,int spinach,int carrots) {
		return potatoes*30+tomatoes*50+onions*40+spinach*20+carrots*35;
	}
}