package service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.Flight;
import domain.Itinerary;
import domain.Traveler;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public class ItinerarySvcImpl implements IItinerarySvc {
	
	// TODO - VERY HARD
	public Itinerary[] searchForItinerary(String departureCode, LocalDateTime departureTime, String arrivalCode, LocalDateTime arrivalTime, Integer numberOfPassengers,
			boolean oneWay, boolean roundTrip)
			Flight[] flights = new Flight[0];
		// Get all flights
		Factory factory = Factory.getInstance();
		try {
			IFlightSvc flightSvc = (IFlightSvc)factory.getService(IFlightSvc.NAME);
			flights = flightSvc.getRecords();
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// Search by departure code
		
		
		// Query the database for flights and build itineraries based on the search parameters
		Itinerary[] itineraryList = new Itinerary[] {};
		
		return itineraryList;	
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
