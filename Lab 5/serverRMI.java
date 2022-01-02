import java.rmi.*;
import java.rmi.registry.*;
public class serverRMI {
	public static void main(String a[]) {
		try {
			stringOperationsRemote stub=new stringOperationsRemote();
			Naming.rebind("rmi://localhost:5556/afrose",stub);
			System.out.println("Server is ready");
			System.out.println("Object is ready");
		} catch(Exception e){
			System.out.println(e);
		}
	}
}
