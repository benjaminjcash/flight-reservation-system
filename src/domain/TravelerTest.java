package domain;
import junit.framework.TestCase;

public class TravelerTest extends TestCase {
	public void testEquals() {
		System.out.println("starting TravelerTest.testEquals");
		
		Traveler t1 = new Traveler();
		t1.setName("Billy Bob");
		t1.setUsername("fisherman73");
		
		Traveler t2 = new Traveler();
		t2.setName("Sally Winter");
		t2.setUsername("skibunny87");
		
		Traveler t3 = new Traveler();
		t3.setName("Billy Bob");
		t3.setUsername("fisherman73");
		
		assertFalse("t2 equals t1", t2.equals(t1));
		assertTrue("t3 does not equal t1", t3.equals(t1));
		
		System.out.println("TravelerTest.testEquals passed!");
	}
	
	public void testValidate() {
		System.out.println("starting TravelerTest.testValidate");
		
		Traveler t1 = new Traveler();
		t1.setName("Francis Drake");
		t1.setAddress("123 Easy Street, Plentywood, MT 59254");
		t1.setUsername("seafarer96");
		t1.setPassword("Devon1540");
		
		assertTrue("t1 is not a valid traveler", t1.validate());
		
		Traveler t2 = new Traveler();
		t1.setName("Willy Wonka");
		t1.setUsername("chocolate4ever");
		t1.setPassword("oompaloompa");
		
		assertFalse("t2 is a valid Traveler", t2.validate());
		
		System.out.println("TravelerTest.testEquals passed!");
	}
}
