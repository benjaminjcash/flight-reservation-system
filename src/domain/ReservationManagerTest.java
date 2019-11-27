package domain;
import junit.framework.TestCase;

public class ReservationManagerTest extends TestCase {
	public void testEquals() {
		System.out.println("starting ReservationManager.testEquals");
		
		ReservationManager rm1 = new ReservationManager();
		rm1.setName("Fred Armisen");
		rm1.setUsername("fred123");
		
		ReservationManager rm2 = new ReservationManager();
		rm2.setName("Carrie Brownstein");
		rm2.setUsername("carrie456");
		
		ReservationManager rm3 = new ReservationManager();
		rm3.setName("Fred Armisen");
		rm3.setUsername("fred123");
		
		assertFalse("rm2 equals rm1", rm2.equals(rm1));
		assertTrue("rm3 does not equal rm11", rm3.equals(rm1));
		
		System.out.println("ReservationManager.testEquals passed!");
	}
	
	public void testValidate() {
		System.out.println("starting ReservationManagerTest.testValidate");
		
		ReservationManager rm1 = new ReservationManager();
		rm1.setName("Tim Heidecker");
		rm1.setUsername("chipy90");
		rm1.setPassword("spaghet!");
		
		assertTrue("rm1 is not a valid traveler", rm1.validate());
		
		ReservationManager rm2 = new ReservationManager();
		rm1.setName("Eric Wareheim");
		rm1.setUsername("white6wine");
		
		assertFalse("rm2 is a valid traveler", rm2.validate());
		
		System.out.println("ReservationManagerTest.testValidate passed!");
	}
}
