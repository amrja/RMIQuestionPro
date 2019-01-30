package rmiquestion;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import javax.management.remote.rmi.RMIConnectionImpl;

/**
 *
 * @author Amr Jamal
 */
public class Server {
    public static void main(String argv[]) 
    {
        try {
            
            Registry u =java.rmi.registry.LocateRegistry.createRegistry(55882);
           u.rebind ("rmiquestion", new Implementation());
        System.out.println ("Server is ready."); 
        
        
        
        
        }
        
        catch (Exception e) {
            System.out.println ("Server failed: " + e);
        } 
    
    }

}
