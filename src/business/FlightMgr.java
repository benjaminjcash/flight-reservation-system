package business;
import service.Factory;

import service.IFlightSvc;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Flight;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public class FlightMgr {
	private IFlightSvc flightSvc;
	
	private void setup() throws ServiceLoadException {
		Factory factory = Factory.getInstance();
		flightSvc = (IFlightSvc) factory.getService(IFlightSvc.NAME);
	}
	
	public Flight fetchFlight(String flightNumber) throws ServiceLoadException {
		setup();
		return flightSvc.fetchFlight(flightNumber);
	}
	
	public boolean publishFlight(Flight flight) throws ServiceLoadException { 
		setup();
		return flightSvc.publishFlight(flight);
	}
	
	public boolean deleteFlight(String flightNumber) throws ServiceLoadException {
		setup();
		return flightSvc.deleteFlight(flightNumber);
	}
	
	public Flight createFlight(String flightNumber, String airlineCode, String departureCode, LocalDateTime departureTime, 
			String arrivalCode, LocalDateTime arrivalTime, double businessTicket, double economyTicket) throws ServiceLoadException {
		setup();
		return flightSvc.createFlight(flightNumber, airlineCode, departureCode, departureTime, arrivalCode, arrivalTime, businessTicket, economyTicket);
	}
	
	public Flight[] fetchAllFlights() throws ServiceLoadException {
		setup();
		return flightSvc.fetchAllFlights();
	}
	
	public List<Flight> searchForFlights(String departureCode, LocalDateTime departureTime, Integer numberOfPassengers) {		
		List<Flight> flights = new ArrayList<>();
		
		try {
			setup();
			Flight[] fs = flightSvc.getRecords();
			flights = Arrays.asList(fs);	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Filter by departure code
		List<Flight> temp = new ArrayList<>();
		for(int i = 0; i < flights.size(); i++) {
			Flight curr = flights.get(i);
			String dc = curr.getDepartureCode();
			
			if(departureCode.equals(dc)) {
				temp.add(curr);
				String code = flights.get(i).getFlightNumber(); 
				System.out.println("Codes matched for flight " + code);
			}
		}
		flights = temp;
		
		// Filter by departure time (match day)
		List<Flight> temp2 = new ArrayList<>();
		for(int i = 0; i < flights.size(); i++) {
			Flight curr = flights.get(i);
			LocalDateTime dt = curr.getDepartureTime();
			LocalDate d = dt.toLocalDate();
			LocalDate departureDate = departureTime.toLocalDate();
			
			if(d.equals(departureDate)) {
				temp2.add(curr);
				String code = flights.get(i).getFlightNumber(); 
				System.out.println("Codes matched for flight " + code);
			}
		}
		flights = temp2;
		
		return flights;
	}
	
}
