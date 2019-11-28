package business;
import service.Factory;
import service.ITravelerSvc;
import domain.Traveler;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class TravelerMgrTest extends TestCase {
	private Factory factory;
	private ITravelerSvc travelerSvc;
	
	public void setUp() throws ServiceLoadException {
		factory = Factory.getInstance();
		travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
	}
	
	public void testFetchProfile() {
		try {
			setUp();
			String username = "sallyskis";
			Traveler profile = travelerSvc.fetchProfile(username);
			String name = profile.getName();
			assertTrue("Did not fetch correct profile", name.equals("Sally Summers"));
			System.out.println("TravelerMgrTest.testFetchProfile passed!");
		}
		catch (ServiceLoadException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void testCreateProfile() {
		try {
			setUp();
			Traveler newProfile = new Traveler();
			newProfile.setUsername("cptest");
			newProfile.setPassword("Testing123");
			
		}
		catch (ServiceLoadException e) {
			
		}
	}
}
