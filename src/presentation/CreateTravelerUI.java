package presentation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import business.TravelerMgr;
import domain.Traveler;
import service.Factory;
import service.ITravelerSvc;

public class CreateTravelerUI extends JInternalFrame {
	
	private JLabel nameLbl = new JLabel("Name");
	private JLabel addressLbl = new JLabel("Address");
	private JLabel usernameLbl = new JLabel("Username");
	private JLabel passwordLbl = new JLabel("Password");
	private JLabel creditCardNumberLbl = new JLabel("Credit Card - Number");
	private JLabel expirationDateLbl = new JLabel("Credit Card - Expiration Date");
	private JTextField nameFld = new JTextField(25);
	private JTextField addressFld = new JTextField(25);
	private JTextField usernameFld = new JTextField(25);
	private JTextField passwordFld = new JTextField(25);
	private JTextField creditCardNumberFld = new JTextField(25);
	private JTextField expirationDateFld = new JTextField(25);
	private JButton submitBtn = new JButton("Submit");
	
	public CreateTravelerUI() {
		super("Create Traveler", false, true);
		printTravelers();
		
		Container container = getContentPane();
		GridLayout layout = new GridLayout(7, 2);
		container.setLayout(layout);
		container.add(nameLbl);
		container.add(nameFld);
		container.add(addressLbl);
		container.add(addressFld);
		container.add(usernameLbl);
		container.add(usernameFld);
		container.add(passwordLbl);
		container.add(passwordFld);
		container.add(creditCardNumberLbl);
		container.add(creditCardNumberFld);
		container.add(expirationDateLbl);
		container.add(expirationDateFld);
		container.add(submitBtn);
		
		submitBtn.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						TravelerMgr travelerMgr = new TravelerMgr();
						Traveler newTraveler = new Traveler();
						newTraveler.setName(nameFld.getText());
						newTraveler.setAddress(addressFld.getText());
						newTraveler.setUsername(usernameFld.getText());
						newTraveler.setPassword(passwordFld.getText());
						newTraveler.setCreditCardNumber(creditCardNumberFld.getText());
						newTraveler.setExpirationDate(expirationDateFld.getText());
						try {
							travelerMgr.createProfile(newTraveler);
						}
						catch (Exception e) { System.out.println(e.getMessage()); }
						printTravelers();
						dispose();
					}
				}
			);
			
			pack();
			setVisible(true);
	}
	
	public void printTravelers() {
		Factory factory = Factory.getInstance();
		try { 
			System.out.println();
			ITravelerSvc travelerSvc = (ITravelerSvc)factory.getService(ITravelerSvc.NAME);
			travelerSvc.printAllTravelers();
			System.out.println();
		}
		catch(Exception e) { System.out.println(e); }
	}
}
