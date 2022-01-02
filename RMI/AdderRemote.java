import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AdderRemote extends UnicastRemoteObject implements Adder{
	AdderRemote() throws RemoteException{
		super();
	}
	
	public int add(int x, int y) throws RemoteException{
		return (x+y);
	}
}