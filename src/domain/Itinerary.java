package domain;

import java.util.Arrays; 
import java.io.Serializable;

public class Itinerary implements Serializable {
	/* Default Constructor */
	public Itinerary() {}
	
	/* Properties */
	private Integer id;
	private Double totalCost;
	private Flight[] flights;
	private String status;
	
	/* Getters and Setters */
	public int getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getTotalCost() {
		return this.totalCost;
	}
	public void setTotalCost(Double total) {
		this.totalCost = total;
	}
	
	public Flight[] getFlights() {
		return this.flights;
	}
	public void setFlights(Flight[] flights) {
		this.flights = flights;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/* Equals */
	public boolean equals(Itinerary itinerary) {
		boolean equals = true;

		if(itinerary.getId() != this.id) {
			equals = false;
		}
		
		boolean sameFlights = Arrays.equals(this.flights, itinerary.getFlights());
		if(!sameFlights) {
			equals = false;
		}
		
		return equals;
	}
	
	/* Validate */
	public boolean validate() {
		boolean valid = true;
		
		if(this.id == null || this.totalCost == null || this.flights == null || this.status == null) {
			valid = false;
		}
		
		return valid;
	}
}
