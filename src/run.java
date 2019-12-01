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
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, ServiceLoadException, RecordNotFoundException {
		Factory factory = Factory.getInstance();
		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		IItinerarySvc itinerarySvc = (IItinerarySvc)factory.getService(IItinerarySvc.NAME);
		ILoginSvc loginSvc = (ILoginSvc)factory.getService(ILoginSvc.NAME);
		
//		itinerarySvc.deleteItinerary("9998", "herecomesjohnny");
		
		/////------- FLIGHTS -------/////
		
//		Flight f1 = new Flight();
//		f1.setFlightNumber("112");
//		f1.setAirlineCode("DL");
//		f1.setDepartureCode("DEN");
//		LocalDateTime d1 = LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20);
//		f1.setDepartureTime(d1);
//		f1.setArrivalCode("ATL");
//		LocalDateTime a1 = LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20);
//		f1.setArrivalTime(a1);
//		f1.setBusinessTicket(200.00);
//		f1.setEconomyTicket(160.00);
//		Flight f2 = new Flight();
//		f2.setFlightNumber("230");
//		f2.setAirlineCode("DL");
//		f2.setDepartureCode("DEN");
//		LocalDateTime d2 = LocalDateTime.of(2019, Month.DECEMBER, 2, 14, 45);
//		f2.setDepartureTime(d2);
//		f2.setArrivalCode("ATL");
//		LocalDateTime a2 = LocalDateTime.of(2019, Month.DECEMBER, 2, 17, 45);
//		f2.setArrivalTime(a2);
//		f2.setBusinessTicket(150.00);
//		f2.setEconomyTicket(100.00);
//		Flight f3 = new Flight();
//		f3.setFlightNumber("320");
//		f3.setAirlineCode("DL");
//		f3.setDepartureCode("DEN");
//		LocalDateTime d3 = LocalDateTime.of(2019, Month.DECEMBER, 9, 20, 45);
//		f3.setDepartureTime(d3);
//		f3.setArrivalCode("ATL");
//		LocalDateTime a3 = LocalDateTime.of(2019, Month.DECEMBER, 9, 23, 45);
//		f3.setArrivalTime(a3);
//		f3.setBusinessTicket(170.00);
//		f3.setEconomyTicket(130.00);
//	
//		Flight[] fls = new Flight[] {f1, f2, f3};
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
//		i1.setId("0011");
//		itinerarySvc.reserveItinerary(i1, "sallyskis");
//		Flight[] fs2 = new Flight[] { f3, f4 };
//		Itinerary i2 = new Itinerary();
//		i2.setFlights(fs2);
//		i2.setId("0012");
//		itinerarySvc.reserveItinerary(i2, "herecomesjohnny");
//		Flight[] fs3 = new Flight[] { f1, f2 };
//		Itinerary i3 = new Itinerary();
//		i3.setFlights(fs3);
//		i3.setId("0013");
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
