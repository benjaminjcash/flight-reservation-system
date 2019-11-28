package service;
import java.time.LocalDateTime;
import java.util.List;

import domain.Flight;
import domain.Itinerary;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public interface IItinerarySvc extends IService {
	
	public final String NAME = "IItinerarySvc";
	
	public List<Flight> searchForFlights(String departureCode, LocalDateTime departureTime, Integer numberOfPassengers);
	
	public boolean reserveItinerary(Itinerary itinerary, String username) throws ServiceLoadException;
	
	public boolean bookItinerary(String itineraryId, String username);
	
	public boolean deleteItinerary(int itineraryId, String username) throws ServiceLoadException, RecordNotFoundException;
}
