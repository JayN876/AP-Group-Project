package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databaseAction.CustomerDatabaseAction;
import personalInfo.Address;
import personalInfo.Customer;

public class CustomerJPanel {
	

	private static final Logger logger = LogManager.getLogger(CustomerJPanel.class);
	
	private JLabel headingJLabel;
	private JLabel customerID;
	private JLabel fnameLabel;
	private JTextField fnameField;
	private JLabel lnameLabel;
	private JTextField lnameField;
	private JTextField cusIDField;
	private JLabel company;
	private JTextField companyField;
	private JLabel emergencyNoLabel;
	private JTextField emergencyField;
	private JLabel addressLabel;
	private JLabel addressLine1Label;
	private JLabel addressLine2Label;
	private JTextField addressLine1Field;
	private JTextField addressLine2Field;
	private JTextField communityField;
	private JTextField parishORStateField;
	private JLabel parishLabel;
	private JLabel telephoneLabel;
	private JTextField telephoneField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel statusLabel;
	private JComboBox<String> statusComboBox;
	private JButton confirmButton;
	private JButton clearButton;
	private GridBagConstraints gbc;
	private JPanel panel;
	private JLabel countryLabel;
	private JLabel communityLabel;
	private JTextField countryField;
	
	public CustomerJPanel() {
		logger.info("Customer Panel Launched");
		panel = new JPanel();
		gbc = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		
		//Labels
		headingJLabel = new JLabel("Enter Customer Info");
        Font font = headingJLabel.getFont();
        headingJLabel.setFont(new Font(font.getFontName(), font.getStyle(), 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridwidth=2;
        panel.add(headingJLabel, gbc);
        
        company = new JLabel("Company : ");
        gbc.gridy=1;
        panel.add(company,gbc);
        
        fnameLabel = new JLabel("First Name: ");
        gbc.gridy=2;
        panel.add(fnameLabel,gbc);
        
        lnameLabel = new JLabel("Last Name: ");
        gbc.gridy=3;
        panel.add(lnameLabel,gbc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        customerID = new JLabel("Customer ID : ");
        gbc.gridy = 4;
        panel.add(customerID,gbc);
        	
        emergencyNoLabel = new JLabel("Emergency No : ");
        gbc.gridy=5;
        panel.add(emergencyNoLabel,gbc);
        
        gbc.gridy=6;
        gbc.gridwidth =2;
        panel.add(new JLabel("________________________________________"),gbc);
        
        addressLabel = new JLabel("Address ");
        gbc.gridy=7;
        panel.add(addressLabel,gbc);
		
        addressLine1Label = new JLabel("Address Line 1 : ");
        gbc.gridy=8;
        panel.add(addressLine1Label,gbc);
        
        addressLine2Label = new JLabel("<html>Address Line 2 : <br>(Optional)</html>");
        gbc.gridy=9;
        panel.add(addressLine2Label,gbc);
        
        communityLabel = new JLabel("Community : ");
        gbc.gridy=10;
        panel.add(communityLabel,gbc);
        
        parishLabel = new JLabel("<html>Parish or<br>State : </html> ");
        gbc.gridy=11;
        panel.add(parishLabel,gbc);
        
        
        countryLabel = new JLabel("Country : ");
        gbc.gridy=12;       
        panel.add(countryLabel,gbc);
        
        
        gbc.gridy=13;
        gbc.gridwidth =2;
        panel.add(new JLabel("________________________________________"),gbc);
        
        telephoneLabel = new JLabel("Telephone : ");
        gbc.gridy=14;
        panel.add(telephoneLabel,gbc);

        emailLabel = new JLabel("Email : ");
        gbc.gridy=15;
        panel.add(emailLabel,gbc);
        
        statusLabel = new JLabel("Status : ");
        gbc.gridy=16;
        panel.add(statusLabel,gbc);
        
        //column 2 Fields
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        companyField = new JTextField();
        companyField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(companyField,gbc);
        
        fnameField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        fnameField.setColumns(10);
        panel.add(fnameField,gbc); 
        
        lnameField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        lnameField.setColumns(10);
        panel.add(lnameField,gbc);
        
        cusIDField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        cusIDField.setColumns(10);
        panel.add(cusIDField,gbc);
        
        
        emergencyField = new JTextField();
        emergencyField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=5;
        panel.add(emergencyField,gbc);
        
        addressLine1Field = new JTextField();
        addressLine1Field.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=8;
        panel.add(addressLine1Field,gbc);
        
        addressLine2Field = new JTextField();
        addressLine2Field.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=9;
        panel.add(addressLine2Field,gbc);
        
        communityField = new JTextField();
        communityField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=10;
        panel.add(communityField,gbc);
        
        parishORStateField = new JTextField();
        parishORStateField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=11;
        panel.add(parishORStateField,gbc);
        
        countryField = new JTextField();
        countryField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=12;
        panel.add(countryField,gbc);
        
        telephoneField = new JTextField();
        telephoneField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=14;
        panel.add(telephoneField,gbc);
        
        emailField = new JTextField();
        emailField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=15;
        panel.add(emailField,gbc);
        
        String status[]= {"active", "inactive"};
        statusComboBox = new JComboBox<String>(status);
        gbc.gridx=1;
        gbc.gridy=16;
        panel.add(statusComboBox,gbc);
        
        confirmButton = new JButton("Confirm");
        gbc.gridx=0;
        gbc.gridy=17;
        int topPadding=20;
        gbc.insets = new Insets(topPadding, 0, 0, 0);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all required fields are filled
                if (fnameField.getText().isEmpty() || lnameField.getText().isEmpty() ||
                        cusIDField.getText().isEmpty() || companyField.getText().isEmpty() ||
                        emergencyField.getText().isEmpty() || 
                        (addressLine1Field.getText().isEmpty()&&addressLine2Field.getText().isEmpty()) || 
                        parishORStateField.getText().isEmpty() || countryField.getText().isEmpty()||
                        telephoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
                	logger.info("Customer Form was Incomplete");
                    // Display a message indicating that all fields are required
                    JOptionPane.showMessageDialog(null, "All fields except Address Line 2 are Mandatory.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                } 
                else {//if all mandatory fields are entered
                	logger.info("All Mandatory fields were entered");
	                databaseAction.CustomerDatabaseAction cusAction = new CustomerDatabaseAction();
	                Address address = new Address(cusIDField.getText(),addressLine1Field.getText(),addressLine2Field.getText(),communityField.getText() ,parishORStateField.getText(),countryField.getText());
	                Customer customer = new Customer(cusIDField.getText(), fnameField.getText(),lnameField.getText(),emergencyField.getText(),address, telephoneField.getText(), emailField.getText(), companyField.getText(),(String)statusComboBox.getSelectedItem() );
	                cusAction.addCustomer(customer);
	                
                }
            }
        });

        
        panel.add(confirmButton,gbc);
        

        
        clearButton = new JButton("Clear");   
        gbc.gridx=1;
        gbc.gridy=17;
        gbc.insets = new Insets(topPadding, 0, 0, 0);
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set all fields to empty strings
            	logger.info("All fields were cleared");
                fnameField.setText("");
                lnameField.setText("");
                cusIDField.setText("");
                companyField.setText("");
                emergencyField.setText("");
                addressLine1Field.setText("");
                addressLine2Field.setText("");
                communityField.setText("");
                parishORStateField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                countryField.setText("");
                
            }
        });

        
        panel.add(clearButton,gbc);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.setPreferredSize(new Dimension(700, 600));

	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public static void main(String[] args) {
		new CustomerJPanel();
	}
	
}
