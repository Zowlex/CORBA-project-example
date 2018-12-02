import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA_2_3.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class Server {

	public static void main(String[] args) {
		// init orb
		ORB orb;
		//get poa
		POA poa;
		try {
			orb=(ORB) ORB.init(args,null);
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			//activate poa
			poa.the_POAManager().activate();
			//instance of distant obj
			QuizImpl obj=new QuizImpl();
			//ref jndi
			Context ctx=new InitialContext();
			ctx.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.cosnaming.CNCtxFactory");
			ctx.addToEnvironment("java.naming.provider.url","iiop://localhost:900");
			ctx.rebind("qz",poa.servant_to_reference(obj));
			//start orb
			System.out.println("Server Running...");
			orb.run();
			
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
