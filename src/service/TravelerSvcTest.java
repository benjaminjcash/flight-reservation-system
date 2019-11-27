package service;
import domain.Traveler;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class TravelerSvcTest extends TestCase {
	private Factory factory;
	protected void setUp() {
		factory = Factory.getInstance();
	}
	
	public void testFetchProfile() throws ServiceLoadException {
		this.setUp();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		
		Traveler newProfile = new Traveler();
		newProfile.setName("John Doe");
		newProfile.setUsername("herecomesjohnny");
		newProfile.setPassword("doeAD33r");
		try {
			travelerSvc.createProfile(newProfile);
		}
		catch(Exception e) {}
		
		Traveler fetchedTraveler = travelerSvc.fetchProfile("herecomesjohnny");
		
		assertTrue("profile was not created", fetchedTraveler.getName().equals("John Doe"));
		System.out.println("TravelerSvcTest.testFetchProfile passed!");
	}
	
	public void testCreateProfile() throws ServiceLoadException {
		this.setUp();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		
		Traveler newProfile = new Traveler();
		newProfile.setName("John Doe");
		newProfile.setUsername("herecomesjohnny");
		newProfile.setPassword("doeAD33r");
		boolean didCreateProfile = true;
		try {
			didCreateProfile = travelerSvc.createProfile(newProfile);
			assertTrue("profile was not created", didCreateProfile);
		}
		catch(Exception e) {}
		
		System.out.println("TravelerSvcTest.testCreateProfile passed!");
	}
	
	public void testAddPaymentInformation() throws ServiceLoadException {
		this.setUp();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		
		boolean didAddPaymentInfo = travelerSvc.addPaymentInformation("herecomesjohnny", "5729485455625256", "09/22");
		assertTrue("payment info was not added", didAddPaymentInfo);
		
		System.out.println("TravelerSvcTest.testAddPaymentInformation passed!");
	}

}
