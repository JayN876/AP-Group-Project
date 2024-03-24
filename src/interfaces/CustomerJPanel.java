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
	private JLabel contactPerson;
	private JTextField contactField;
	private JLabel address1Label;
	private JTextField streetNameField1;
	private JTextField communityField1;
	private JTextField parishField1;
	private JLabel address2Label;
	private JTextField streetNameField2;
	private JTextField communityField2;
	private JTextField parishField2;
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
        
        
        fnameLabel = new JLabel("First Name: ");
        gbc.gridy=1;
        panel.add(fnameLabel,gbc);
        
        lnameLabel = new JLabel("Last Name: ");
        gbc.gridy=2;
        panel.add(lnameLabel,gbc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        customerID = new JLabel("Customer ID : ");
        gbc.gridy = 3;
        panel.add(customerID,gbc);
        
        company = new JLabel("Company : ");
        gbc.gridy=4;
        panel.add(company,gbc);
		
        contactPerson = new JLabel("Contact Person : ");
        gbc.gridy=5;
        panel.add(contactPerson,gbc);
        
        gbc.gridy=6;
        gbc.gridwidth =2;
        panel.add(new JLabel("________________________________________"),gbc);
        
        address1Label = new JLabel("Address Line 1 ");
        gbc.gridy=7;
        panel.add(address1Label,gbc);
		
        address1Label = new JLabel("Street Name : ");
        gbc.gridy=8;
        panel.add(address1Label,gbc);
        
        address1Label = new JLabel("Community : ");
        gbc.gridy=9;
        panel.add(address1Label,gbc);
        
        address1Label = new JLabel("Parish : ");
        gbc.gridy=10;
        panel.add(address1Label,gbc);
        
        gbc.gridy=11;
        gbc.gridwidth =2;
        panel.add(new JLabel("________________________________________"),gbc);
        
        address2Label = new JLabel("Address Line 2   (OPTIONAL)");
        gbc.gridy=12;
        gbc.gridwidth=2;
        panel.add(address2Label,gbc);
        
        address2Label = new JLabel("Street Name : ");
        gbc.gridy=13;
        panel.add(address2Label,gbc);
        
        address2Label = new JLabel("Community : ");
        gbc.gridy=14;
        panel.add(address2Label,gbc);
        
        address2Label = new JLabel("Parish : ");
        gbc.gridy=15;
        panel.add(address2Label,gbc);
        
        gbc.gridy=16;
        gbc.gridwidth =2;
        panel.add(new JLabel("________________________________________"),gbc);
        
        telephoneLabel = new JLabel("Telephone : ");
        gbc.gridy=17;
        panel.add(telephoneLabel,gbc);

        emailLabel = new JLabel("Email : ");
        gbc.gridy=18;
        panel.add(emailLabel,gbc);
        
        statusLabel = new JLabel("Status : ");
        gbc.gridy=19;
        panel.add(statusLabel,gbc);
        
        //column 2 Fields
        gbc = new GridBagConstraints();
        
        fnameField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        fnameField.setColumns(10);
        panel.add(fnameField,gbc); 
        
        lnameField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        lnameField.setColumns(10);
        panel.add(lnameField,gbc);
        
        cusIDField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        cusIDField.setColumns(10);
        panel.add(cusIDField,gbc);
        
        companyField = new JTextField();
        companyField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=4;
        panel.add(companyField,gbc);
        
        contactField = new JTextField();
        contactField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=5;
        panel.add(contactField,gbc);
        
        streetNameField1 = new JTextField();
        streetNameField1.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=8;
        panel.add(streetNameField1,gbc);
        
        communityField1 = new JTextField();
        communityField1.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=9;
        panel.add(communityField1,gbc);
        
        parishField1 = new JTextField();
        parishField1.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=10;
        panel.add(parishField1,gbc);
        
        streetNameField2 = new JTextField();
        streetNameField2.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=13;
        panel.add(streetNameField2,gbc);
        
        communityField2 = new JTextField();
        communityField2.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=14;
        panel.add(communityField2,gbc);
        
        parishField2 = new JTextField();
        parishField2.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=15;
        panel.add(parishField2,gbc);
        
        
        telephoneField = new JTextField();
        telephoneField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=17;
        panel.add(telephoneField,gbc);
        
        emailField = new JTextField();
        emailField.setColumns(10);
        gbc.gridx=1;
        gbc.gridy=18;
        panel.add(emailField,gbc);
        
        String status[]= {"active", "inactive"};
        statusComboBox = new JComboBox<String>(status);
        gbc.gridx=1;
        gbc.gridy=19;
        panel.add(statusComboBox,gbc);
        
        confirmButton = new JButton("Confirm");
        gbc.gridx=0;
        gbc.gridy=20;
        int topPadding=20;
        gbc.insets = new Insets(topPadding, 0, 0, 0);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all required fields are filled
                if (fnameField.getText().isEmpty() || lnameField.getText().isEmpty() ||
                        cusIDField.getText().isEmpty() || companyField.getText().isEmpty() ||
                        contactField.getText().isEmpty() || 
                        (streetNameField1.getText().isEmpty() && communityField1.getText().isEmpty()) || 
                        parishField1.getText().isEmpty() ||
                        telephoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
                	logger.info("Customer Form was Incomplete");
                    // Display a message indicating that all fields are required
                    JOptionPane.showMessageDialog(null, "All fields except Address Line 2 are Mandatory.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                } 
                else {//if all mandatory fields are entered
                	logger.info("All Mandatory fields were entered");
	                databaseAction.CustomerDatabaseAction cusAction = new CustomerDatabaseAction();
	                Address address1 = new Address(cusIDField.getText(),streetNameField1.getText(),communityField1.getText() ,parishField1.getText());
	                Address address2 = new Address(cusIDField.getText(),streetNameField2.getText(),communityField2.getText() ,parishField2.getText());
	                Customer customer = new Customer(cusIDField.getText(), fnameField.getText(),lnameField.getText(),contactField.getText(),address1 , address2, telephoneField.getText(), emailField.getText(), companyField.getText(),(String)statusComboBox.getSelectedItem() );
	                cusAction.addCustomer(customer);
	                
                }
            }
        });

        
        panel.add(confirmButton,gbc);
        

        
        clearButton = new JButton("Clear");   
        gbc.gridx=1;
        gbc.gridy=20;
        gbc.insets = new Insets(topPadding, 0, 0, 0);
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set all fields to empty strings
                fnameField.setText("");
                lnameField.setText("");
                cusIDField.setText("");
                companyField.setText("");
                contactField.setText("");
                streetNameField1.setText("");
                communityField1.setText("");
                parishField1.setText("");
                streetNameField2.setText("");
                communityField2.setText("");
                parishField2.setText("");
                telephoneField.setText("");
                emailField.setText("");
                logger.info("All fields were cleared");
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
