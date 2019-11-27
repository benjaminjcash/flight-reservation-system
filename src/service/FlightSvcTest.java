package service;
import java.time.LocalDateTime;
import java.time.Month;

import domain.Flight;
import exceptions.ServiceLoadException;
import junit.framework.TestCase;

public class FlightSvcTest extends TestCase {
	private Factory factory;
	protected void setUp() {
		this.factory = Factory.getInstance();
	}
	
	public void testPublishFetchFlight() throws ServiceLoadException {
		this.setUp();
		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
		Flight f1 = new Flight();
		f1.setFlightNumber("113");
		f1.setAirlineCode("DL");
		f1.setDepartureCode("DEN");
		LocalDateTime dep = LocalDateTime.of(2019, Month.DECEMBER, 2, 1, 20);
		f1.setDepartureTime(dep);
		f1.setArrivalCode("ATL");
		LocalDateTime arr = LocalDateTime.of(2019, Month.DECEMBER, 2, 4, 20);
		f1.setArrivalTime(arr);
		f1.setBusinessTicket(800.00);
		f1.setEconomyTicket(650.00);
		flightSvc.publishFlight(f1);
		Flight flightFromStore = flightSvc.fetchFlight("113");
		assertTrue("flight was not returned", flightFromStore != null);
		String fn = flightFromStore.getFlightNumber();
		assertTrue("flights do not match", fn.equals("113"));
		String ac = flightFromStore.getAirlineCode();
		assertTrue("flights do not match", ac.equals("DL"));
		flightSvc.deleteFlight("113");
		System.out.println("FlightSvcTest.testFetchFlight passed!");
	}
	
	public void testDeleteFlight() throws ServiceLoadException {
		this.setUp();
		IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
		Flight f1 = new Flight();
		f1.setFlightNumber("TEMP");
		flightSvc.publishFlight(f1);
		Flight beforeDelete = flightSvc.fetchFlight("TEMP");
		assertTrue("flight was not returned", beforeDelete != null);
		flightSvc.deleteFlight("TEMP");
		Flight afterDelete = flightSvc.fetchFlight("TEMP");
		assertTrue("flight was not deleted", afterDelete == null);
		System.out.println("FlightSvcTest.testDeleteFlight passed!");
	}
}
