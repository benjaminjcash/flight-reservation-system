package service;
import junit.framework.TestCase;
import java.time.LocalDateTime;
import java.time.Month;
import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.ServiceLoadException;

public class ItinerarySvcTest extends TestCase {
	private Factory factory;
	protected void setUp() {
		factory = Factory.getInstance();
	}
	
	public void testReserveItinerary() throws ServiceLoadException {
		this.setUp();
		IItinerarySvc itinerarySvc = (IItinerarySvc)factory.getService(IItinerarySvc.NAME);
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		Flight f1 = new Flight();
		f1.setFlightNumber("112");
		f1.setAirlineCode("DL");
		f1.setDepartureCode("DEN");
		LocalDateTime dep = LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20);
		f1.setDepartureTime(dep);
		f1.setArrivalCode("ATL");
		LocalDateTime arr = LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20);
		f1.setArrivalTime(arr);
		f1.setBusinessTicket(800.00);
		f1.setEconomyTicket(650.00);
		Flight f2 = new Flight();
		f2.setFlightNumber("699");
		f2.setAirlineCode("DL");
		f2.setDepartureCode("ATL");
		LocalDateTime dep2 = LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20);
		f2.setDepartureTime(dep2);
		f2.setArrivalCode("DEN");
		LocalDateTime arr2 = LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20);
		f2.setArrivalTime(arr2);
		f2.setBusinessTicket(1000.00);
		f2.setEconomyTicket(825.00);
		Flight[] fs1 = new Flight[] { f1, f2 };
		Itinerary i1 = new Itinerary();
		i1.setFlights(fs1);
		i1.setId(1667);
		itinerarySvc.reserveItinerary(i1, "herecomesjohnny");
		Traveler profile = travelerSvc.fetchProfile("herecomesjohnny");
		Itinerary[] il = profile.getItineraryList();
		boolean found = true;
		// TODO: Finish writing test
		for(int i = 0; i < il.length; i++) {
			Itinerary curr = il[i];
			if(i1.equals(curr)) {
				found = true;
			}
		}
		assertTrue("itinerary not found", found);
		System.out.println("ItinerarySvcTest.testReserveItinerary passed!");
	}
	
}
