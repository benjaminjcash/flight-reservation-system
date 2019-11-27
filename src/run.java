import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

import exceptions.WrongPasswordException;
import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import service.Factory;
import service.IFlightSvc;
import service.IItinerarySvc;
import service.ILoginSvc;
import service.ITravelerSvc;

public class run {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, ServiceLoadException {
		Factory factory = Factory.getInstance();
		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		IItinerarySvc itinerarySvc = (IItinerarySvc)factory.getService(IItinerarySvc.NAME);
		ILoginSvc loginSvc = (ILoginSvc)factory.getService(ILoginSvc.NAME);
		
		/////------- FLIGHTS -------/////
		
//		Flight f1 = new Flight();
//		f1.setFlightNumber("112");
//		f1.setAirlineCode("DL");
//		f1.setDepartureCode("DEN");
//		LocalDateTime dep = LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20);
//		f1.setDepartureTime(dep);
//		f1.setArrivalCode("ATL");
//		LocalDateTime arr = LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20);
//		f1.setArrivalTime(arr);
//		f1.setBusinessTicket(800.00);
//		f1.setEconomyTicket(650.00);
//		Flight f2 = new Flight();
//		f2.setFlightNumber("699");
//		f2.setAirlineCode("DL");
//		f2.setDepartureCode("ATL");
//		LocalDateTime dep2 = LocalDateTime.of(2019, Month.DECEMBER, 7, 14, 20);
//		f2.setDepartureTime(dep2);
//		f2.setArrivalCode("DEN");
//		LocalDateTime arr2 = LocalDateTime.of(2019, Month.DECEMBER, 7, 17, 20);
//		f2.setArrivalTime(arr2);
//		f2.setBusinessTicket(1000.00);
//		f2.setEconomyTicket(825.00);
//		Flight f3 = new Flight();
//		f3.setFlightNumber("550");
//		f3.setAirlineCode("UA");
//		f3.setDepartureCode("BHM");
//		LocalDateTime dep3 = LocalDateTime.of(2019, Month.DECEMBER, 14, 5, 20);
//		f3.setDepartureTime(dep3);
//		f3.setArrivalCode("FLG");
//		LocalDateTime arr3 = LocalDateTime.of(2019, Month.DECEMBER, 14, 9, 20);
//		f3.setArrivalTime(arr3);
//		f3.setBusinessTicket(700.00);
//		f3.setEconomyTicket(550.00);
//		Flight f4 = new Flight();
//		f4.setFlightNumber("333");
//		f4.setAirlineCode("UA");
//		f4.setDepartureCode("FLG");
//		LocalDateTime dep4 = LocalDateTime.of(2019, Month.DECEMBER, 20, 3, 20);
//		f4.setDepartureTime(dep4);
//		f4.setArrivalCode("BHM");
//		LocalDateTime arr4 = LocalDateTime.of(2019, Month.DECEMBER, 20, 7, 20);
//		f4.setArrivalTime(arr4);
//		f4.setBusinessTicket(830.00);
//		f4.setEconomyTicket(790.00);
	
//		Flight[] fls = new Flight[] {f1, f2, f3, f4};
//		flightSvc.addRecords(fls);
		
		/////------- TRAVELERS -------/////
		
//		Traveler t1 = new Traveler();
//		t1.setUsername("herecomesjohnny");
//		t1.setPassword("test123");
//		t1.setName("John Doe");
//		Traveler t2 = new Traveler();
//		t2.setUsername("sallyskis");
//		t2.setPassword("skiingrocks");
//		t2.setName("Sally Summers");		
//		Traveler[] travelers = new Traveler[] {t1, t2};
//		travelerSvc.addRecords(travelers);
		
		/////------- ITINERARIES -------/////
		
//		Flight[] fs1 = new Flight[] { f1, f2 };
//		Itinerary i1 = new Itinerary();
//		i1.setFlights(fs1);
//		i1.setId(0011);
//		itinerarySvc.reserveItinerary(i1, "sallyskis");
//		Flight[] fs2 = new Flight[] { f3, f4 };
//		Itinerary i2 = new Itinerary();
//		i2.setFlights(fs2);
//		i2.setId(0012);
//		itinerarySvc.reserveItinerary(i2, "herecomesjohnny");
//		Flight[] fs3 = new Flight[] { f1, f2 };
//		Itinerary i3 = new Itinerary();
//		i3.setFlights(fs3);
//		i3.setId(0013);
//		itinerarySvc.reserveItinerary(i3, "herecomesjohnny");
		
		/////------- LOGIN -------/////
		
//		boolean loggedIn = true;
//		try{ loginSvc.login("herecomesjohnny", "test123"); }
//		catch(RecordNotFoundException e) { System.out.println(e.getMessage()); loggedIn = false; }
//		catch(WrongPasswordException e) { System.out.println(e.getMessage()); loggedIn = false; }
//		if(loggedIn) {
//			System.out.println("Logged in as herecomesjohnny");
//		}
		
		/////------- PRINT DATA -------/////
		
//		flightSvc.deleteFlight("333");
//		Traveler t4 = new Traveler();
//		t4.setName("Benjamin French");
//		t4.setUsername("Sweaty");
//		t4.setPassword("test123");
//		travelerSvc.createProfile(t4);
//		try {
//			loginSvc.login("Sweaty", "test123");
//		}
//		catch(WrongPasswordException e) {
//			System.out.println(e.getMessage());
//		}
//		catch(RecordNotFoundException e) {
//			System.out.println(e.getMessage());		
//		}
		
		System.out.println();
		try { flightSvc.printAllFlights(); }
		catch(Exception e) { System.out.println(e); }
		System.out.println();
		try { travelerSvc.printAllTravelers(); }
		catch(Exception e) { System.out.println(e); }
		System.out.println();
		try { travelerSvc.printItineraries("herecomesjohnny"); }
		catch(Exception e) { System.out.println(e); }
		System.out.println();
		try { travelerSvc.printItineraries("sallyskis"); }
		catch(Exception e) { System.out.println(e); }
		
	}
}
