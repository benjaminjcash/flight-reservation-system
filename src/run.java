//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.Month;
//import exceptions.WrongPasswordException;
//import domain.Flight;
//import domain.Itinerary;
//import domain.Traveler;
//import exceptions.RecordNotFoundException;
//import exceptions.ServiceLoadException;
//import service.Factory;
//import service.IFlightSvc;
//import service.IItinerarySvc;
//import service.ILoginSvc;
//import service.ITravelerSvc;
//import presentation.LoginUI;
//
//public class run {
//	
//	public static void main(String[] args) throws ClassNotFoundException, IOException, ServiceLoadException, RecordNotFoundException {
//		Factory factory = Factory.getInstance();
//		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
//		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
//		System.out.println();
//		System.out.println("----------Data----------");
//		System.out.println();
//		
//		/////------- FLIGHTS -------/////
//		Flight[] emptyFlightArr = new Flight[] {};
//		flightSvc.addRecords(emptyFlightArr);
//		
//		/////------- TRAVELERS -------/////
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
//
//		/////------- CONSOLE -------/////
//		System.out.println();
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
//		
//	}
//}
