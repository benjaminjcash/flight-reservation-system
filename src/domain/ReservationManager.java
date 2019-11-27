package domain;

import java.io.Serializable;

public class ReservationManager implements Serializable {
	/* Default Constructor */
	public ReservationManager() {};
	
	/* Properties */
	private String name;
	private String username;
	private String password;
	
	/* Getters and Setters */
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* Equals */
	public boolean equals(ReservationManager manager) {
		boolean equals = true;
		
		if(manager.getName() != this.name || manager.getUsername() != this.username) {
			equals = false;
		}
		
		return equals;
	}
	
	/* Validate */
	public boolean validate() {
		boolean valid = true;
		
		if(this.name == null || this.username == null || this.password == null) {
			valid = false;
		}
		
		return valid;
	}
}
