package business;

import java.io.IOException;

import domain.Traveler;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class TravelerMgrTest extends TestCase {
	private TravelerMgr travelerMgr;
	
	public void setUp() throws ServiceLoadException {
		travelerMgr = new TravelerMgr();
	}
	
	public void testFetchProfile() {
		try {
			setUp();
			String username = "sallyskis";
			Traveler profile = travelerMgr.fetchProfile(username);
			String name = profile.getName();
			assertTrue("Did not fetch correct profile", name.equals("Sally Summers"));
			System.out.println("TravelerMgrTest.testFetchProfile passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }	
	}
	
	public void testCreateProfile() {
		try {
			setUp();
			Traveler newProfile = new Traveler();
			newProfile.setUsername("cptest");
			newProfile.setPassword("Testing123");
			newProfile.setName("CP Test");
			boolean success = travelerMgr.createProfile(newProfile);
			assertTrue("Profile was not created", success);
			Traveler profile = travelerMgr.fetchProfile("cptest");
			String name = profile.getName();
			assertTrue("Profile was not found", name.equals("CP Test"));
			System.out.println("TravelerMgrTest.testCreateProfile passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
		catch (ClassNotFoundException e) { System.out.println(e.getMessage()); }
		catch (IOException e) { System.out.println(e.getMessage()); }
	}
	
	public void testDeleteProfile() {
		try {
			setUp();
			Traveler newProfile = new Traveler();
			newProfile.setUsername("cptest");
			newProfile.setPassword("Testing123");
			newProfile.setName("CP Test");
			boolean success = travelerMgr.createProfile(newProfile);
			assertTrue("Profile was not created", success);
			Traveler profile = travelerMgr.fetchProfile("cptest");
			String name = profile.getName();
			assertTrue("Profile was not found", name.equals("CP Test"));
			boolean deleteSuccess = travelerMgr.deleteProfile("cptest");
			assertTrue("Profile was not deleted", deleteSuccess);
			Traveler deletedProfile = travelerMgr.fetchProfile("cptest");
			assertTrue("Profile was not null", deletedProfile == null);
			System.out.println("TravelerMgrTest.testCreateProfile passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
		catch (ClassNotFoundException e) { System.out.println(e.getMessage()); }
		catch (IOException e) { System.out.println(e.getMessage()); }
	}
	
}
