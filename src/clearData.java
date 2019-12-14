//import java.io.IOException;
//import domain.Flight;
//import domain.Traveler;
//import exceptions.RecordNotFoundException;
//import exceptions.ServiceLoadException;
//import service.Factory;
//import service.IFlightSvc;
//import service.ITravelerSvc;
//
//public class clearData {
//	
//	public static void main(String[] args) throws ClassNotFoundException, IOException, ServiceLoadException, RecordNotFoundException {
//		Factory factory = Factory.getInstance();
//		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
//		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
//		
//		/////------- FLIGHTS -------/////
//		Flight[] emptyFlightArr = new Flight[] {};
//		flightSvc.addRecords(emptyFlightArr);
//		
//		/////------- TRAVELERS -------/////		
//		Traveler[] emptyTravelerArr = new Traveler[] {};
//		travelerSvc.addRecords(emptyTravelerArr);
//		
//		System.out.println("DATA CLEARED");
//	}
//}
