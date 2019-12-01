package service;
import junit.framework.TestCase;
import java.time.LocalDateTime;
import java.time.Month;
import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.ServiceLoadException;

public class ItinerarySvcTest extends TestCase {
	private IItinerarySvc itinerarySvc;
	private ITravelerSvc travelerSvc;
	private IFlightSvc flightSvc;
	
	private void setup() throws ServiceLoadException {
		Factory factory = Factory.getInstance();
		itinerarySvc = (IItinerarySvc) factory.getService(IItinerarySvc.NAME);
		travelerSvc = (ITravelerSvc) factory.getService(ITravelerSvc.NAME);
		flightSvc = (IFlightSvc) factory.getService(IFlightSvc.NAME);
	}
	
	public void testFetchItinerary() {
		try {
			setup();
			Flight f1 = flightSvc.createFlight("112", "DL", "Delta Airlines", "DEN", LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20),
					"ATL", LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20), 800, 650);
			Flight f2 = flightSvc.createFlight("699", "DL", "Delta Airlines", "ATL", LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20),
					"DEN", LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20), 1000, 825);
			Flight[] fs1 = new Flight[] { f1, f2 };
			Itinerary i1 = new Itinerary();
			i1.setFlights(fs1);
			i1.setId("0002");
			itinerarySvc.reserveItinerary(i1, "herecomesjohnny");
			Itinerary fi = itinerarySvc.fetchItinerary("0002", "herecomesjohnny");
			String fiid = fi.getId();
			assertTrue("itinerary was not found", fiid.equals("0002"));
			itinerarySvc.deleteItinerary("0002", "herecomesjohnny");
			System.out.println("ItinerarySvcTest.testFetchItinerary passed!");
		}
		catch (Exception e) { System.out.println(e.getMessage()); }
	}
	
	public void testReserveItinerary() {
		try {
			setup();
			Flight f1 = flightSvc.createFlight("112", "DL", "Delta Airlines", "DEN", LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20),
					"ATL", LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20), 800, 650);
			Flight f2 = flightSvc.createFlight("699", "DL", "Delta Airlines", "ATL", LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20),
					"DEN", LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20), 1000, 825);
			Flight[] fs1 = new Flight[] { f1, f2 };
			Itinerary i1 = new Itinerary();
			i1.setFlights(fs1);
			i1.setId("0001");
			boolean success = itinerarySvc.reserveItinerary(i1, "herecomesjohnny");
			assertTrue("itinerary was not reserved", success);
			itinerarySvc.deleteItinerary("0001", "herecomesjohnny");
			System.out.println("ItinerarySvcTest.testReserveItinerary passed!");
		}
		catch (Exception e) { System.out.println(e.getMessage()); }
	}
}
