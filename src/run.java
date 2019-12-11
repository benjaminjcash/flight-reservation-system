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
import presentation.LoginUI;

public class run {
	
//	public static void main(String[] args) throws ClassNotFoundException, IOException, ServiceLoadException, RecordNotFoundException {
//		Factory factory = Factory.getInstance();
//		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
//		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
//		IItinerarySvc itinerarySvc = (IItinerarySvc)factory.getService(IItinerarySvc.NAME);
//		ILoginSvc loginSvc = (ILoginSvc)factory.getService(ILoginSvc.NAME);
//		System.out.println();
//		System.out.println("----------Data----------");
//		System.out.println();
		
		/////------- FLIGHTS -------/////
		
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

		/////------- CONSOLE -------/////

//		try { flightSvc.printAllFlights(); }
//		catch(Exception e) { System.out.println(e); }
//		System.out.println();
//		try { travelerSvc.printAllTravelers(); }
//		catch(Exception e) { System.out.println(e); }
//		System.out.println();
//		try { travelerSvc.printItineraries("herecomesjohnny"); }
//		catch(Exception e) { System.out.println(e); }
//		System.out.println();
//		try { travelerSvc.printItineraries("sallyskis"); }
//		catch(Exception e) { System.out.println(e); }
//		System.out.println();

		/////------- UI -------/////
//		LoginUI loginPage = new LoginUI("Login");
//		System.out.println("----------Application Running----------");
//	}
}
