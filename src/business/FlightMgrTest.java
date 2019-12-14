package business;

import java.time.LocalDateTime;
import java.time.Month;

import domain.Flight;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class FlightMgrTest extends TestCase {
	private FlightMgr flightMgr;
	
	private void setup() throws ServiceLoadException {
		flightMgr = new FlightMgr();
	}
	
	public void testPublishFlight() {
		try {
			setup();
			Flight f = flightMgr.createFlight("888", "AS", "ANC", LocalDateTime.of(2020, Month.JANUARY, 13, 13, 00), 
					"SEA", LocalDateTime.of(2020, Month.JANUARY, 13, 18, 00), 1200, 950);
			boolean success = flightMgr.publishFlight(f);
			assertTrue("flight was not published", success);
			flightMgr.deleteFlight("888");
			System.out.println("FlightMgrTest.testPublishFlight passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
	}
	
	public void testFetchFlight() {
		try {
			setup();
			Flight f = flightMgr.createFlight("999", "AA", "CRW", LocalDateTime.of(2020, Month.JANUARY, 16, 17, 00), 
					"IAD", LocalDateTime.of(2020, Month.JANUARY, 16, 18, 50), 200, 150);
			flightMgr.publishFlight(f);
			Flight ff = flightMgr.fetchFlight("999");		
			assertTrue("flight was not found", f.equals(ff));
			flightMgr.deleteFlight("999");
			System.out.println("FlightMgrTest.testFetchFlight passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
	}
	
	public void testDeleteFlight() {
		try {
			setup();
			Flight f = flightMgr.createFlight("003", "DL", "CPR", LocalDateTime.of(2020, Month.JANUARY, 17, 14, 00), 
					"JAC", LocalDateTime.of(2020, Month.JANUARY, 17, 16, 50), 250, 180);
			flightMgr.publishFlight(f);
			boolean success = flightMgr.deleteFlight("003");
			assertTrue("flight was not deleted", success);
			Flight ff = flightMgr.fetchFlight("003");
			assertTrue("flight record still in store", ff == null);
			System.out.println("FlightMgrTest.testDeleteFlight passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
	}
}
