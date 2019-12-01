package service;
import domain.Itinerary;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;

public interface IItinerarySvc extends IService {
	
	public final String NAME = "IItinerarySvc";
	
	public Itinerary fetchItinerary(String itineraryId, String username) throws RecordNotFoundException, ServiceLoadException;
	
	public boolean reserveItinerary(Itinerary itinerary, String username) throws ServiceLoadException;
	
	public boolean bookItinerary(String itineraryId, String username);
	
	public boolean deleteItinerary(String itineraryId, String username) throws ServiceLoadException, RecordNotFoundException;
}
