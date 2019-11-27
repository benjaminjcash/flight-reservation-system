package service;
import domain.Traveler;


import java.io.IOException;

import exceptions.RecordNotFoundException;
import domain.Itinerary;

public interface ITravelerSvc extends IService {
	public final String NAME = "ITravelerSvc";
	
	public Traveler fetchProfile(String username);
	
	public boolean createProfile(Traveler traveler) throws IOException, ClassNotFoundException;
	
	public boolean deleteProfile(String username);
	
	public boolean addPaymentInformation(String username, String creditCardNumber, String expirationDate);
	
	public boolean updateItineraryList(String username, Itinerary[] list);
	
	public boolean addRecords(Traveler[] travelers) throws IOException, ClassNotFoundException;
	
	public Traveler[] getRecords() throws IOException, ClassNotFoundException, RecordNotFoundException;
	
	public void printAllTravelers() throws IOException, ClassNotFoundException, RecordNotFoundException;
	
	public void printItineraries(String username) throws IOException, ClassNotFoundException, RecordNotFoundException;
}
