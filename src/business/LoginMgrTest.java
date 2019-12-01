package business;

import java.io.IOException;

import domain.Traveler;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import exceptions.WrongPasswordException;
import junit.framework.TestCase;

public class LoginMgrTest extends TestCase {
	private LoginMgr loginMgr;
	private TravelerMgr travelerMgr;
	private void setup() throws ServiceLoadException {
		loginMgr = new LoginMgr();
		travelerMgr = new TravelerMgr();
	}
	
	public void testLogin() {
		try {
			setup();
			Traveler t = new Traveler();
			t.setName("LoginTest Profile");
			t.setUsername("logintestusr");
			t.setPassword("loginT35T");
			travelerMgr.createProfile(t);
			boolean success = loginMgr.login("logintestusr", "loginT35T");
			assertTrue("failed to log in", success);
			System.out.println("LoginMgrTest.testLogin passed!");
		}
		catch (RecordNotFoundException e) { System.out.println(e.getMessage()); }
		catch (WrongPasswordException e) { System.out.println(e.getMessage()); }
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
		catch (IOException e) { System.out.println(e.getMessage()); }
		catch (ClassNotFoundException e) { System.out.println(e.getMessage()); }
	}
}
