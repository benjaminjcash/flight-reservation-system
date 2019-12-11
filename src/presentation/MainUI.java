package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainUI extends JFrame {
	private JDesktopPane theDesktop = new JDesktopPane();
	public MainUI() {
		super("Flight Reservation System");
		
		// Menu //
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		getContentPane().add(theDesktop);
		
			JMenu fm = new JMenu("File");
			mb.add(fm);
				JMenu sbm = new JMenu("New");
					JMenuItem nf = new JMenuItem("Flight");
					JMenuItem nt = new JMenuItem("Traveler");
					sbm.add(nf);
				    sbm.add(nt);
				    fm.add(sbm);
				JSeparator s1 = new JSeparator();
				fm.add(s1);
				JMenuItem ei = new JMenuItem("Exit");
				
				fm.add(ei);
			
			JMenu vm = new JMenu("View");
			mb.add(vm);
				JMenuItem afs = new JMenuItem("All Flights");
				vm.add(afs);
				JMenuItem ats = new JMenuItem("All Travelers");
				vm.add(ats);
			
			JMenu usrm = new JMenu("User");
			mb.add(usrm);
				JMenuItem lgn = new JMenuItem("Login");
				
				usrm.add(lgn);
		
		// Action Listeners //
				
		ei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		lgn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI loginUI = new LoginUI("Login");
				loginUI.setVisible(true);
				theDesktop.add(loginUI);
			}
		});
		
		pack();
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
}
 