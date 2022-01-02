import java.rmi.*;
import java.rmi.registry.*;

public class MyServerRMI{
	public static void main(String...args){
		try{
			Adder stub = new AdderRemote();
			Naming.rebind("rmi://localhost:9999/afrose",stub);
			System.out.println("Server is ready");
			System.out.println("Remote object is ready");
		} catch(Exception e){
			System.out.println(e);
		}
	}
}