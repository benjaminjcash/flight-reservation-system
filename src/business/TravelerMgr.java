package business;

import java.io.IOException;


import domain.Traveler;
import exceptions.ServiceLoadException;
import service.Factory;
import service.IFlightSvc;
import service.ITravelerSvc;

public class TravelerMgr {
	private ITravelerSvc travelerSvc;
	private void setup() throws ServiceLoadException {
		Factory factory = Factory.getInstance();
		travelerSvc = (ITravelerSvc) factory.getService(ITravelerSvc.NAME);
	}
	
	public boolean createProfile(Traveler traveler) throws ServiceLoadException, ClassNotFoundException, IOException {
		setup();
		return travelerSvc.createProfile(traveler);
	}
	
	public Traveler fetchProfile(String username) throws ServiceLoadException {
		setup();
		return travelerSvc.fetchProfile(username);
	}
	
	public boolean deleteProfile(String username) throws ServiceLoadException {
		setup();
		return travelerSvc.deleteProfile(username);
	}
	
	public Traveler[] fetchAllProfiles() throws ServiceLoadException {
		setup();
		return travelerSvc.fetchAllProfiles();
	}
}
