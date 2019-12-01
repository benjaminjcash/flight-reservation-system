package business;

import java.io.IOException;


import domain.Traveler;
import exceptions.ServiceLoadException;
import service.Factory;
import service.ITravelerSvc;

public class TravelerMgr {
	private Factory factory;
	
	public boolean createProfile(Traveler traveler) throws ServiceLoadException, ClassNotFoundException, IOException {
		boolean success = false;
		factory = Factory.getInstance();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		success = travelerSvc.createProfile(traveler);
		return success;
	}
	
	public Traveler fetchProfile(String username) throws ServiceLoadException {
		factory = Factory.getInstance();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		Traveler profile = travelerSvc.fetchProfile(username);
		return profile;
	}
	
	public boolean deleteProfile(String username) throws ServiceLoadException {
		boolean success = false;
		factory = Factory.getInstance();
		ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
		success = travelerSvc.deleteProfile(username);
		return success;
	}
	
}
