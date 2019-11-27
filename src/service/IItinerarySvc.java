package service;
import java.time.LocalDateTime;
import domain.Itinerary;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public interface IItinerarySvc extends IService {
	
	public final String NAME = "IItinerarySvc";
	
	public Itinerary[] searchForItinerary(String departureCode, LocalDateTime departureTime, String arrivalCode, LocalDateTime arrivalTime, Integer numberOfPassengers,
											boolean oneWay, boolean roundTrip);
	
	public boolean reserveItinerary(Itinerary itinerary, String username) throws ServiceLoadException;
	
	public boolean bookItinerary(String itineraryId, String username);
	
	public boolean deleteItinerary(int itineraryId, String username) throws ServiceLoadException, RecordNotFoundException;
}
