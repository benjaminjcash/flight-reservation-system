package business;

import java.time.LocalDateTime;
import java.time.Month;

import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class ItineraryMgrTest extends TestCase {
	private ItineraryMgr itineraryMgr;
	private FlightMgr flightMgr;
	private TravelerMgr travelerMgr;
	private void setup() throws ServiceLoadException {
		itineraryMgr = new ItineraryMgr();
		flightMgr = new FlightMgr();
		travelerMgr = new TravelerMgr();
	}
	
	public void testReserveItinerary() {
		try {
			setup();
			Flight f1 = flightMgr.createFlight("998", "DL", "Delta Airlines", "DEN", LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20),
					"ATL", LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20), 800, 650);
			Flight f2 = flightMgr.createFlight("999", "DL", "Delta Airlines", "ATL", LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20),
					"DEN", LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20), 1000, 825);
			Flight[] fs1 = new Flight[] { f1, f2 };
			Itinerary i1 = new Itinerary();
			i1.setFlights(fs1);
			i1.setId("9999");
			boolean success = itineraryMgr.reserveItinerary(i1, "herecomesjohnny");
			assertTrue("itinerary was not reserved", success);
			Traveler profile = travelerMgr.fetchProfile("herecomesjohnny");
			Itinerary[] il = profile.getItineraryList();
			boolean found = false;
			for(int i = 0; i < il.length; i++) {
				Itinerary curr = il[i];
				if(i1.equals(curr)) {
					found = true;
				}
			}
			assertTrue("itinerary not found", found);
			itineraryMgr.deleteItinerary("9999", "herecomesjohnny");
			System.out.println("ItinerarySvcTest.testReserveItinerary passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); }
		catch (RecordNotFoundException e) { System.out.println(e.getMessage()); }
	}
	
	public void testDeleteItinerary() {
		try {
			setup();
			Flight f1 = flightMgr.createFlight("998", "DL", "Delta Airlines", "DEN", LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20),
					"ATL", LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20), 800, 650);
			Flight f2 = flightMgr.createFlight("999", "DL", "Delta Airlines", "ATL", LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20),
					"DEN", LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20), 1000, 825);
			Flight[] fs1 = new Flight[] { f1, f2 };
			Itinerary i1 = new Itinerary();
			i1.setFlights(fs1);
			i1.setId("9998");
			
			boolean s = itineraryMgr.reserveItinerary(i1, "herecomesjohnny");
			assertTrue("itinerary was not reserved", s);
			boolean ds = itineraryMgr.deleteItinerary("9998", "herecomesjohnny");
			assertTrue("itinerary was not deleted", ds);
			
			Itinerary di = itineraryMgr.fetchItinerary("9998", "herecomesjohnny");
			String diid = di.getId();
			assertFalse("itinerary was not deleted", diid.equals("9998"));
			
			System.out.println("ItinerarySvcTest.testDeleteItinerary passed!");
		}
		catch (ServiceLoadException e) { System.out.println(e.getMessage()); } 
		catch (RecordNotFoundException e) { System.out.println(e.getMessage()); }
	}
}
