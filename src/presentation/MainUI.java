package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainUI extends JFrame {
	private JDesktopPane theDesktop = new JDesktopPane();
	
	public MainUI() {
		super("Flight Reservation System");
		
		// Menu //
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		getContentPane().add(theDesktop);
		
			JMenu fileMenu = new JMenu("File");
			menuBar.add(fileMenu);
				JMenu newMenu = new JMenu("New");
					JMenuItem newFlight = new JMenuItem("Flight");
					JMenuItem newTraveler = new JMenuItem("Traveler");
					newMenu.add(newFlight);
					newMenu.add(newTraveler);
					fileMenu.add(newMenu);
				JSeparator sep1 = new JSeparator();
				fileMenu.add(sep1);
				JMenuItem exit = new JMenuItem("Exit");
				fileMenu.add(exit);
			
			JMenu viewMenu = new JMenu("View");
			menuBar.add(viewMenu);
				JMenuItem allFlights = new JMenuItem("All Flights");
				viewMenu.add(allFlights);
				JMenuItem allTravelers = new JMenuItem("All Travelers");
				viewMenu.add(allTravelers);
			
			JMenu userMenu = new JMenu("User");
			menuBar.add(userMenu);
				JMenuItem login = new JMenuItem("Login");
				userMenu.add(login);
				JMenuItem logout = new JMenuItem("Logout");
				userMenu.add(logout);
			
		// Action Listeners //
				
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI loginUI = new LoginUI();
				loginUI.setVisible(true);
				theDesktop.add(loginUI);
			}
		});
		newFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFlightUI createFlightUI = new CreateFlightUI();
				createFlightUI.setVisible(true);
				theDesktop.add(createFlightUI);
			}
		});
		newTraveler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				CreateTravelerUI createTravelerUI = new CreateTravelerUI();
				createTravelerUI.setVisible(true);
				theDesktop.add(createTravelerUI);
			}
		});
		
		
		pack();
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
}
 