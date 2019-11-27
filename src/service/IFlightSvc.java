package service;
import java.io.IOException;

import exceptions.RecordNotFoundException;
import domain.Flight;

public interface IFlightSvc extends IService {
	
	public final String NAME = "IFlightSvc";
	
	public Flight fetchFlight(String flightNumber);
	
	public boolean publishFlight(Flight flight);
	
	public boolean deleteFlight(String flightNumber);
	
	public boolean addRecords(Flight[] flights) throws IOException, ClassNotFoundException;
	
	public Flight[] getRecords() throws IOException, ClassNotFoundException, RecordNotFoundException;
	
	public void printAllFlights() throws IOException, ClassNotFoundException, RecordNotFoundException;
}
