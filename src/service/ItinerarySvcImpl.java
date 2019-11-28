package service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public class ItinerarySvcImpl implements IItinerarySvc {
	
	// TODO - VERY HARD
	public searchForFlights(String departureCode, LocalDateTime departureTime, Integer numberOfPassengers) {		
		
		Factory factory = Factory.getInstance();
		List<Flight> flights = new ArrayList<>();
		
		try {
			IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
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
	
	public boolean reserveItinerary(Itinerary itinerary, String username) throws ServiceLoadException {
		boolean didWrite = false;
		
		// Fetch profile data from database with given username
		Factory factory = Factory.getInstance();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		Traveler profile = travelerSvc.fetchProfile(username);
		// Get current list
		Itinerary[] currentList = profile.getItineraryList();
		
		// Update itinerary status to 'Reserved'
		itinerary.setStatus("Reserved");
		
		if(currentList == null ) {
			// If no itinerary list on profile, create one
			Itinerary[] newList = new Itinerary[] { itinerary };
			travelerSvc.updateItineraryList(username, newList);
			didWrite = true;
		} else {
			// Build list out of old one and new value
			int size = currentList.length + 1;
			Itinerary[] newList = new Itinerary[size];
			for(int i = 0; i < newList.length; i++) {
				if(i == 0) {
					newList[0] = itinerary;
				} else {
					newList[i] = currentList[i-1];
				}
			}
			// Update profile data in database
			travelerSvc.updateItineraryList(username, newList);
			didWrite = true;
		}
		
		return didWrite;
	}
	
	// TODO
	public boolean bookItinerary(String itineraryId, String username) {
		System.out.println("TravelerSvcImpl.bookItinerary called");
		// Fetch profile data from database with given username
		// Locate itinerary matching the provided Id in traveler's itinerary list
		// Update itinerary status to 'Booked'
		// Update profile data in database
		// Return boolean based on success
		boolean didWrite = true;
		return didWrite;
	}
	
	public boolean deleteItinerary(int itineraryId, String username) throws ServiceLoadException, RecordNotFoundException {
		boolean didDelete = false;
		Factory factory = Factory.getInstance();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		Traveler profile = travelerSvc.fetchProfile(username);
		Itinerary[] cis = profile.getItineraryList();
		List<Integer> indices = new ArrayList<>();
		for(int i = 0; i < cis.length; i++) {
			Itinerary ci = cis[i];
			int id = ci.getId();
			if(id == itineraryId) {
				indices.add(i);
			}
		}
		int size = cis.length - indices.size();
		if(size > 0) {
			Itinerary[] newItineraries = new Itinerary[size];
			int j = 0;
			for(int i = 0; i < cis.length; i++) {
				if(!indices.contains(i)) {
					newItineraries[j] = cis[i];
					j++;
				}
			}
			travelerSvc.updateItineraryList(username, newItineraries);
			didDelete = true;
		} else {
			throw new RecordNotFoundException("No record found");
		}
		
		return didDelete;
	}
	
}
