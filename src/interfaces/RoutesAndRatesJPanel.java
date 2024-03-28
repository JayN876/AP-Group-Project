package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databaseAction.RouteDatabaseAction;
import personalInfo.Address;
import personalInfo.RouteRate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoutesAndRatesJPanel {
	

	private static final Logger logger = LogManager.getLogger(RoutesAndRatesJPanel.class);	
	private JLabel headingLabel; 
	private JLabel sourceLabel;
	private JTextField sourceStreetField;
	private JTextField sourceParishField;
	private JTextField sourceCommuityField;
	
	private JLabel destinationLabel;
	private JTextField destinationStreetField;
	private JTextField destinationParishField;
	private JTextField destinationCommuityField;
	
	private JLabel ratesJLabel;
	private JTextField ratesField;
	
	private JLabel routeIDLabel;
	private JTextField routeField;
	
	private JLabel distanceLabel;
	private JTextField distanceField;
	
	private JButton confirmButton;
	private JButton clearButton;
	private GridBagConstraints gbc;
	private JPanel panel;
	
	public RoutesAndRatesJPanel() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		gbc= new GridBagConstraints();
		
		//column 1 Labels
		headingLabel = new JLabel("Add Routes And Rates");
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor= GridBagConstraints.NORTHWEST;
		gbc.gridwidth=3;
		Font font = headingLabel.getFont();
		headingLabel.setFont(new Font(font.getFontName(), font.getStyle(), 30));
		panel.add(headingLabel,gbc);
		
		
		gbc.anchor= GridBagConstraints.NORTHWEST;
		routeIDLabel = new JLabel("Route ID : ");
		gbc.gridy=1;
		gbc.gridx=0;
		panel.add(routeIDLabel,gbc);
		
		gbc.anchor= GridBagConstraints.NORTHWEST;
		routeField = new JTextField();
		gbc.gridy=1;
		gbc.gridx=1;
		routeField.setColumns(15);
		panel.add(routeField,gbc);
		
		//Source Address Label
		sourceLabel = new JLabel("<html><br>Source Address<br>________________________________________</html>");
		gbc.gridwidth=3;
		gbc.gridy=2;
		gbc.gridx=0;
		panel.add(sourceLabel,gbc);
		
		gbc=new GridBagConstraints();
		gbc.anchor= GridBagConstraints.NORTHWEST;
		sourceLabel = new JLabel("Street Name : ");
		gbc.gridy=3;
		gbc.gridx=0;
		panel.add(sourceLabel,gbc);
		
		sourceStreetField = new JTextField();
		gbc.gridy=3;
		gbc.gridx=1;
		sourceStreetField.setColumns(15);
		panel.add(sourceStreetField,gbc);
		
		gbc=new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		sourceLabel = new JLabel("Community : ");
		gbc.gridy=4;
		gbc.gridx=0;
		panel.add(sourceLabel,gbc);
		
		sourceCommuityField = new JTextField();
		gbc.gridy=4;
		gbc.gridx=1;
		sourceCommuityField.setColumns(15);
		panel.add(sourceCommuityField,gbc);
		
		
		sourceLabel = new JLabel("Parish : ");
		gbc.gridy=5;
		gbc.gridx=0;
		panel.add(sourceLabel,gbc);
		
		sourceParishField = new JTextField();
		gbc.gridy=5;
		gbc.gridx=1;
		sourceParishField.setColumns(15);
		panel.add(sourceParishField,gbc);
		
		//Destination Address Label
		destinationLabel = new JLabel("<html><br>"
				+ "Destination Address<br>________________________________________</html>");
		gbc.gridwidth=3;
		gbc.gridy=6;
		gbc.gridx=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(destinationLabel,gbc);
		
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		destinationLabel = new JLabel("Street Name : ");
		gbc.gridy=7;
		gbc.gridx=0;
		panel.add(destinationLabel,gbc);
		
		destinationStreetField = new JTextField();
		gbc.gridy=7;
		gbc.gridx=1;
		destinationStreetField.setColumns(15);
		panel.add(destinationStreetField,gbc);
		
		destinationLabel = new JLabel("Community : ");
		gbc.gridy=8;
		gbc.gridx=0;
		panel.add(destinationLabel,gbc);
		
		destinationCommuityField = new JTextField();
		gbc.gridy=8;
		gbc.gridx=1;
		destinationCommuityField.setColumns(15);
		panel.add(destinationCommuityField,gbc);
		
		destinationLabel = new JLabel("Parish : ");
		gbc.gridy=9;
		gbc.gridx=0;
		panel.add(destinationLabel,gbc);
		
		destinationParishField = new JTextField();
		gbc.gridy=9;
		gbc.gridx=1;
		destinationParishField.setColumns(15);
		panel.add(destinationParishField,gbc);		
		
		
		destinationLabel = new JLabel("<html><br></html>");
		gbc.gridwidth=3;
		gbc.gridy=10;
		gbc.gridx=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(destinationLabel,gbc);
		
		destinationLabel = new JLabel("<html>________________________________________<br><br></html>");
		gbc.gridwidth=3;
		gbc.gridy=11;
		gbc.gridx=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(destinationLabel,gbc);
		
		gbc = new GridBagConstraints();
		ratesJLabel = new JLabel("Rate : ");
		gbc.gridy=12;
		gbc.gridx=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(ratesJLabel,gbc);
		
		ratesField = new JTextField();
		gbc.gridx =1;
		gbc.gridy=12;
		ratesField.setColumns(5);
		panel.add(ratesField,gbc);
		
		
		distanceLabel = new JLabel("Distance (km) : ");
		gbc.gridy=13;
		gbc.gridx=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(distanceLabel,gbc);
		
		distanceField = new JTextField();
		gbc.gridx =1;
		gbc.gridy=13;
		distanceField.setColumns(5);
		panel.add(distanceField,gbc);
		
		
		//buttons
		confirmButton = new JButton("Confirm");
		gbc.gridx=0;
		gbc.gridy=14;
		gbc.insets= new Insets(10, 0, 0, 0);
		
		confirmButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Check if any of the fields are empty
		        if (routeField.getText().isEmpty() || sourceStreetField.getText().isEmpty() || sourceCommuityField.getText().isEmpty()
		                || sourceParishField.getText().isEmpty() || destinationStreetField.getText().isEmpty() || destinationCommuityField.getText().isEmpty()
		                || destinationParishField.getText().isEmpty() || ratesField.getText().isEmpty()) {

					logger.info("Missing fields when confirm was clicked");
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Missing Data", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        else {
		        	
		        	databaseAction.RouteDatabaseAction routeAction = new RouteDatabaseAction();
		        	Address sourceAddress = new Address(routeField.getText(), sourceStreetField.getText(), sourceCommuityField.getText(), sourceParishField.getText());
		        	Address destinationAddress = new Address(routeField.getText(),destinationStreetField.getText(),destinationCommuityField.getText(),sourceParishField.getText());
		        	RouteRate routeRate = new RouteRate(routeField.getText(), sourceAddress, destinationAddress,Double.parseDouble(ratesField.getText()), Double.parseDouble(distanceField.getText()));
		        	
		        	if(routeAction.routeExists(routeRate)==false) {
		        		routeAction.addRouteRate(routeRate);
		        	}
		        }
		    }
		});

		panel.add(confirmButton,gbc);
		
		clearButton = new JButton("Clear");
		gbc.insets= new Insets(10, 30, 0, 0);
		gbc.gridx=1;
		gbc.gridy=14;
		panel.add(clearButton,gbc);
		
		
		panel.setPreferredSize(new Dimension(700, 600));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
