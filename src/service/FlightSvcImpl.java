package service;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import exceptions.RecordNotFoundException;
import domain.Flight;

public class FlightSvcImpl implements IFlightSvc {
	
	public Flight fetchFlight(String flightNumber) {
		Flight flight = new Flight();
		try {
			flight = getRecord(flightNumber);
		}
		catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return flight;
	}

	
	public boolean publishFlight(Flight flight) {
		boolean didWrite;
		try {
			didWrite = addRecord(flight);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());	
			didWrite = false;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			didWrite = false;
		}
		catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
			didWrite = false;
		}
		return didWrite;
	}
	
	public boolean deleteFlight(String flightNumber) {
		boolean didDelete;
		try {
			didDelete = deleteRecords(flightNumber);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());	
			didDelete = false;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			didDelete = false;
		}
		catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
			didDelete = false;
		}
		return didDelete;
	}
	
	// Gets all records in store
	public Flight[] getRecords() throws IOException, ClassNotFoundException, RecordNotFoundException {
		String filePath = "data/flights.data";
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath));
		Flight[] flights = (Flight[]) input.readObject();
		input.close();
 		return flights;
	}
	
	// Clears store then adds records. For use in data loading
	// Use publishFlight in application
	public boolean addRecords(Flight[] data) throws IOException, ClassNotFoundException {
		boolean success = true;
		String filePath = "data/flights.data";
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath));
		output.writeObject(data);
		output.flush();
		output.close();
		return success;	
	}
	
	private Flight getRecord(String flightNumber) throws IOException, ClassNotFoundException, RecordNotFoundException {
		Flight[] allRecords = getRecords();
		Flight requestedFlight = new Flight();
		if(allRecords.length > 0) {
			for(Flight f: allRecords) {
				String flightNum = f.getFlightNumber();
				if(flightNum.equals(flightNumber)) {
					requestedFlight = f;
				}
			}
		}
		if(requestedFlight.getFlightNumber() == null) {
			throw new RecordNotFoundException("No record found");
		}
		return requestedFlight;
	}
	
	private boolean addRecord(Flight data) throws IOException, ClassNotFoundException, RecordNotFoundException {
		boolean success = true;
		Flight[] currentRecords = getRecords();
		int size = currentRecords.length + 1;
		Flight[] newRecords = new Flight[size];
		for(int i = 0; i < newRecords.length; i++) {
			if(i == 0) {
				newRecords[0] = data;
			} else {
				newRecords[i] = currentRecords[i-1];
			}
		}
		success = addRecords(newRecords);
		return success;
	}
	
	private boolean deleteRecords(String flightNumber) throws IOException, ClassNotFoundException, RecordNotFoundException {
		boolean success = true;
		
		Flight[] currentRecords = getRecords();
		List<Integer> indices = new ArrayList<>();
		for(int i = 0; i < currentRecords.length; i++) {
			String currFlightNumber = currentRecords[i].getFlightNumber();
			if(currFlightNumber.equals(flightNumber)) {
				indices.add(i);
			}
		}
		int size = currentRecords.length - indices.size();
		if(size > 0) {
			Flight[] newRecords = new Flight[size];
			int j = 0;
			for(int i = 0; i < currentRecords.length; i++) {
				if(!indices.contains(i)) {
					newRecords[j] = currentRecords[i];
					j++;
				}
			}
			addRecords(newRecords);
		} else {
			throw new RecordNotFoundException("No record found");
		}
		
		return success;
	}
	
	public void printAllFlights() throws IOException, ClassNotFoundException, RecordNotFoundException {
		Flight[] allFlights = getRecords();
		System.out.println("===All Flights===");
		for(int i = 0; i < allFlights.length; i++) {
			Flight curr = allFlights[i];
			System.out.println(" " + (i + 1) + ". Flight " + curr.getFlightNumber());
			System.out.println("  " + curr.getDepartureCode() + " to " + curr.getArrivalCode());
		}
	}
}
