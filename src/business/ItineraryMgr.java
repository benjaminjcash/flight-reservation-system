package business;

import domain.Itinerary;
import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import service.Factory;
import service.IItinerarySvc;

public class ItineraryMgr {
	private IItinerarySvc itinerarySvc;
	private void setup() throws ServiceLoadException {
		Factory factory = Factory.getInstance();
		itinerarySvc = (IItinerarySvc) factory.getService(IItinerarySvc.NAME);
	}
	
	public Itinerary fetchItinerary(String itineraryId, String username) throws ServiceLoadException, RecordNotFoundException {
		setup();
		return itinerarySvc.fetchItinerary(itineraryId, username);
	}
	
	public boolean reserveItinerary(Itinerary itinerary, String username) throws ServiceLoadException {
		setup();
		return itinerarySvc.reserveItinerary(itinerary, username);
	}
	
	public boolean bookItinerary(String itineraryId, String username) throws ServiceLoadException {
		setup();
		return itinerarySvc.bookItinerary(itineraryId, username);
	}

	public boolean deleteItinerary(String itineraryId, String username) throws ServiceLoadException, RecordNotFoundException {
		setup();
		return itinerarySvc.deleteItinerary(itineraryId, username);
	}
}
