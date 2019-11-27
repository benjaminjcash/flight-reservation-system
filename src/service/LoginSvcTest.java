package service;

import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import exceptions.WrongPasswordException;
import junit.framework.TestCase;

public class LoginSvcTest extends TestCase {
	private Factory factory;
	protected void setUp() {
		factory = Factory.getInstance();
	}
	
	public void testLogin() throws ServiceLoadException {
		this.setUp();
		ILoginSvc loginSvc = (ILoginSvc)factory.getService(ILoginSvc.NAME);
		boolean loggedIn = true;
		try {
			loggedIn = loginSvc.login("herecomesjohnny", "test123");
		}
		catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
			loggedIn = false;
		}
		catch(WrongPasswordException e) {
			System.out.println(e.getMessage());
			loggedIn = false;
		}
		assertTrue("unable to log in", loggedIn);
		System.out.println("LoginSvcTest.testLogin passed!");
	}
}
