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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databaseAction.StaffDatabaseAction;
import personalInfo.Address;
import personalInfo.Date;
import personalInfo.Driver;
import personalInfo.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StaffJPanel {
    

	private static final Logger logger = LogManager.getLogger(StaffJPanel.class);	
	private JLabel staffHeading;
	private JLabel staffIDLabel;
	private JTextField staffIDField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JLabel fNameLabel;
	private JTextField fNameField;
	private JLabel lNameLabel;
	private JTextField lNameField;
	private JLabel dobLabel;
	private JTextField dobDayField;
	private JTextField dobMonthField;
	private JTextField dobYearField;
	private JLabel label;
	private JLabel address1Label;
	private JTextField addressLine1;
	private JTextField addressLine2;
	private JTextField communityField;
	private JTextField parishField;
	private JTextField countryField;
	private JTextField telephoneField;
	private JTextField emailField;
	private JComboBox<String> positionBox;
	private JComboBox<String> adminPositionBox;
	private JComboBox<String> skillSetPositionBox;
	private JLabel statusJLabel;
	private JComboBox<String> statusBox;
	private JButton confirmButton;
	private JButton clearButton;
	private JPanel panel;
	private JLabel staffLabel;
	private JLabel contractorLabel;
	private JLabel skillSetLabel;
	private JTextField plateNumField;
	private JLabel plateNumLabel;
	private JLabel adminIDLabel;
	private JTextField adminField;
	private JTextField conIDField;
	private databaseAction.StaffDatabaseAction dbAction;
	
    public StaffJPanel() {
        panel = new JPanel(new GridBagLayout());
        dbAction = new StaffDatabaseAction();
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        panel.setPreferredSize(new Dimension(700, 600));
        //setting Heading
        staffHeading = new JLabel("Enter Staff Info");
        Font font = staffHeading.getFont();
        staffHeading.setFont(new Font(font.getFontName(), font.getStyle(), 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridwidth=2;
        panel.add(staffHeading, gbc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        //setting ID Label
        gbc.gridx = 0;
        gbc.gridy = 1; // Next row
        staffIDLabel = new JLabel("Staff ID :  ");
        panel.add(staffIDLabel, gbc);
        
        //setting ID TextArea
        staffIDField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        staffIDField.setColumns(10);
        panel.add(staffIDField,gbc);
           
        
        //setting FName Label
        gbc.gridx=0;
        gbc.gridy = 2; // Next row
        fNameLabel = new JLabel("First Name: ");
        panel.add(fNameLabel, gbc);
        
        //setting FName TextField
        gbc.gridx =1;
        gbc.gridy= 2;
        fNameField = new JTextField();
        fNameField.setColumns(15);
        panel.add(fNameField,gbc);
        
        //setting LName JLabel
        gbc.gridx=0;
        gbc.gridy=3;
        lNameLabel = new JLabel("Last Name:  ");
        panel.add(lNameLabel,gbc);
        
        //setting LName JTextField
        gbc.gridx=1;
        gbc.gridy=3;
        lNameField = new JTextField();
        lNameField.setColumns(15);
        panel.add(lNameField,gbc);
        
        //setting DOB Label
        gbc.gridx=0;
        gbc.gridy=4;
        dobLabel = new JLabel("<html>DOB<br>(mm/dd/yy): </html>");
        panel.add(dobLabel,gbc);
        
        //setting DOB Fields
        gbc.gridx=1;
        gbc.gridy=4;
        dobMonthField = new JTextField();
        dobMonthField.setColumns(2);
        panel.add(dobMonthField,gbc);
        
        gbc.gridx=2;
        gbc.gridy=4;
        gbc.insets=new Insets(0,-140, 0, 0);
        label = new JLabel("/");
        panel.add(label,gbc);
        
        gbc.gridx=3;
        gbc.gridy=4;
        gbc.insets=new Insets(0,-133, 0, 0);
        dobDayField = new JTextField();      
        dobDayField.setColumns(2);
        panel.add(dobDayField,gbc);
        
        gbc.gridx=4;
        gbc.gridy=4;
        gbc.insets=new Insets(0,-105, 0, 0);
        label = new JLabel("/");
        panel.add(label,gbc);
        
        gbc.gridx=5;
        gbc.gridy=4;
        gbc.insets=new Insets(0,-97, 0, 0);
        dobYearField = new JTextField();      
        dobYearField.setColumns(3);
        panel.add(dobYearField,gbc);
        
        //address 1 JLabel
        
        gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(new JLabel("___________________________________"),gbc);
        
        gbc= new GridBagConstraints();
        address1Label = new JLabel("Address");
        gbc.gridy=6;
        gbc.gridx=0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(address1Label,gbc);
        
        gbc.gridy=7;
        gbc.gridx=0;
        label = new JLabel("Address Line 1: ");
        panel.add(label,gbc);
        
        gbc.gridx =1;
        addressLine1 = new JTextField();
        addressLine1.setColumns(15);
        panel.add(addressLine1,gbc);
        
        gbc.gridy=8;
        gbc.gridx=0;
        label = new JLabel("Address Line 2: ");
        panel.add(label,gbc);
        
        gbc.gridx =1;
        addressLine2 = new JTextField();
        addressLine2.setColumns(15);
        panel.add(addressLine2,gbc);
        
        gbc.gridx =0;
        gbc.gridy=9;
        label = new JLabel("Community : ");
        panel.add(label,gbc);
        
        gbc.gridx = 1;
        communityField = new JTextField();
        communityField.setColumns(15);
        panel.add(communityField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=10;
        label = new JLabel("Parish : ");
        panel.add(label,gbc);
        
        gbc.gridx=1;
        parishField= new JTextField();
        parishField.setColumns(15);
        panel.add(parishField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=11;
        label = new JLabel("Country : ");
        panel.add(label,gbc);
        
        gbc.gridx=1;
        countryField= new JTextField();
        countryField.setColumns(15);
        panel.add(countryField,gbc);
        
        gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=12;
        gbc.gridwidth=5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(new JLabel("___________________________________"),gbc);
		
		gbc.gridx =0;
        gbc.gridy =13;
        label = new JLabel("Telephone: ");
        panel.add(label,gbc);
        
        gbc.gridx =1;
        gbc.gridy =13;
        telephoneField = new JTextField();
        telephoneField.setColumns(15);
        panel.add(telephoneField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=14;
        label = new JLabel("Email: ");
        panel.add(label,gbc);
        
        gbc.gridx=1;
        gbc.gridy=14;
        emailField = new JTextField();
        emailField.setColumns(15);
        panel.add(emailField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=15;
        label = new JLabel("Position: ");
        panel.add(label,gbc);
        
        gbc.gridx=1;
        gbc.gridy=15;
        String empPosition[]= {"Select an Option","Administrative Staff","Drivers","Maintenance Workers"};
        positionBox = new JComboBox<String>(empPosition);
        
        positionBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                String selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption.equals("Administrative Staff")) {
                    staffLabel.setVisible(true);
                    adminPositionBox.setVisible(true);
                    adminPositionBox.setSelectedIndex(0);
                    
                    adminIDLabel.setVisible(true);
                    adminField.setVisible(true);
                    passwordLabel.setVisible(true);
                    passwordField.setVisible(true);
                    
                    conIDField.setVisible(false);
                    conIDField.setText(null);
                	contractorLabel.setVisible(false);
                	skillSetLabel.setVisible(false);
            		skillSetPositionBox.setVisible(false);
            		plateNumField.setVisible(false);
            		plateNumLabel.setVisible(false);
            		plateNumField.setText(null);
            		
                    // Perform actions specific to Administrative Staff
                } 
                else if(selectedOption.equals("Drivers")||selectedOption.equals("Maintenance Workers") ){
                	//if a contractor is choosen the contractor ID option will be available
                	plateNumField.setVisible(false);
            		plateNumLabel.setVisible(false);
            		plateNumField.setText(null);
                	staffLabel.setVisible(false);
                    adminPositionBox.setVisible(false);
                    adminPositionBox.setSelectedIndex(0);
                    adminIDLabel.setVisible(false);
                    adminField.setVisible(false);
                    adminField.setText("");
                    passwordLabel.setVisible(false);
                    passwordField.setVisible(false);
                    skillSetLabel.setVisible(false);
            		skillSetPositionBox.setVisible(false);
            		skillSetPositionBox.setSelectedIndex(0);
                	conIDField.setVisible(true);
                	contractorLabel.setVisible(true);
                	
                	//if a maintenace worker is choosen the skillset option will be available
                	if(selectedOption.equals("Maintenance Workers") ) {
                		skillSetLabel.setVisible(true);
                		skillSetPositionBox.setVisible(true);
                	}
                	
                	//if a driver is choosen the plateNumber option will be available
                	if(selectedOption.equals("Drivers") ) {
                		plateNumField.setVisible(true);
                		plateNumLabel.setVisible(true);
                	}
                	
                }
                else {//when "select an option" is selected or when clear button is pressed
                	plateNumField.setVisible(false);
            		plateNumLabel.setVisible(false);
            		plateNumField.setText(null);
                	staffLabel.setVisible(false);
                    adminPositionBox.setVisible(false);
                    adminPositionBox.setSelectedIndex(0);
                    passwordLabel.setVisible(false);
                    passwordField.setVisible(false);
                    conIDField.setVisible(false);
                	contractorLabel.setVisible(false);
                	conIDField.setText(null);
                	skillSetLabel.setVisible(false);
            		skillSetPositionBox.setVisible(false);
            		skillSetPositionBox.setSelectedIndex(0);
            		adminIDLabel.setVisible(false);
                    adminField.setVisible(false);
                    adminField.setText(null);
                    
                }
				
			}
		});
        panel.add(positionBox,gbc);
        
        
        //Label for admin staff
        gbc.gridx=0;
        gbc.gridy=16;
        staffLabel = new JLabel("Staff Type : ");
        staffLabel.setVisible(false);
        panel.add(staffLabel,gbc);
        
        //Combo box to select type of admin staff
        gbc.gridx=1;
        gbc.gridy=16;
        String adminStaffPosition[]= {"Administrative Clerk","Manager","Supervisor","HR Manager"};
        
        adminPositionBox = new JComboBox<String>(adminStaffPosition);
        adminPositionBox.setVisible(false);
        panel.add(adminPositionBox,gbc);
        
        //Label for Admin ID
        gbc.gridx=0;
        gbc.gridy=17;
        adminIDLabel = new JLabel("Admin ID : ");
        adminIDLabel.setVisible(false);
        panel.add(adminIDLabel,gbc);
        
        gbc.gridx=1;
        gbc.gridy=17;
        adminField = new JTextField();
        adminField.setVisible(false);
        adminField.setColumns(15);
        panel.add(adminField,gbc);
        
        
        
        //Label for constractorID
        gbc.gridx=0;
        gbc.gridy=16;
        contractorLabel = new JLabel("Contractor ID ");
        contractorLabel.setVisible(false);
        panel.add(contractorLabel,gbc);
        
        gbc.gridx=1;
        gbc.gridy=16;
        conIDField = new JTextField();
        conIDField.setVisible(false);
        conIDField.setColumns(15);
        panel.add(conIDField,gbc);
        
        gbc=new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        //special attributes for maintenance worker
        
        gbc.gridx=0;
        gbc.gridy=17;
        skillSetLabel = new JLabel("SkillSet : ");
        skillSetLabel.setVisible(false);
        panel.add(skillSetLabel,gbc);
        
        gbc.gridx=1;
        gbc.gridy=17;
        String skillSets[]= {"Vehicle Maintenance","Facility Maintenance","IT Maintenance"};  
        skillSetPositionBox = new JComboBox<String>(skillSets);
        skillSetPositionBox.setVisible(false);
        panel.add(skillSetPositionBox,gbc);
        
        //special attribute for driver
        gbc.gridx=0;
        gbc.gridy=17;
        plateNumLabel = new JLabel("Plate Number : ");
        plateNumLabel.setVisible(false);
        panel.add(plateNumLabel,gbc);
        
        gbc.gridx=1;
        gbc.gridy=17;
        plateNumField = new JTextField();
        plateNumField.setVisible(false);
        plateNumField.setColumns(15);
        panel.add(plateNumField,gbc);
        
        //setting ID Label
        gbc.gridx = 0;
        gbc.gridy = 18; // Next row
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets=new Insets(0, 0, 0, 0);
        passwordLabel = new JLabel("Password :  ");
        panel.add(passwordLabel, gbc);
        
        //setting ID TextArea
        passwordField = new JTextField();
        gbc.gridx =1;
        gbc.gridy=18;     
        passwordField.setColumns(10);
        panel.add(passwordField,gbc);
        
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=19;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        label = new JLabel("Status: ");
        panel.add(label,gbc);
        
        gbc.gridx=1;
        gbc.gridy=19;
        String status[] = {"active","inactive"};
        statusBox = new JComboBox<String>(status);
        panel.add(statusBox,gbc);
        
        gbc.gridx=0;
        gbc.gridy=20;
        confirmButton = new JButton("Confirm");
        gbc.insets = new Insets(20, 0, 0, 0);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // Check if staffID, firstName, lastName, DOB, and position are empty
                boolean staffIDEmpty = staffIDField.getText().isEmpty();
                boolean firstNameEmpty = fNameField.getText().isEmpty();
                boolean lastNameEmpty = lNameField.getText().isEmpty();
                boolean dobEmpty = dobMonthField.getText().isEmpty() || dobDayField.getText().isEmpty() || dobYearField.getText().isEmpty();
                boolean positionEmpty = positionBox.getSelectedIndex() == 0;
                
                boolean parish = parishField.getText().isEmpty();
                boolean staffType = staffIDField.getText().isEmpty();
                boolean adminId = adminField.getText().isEmpty();
            	boolean password = passwordField.getText().isEmpty()|| passwordField.getText().length()<8;
            	boolean telephone = telephoneField.getText().isEmpty();
            	boolean email = emailField.getText().isEmpty();
                // Check if elements of address one is empty
                boolean addressOneEmpty = (addressLine1.getText().isEmpty() && addressLine2.getText().isEmpty())||communityField.getText().isEmpty()|| parishField.getText().isEmpty()||countryField.getText().isEmpty();
               
                Boolean contID= conIDField.getText().isEmpty();
                Boolean plateNum = plateNumField.getText().isEmpty();
                
                String errorMessage = "Please enter the following mandatory fields:\n";
                

                
                if (staffIDEmpty || firstNameEmpty || lastNameEmpty || dobEmpty || positionEmpty||addressOneEmpty||telephone|| email) {
                    
                    logger.info("Staff form is Incomplete");
                    if (staffIDEmpty) errorMessage += "- Staff ID\n";
                    if (firstNameEmpty) errorMessage += "- First Name\n";
                    if (lastNameEmpty) errorMessage += "- Last Name\n";
                    if (dobEmpty) errorMessage += "- Date of Birth\n";
                    if (positionEmpty) errorMessage += "- Position\n";
                    if (addressOneEmpty) errorMessage +="- Address Field is incomplete\n";
                    if (telephone) errorMessage+= "- Telephone\n";
                    if (email) errorMessage +="- Email\n";
                    JOptionPane.showMessageDialog(null, errorMessage, "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                    return; // Exit the method early as validation failed
                }
                
                if (adminIDLabel.isVisible()&&(staffType || adminId || password)) {
                    
                    logger.info("Staff form is Incomplete");
                	if(staffType) errorMessage += "- StaffType\n";;
                	if(adminId) errorMessage +="- AdminID\n";
                	if(password) errorMessage +="- Password( 8 characters)\n";
                	JOptionPane.showMessageDialog(null, errorMessage, "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                	return;
                }
                //if driver was selected ensure contractor id and platenumber is not blank
                else if(positionBox.getSelectedIndex()==2&&(contID||plateNum)) {

                    logger.info("Staff form is Incomplete");
                	if(contID) errorMessage += "- ContractorID\n";;
                	if(plateNum) errorMessage +="- PlateNumber\n";
                	JOptionPane.showMessageDialog(null, errorMessage, "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                	return;
                }
                //if maintenance worker is selected ensure contractor id is not blank
                else if(positionBox.getSelectedIndex()==3&&contID) {

                    logger.info("Staff form is Incomplete");
                	if(contID) errorMessage += "- ContractorID\n";
                	JOptionPane.showMessageDialog(null, errorMessage, "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                	return;
                }
                //if all mandatory information is entered then data will be inserted
                
                //Convert data retrieved from text field to integer to match date primary constructor
            	Date dob = new Date(Integer.parseInt(dobDayField.getText()),Integer.parseInt(dobMonthField.getText()),Integer.parseInt(dobYearField.getText()));
            	Address address = new Address(staffIDField.getText(), addressLine1.getText(),addressLine2.getText() ,communityField.getText(), parishField.getText(),countryField.getText());

        		Staff staff = new Staff(staffIDField.getText(),passwordField.getText(),fNameField.getText(),lNameField.getText(),dob,address,telephoneField.getText(),emailField.getText(),(String)positionBox.getSelectedItem(),(String)statusBox.getSelectedItem());
        		
        		
                String selectedOption = (String) positionBox.getSelectedItem();
                
                //if a duplicate is not found and driver is selected
        		if (dbAction.staffExists(staffIDField.getText())==false &&dbAction.adminExists(adminField.getText()) ==false && dbAction.contractorExists(conIDField.getText())==false && dbAction.driverExists(plateNumField.getText())==false) {
        			dbAction.insertStaff(staff);
        			if(selectedOption.equals("Drivers")) {
	        			Driver driver = new Driver(staff,conIDField.getText() ,plateNumField.getText());
	        			dbAction.addContractor(conIDField.getText(), staffIDField.getText());
	        			dbAction.addDriver(driver);
        			}
        			else if(selectedOption.equals("Maintenance Workers")) {
        				dbAction.addContractor(conIDField.getText(), staffIDField.getText());
        				dbAction.addMaintenance(conIDField.getText(), staffIDField.getText(), (String) skillSetPositionBox.getSelectedItem());
        			}
        			//before adding admin record a check is done to avoid adding duplicate
        			else if(selectedOption.equals("Administrative Staff")) {
        				dbAction.addAdmin(adminField.getText(), staffIDField.getText(),(String) adminPositionBox.getSelectedItem());
        				dbAction.addLoginInfo(staffIDField.getText(),passwordField.getText());
        				String staffAction[]= {"Add Deliver Request", "Add Route and Rate", "Add Staff","Add Customer","View Outstanding Balance","View Report and Invoice"};
        				String clerkAction[]= {"View Rate Sheet","Add Route and Rate","Add Deliver Request","View Report and Invoice"};
        				int i=0;
        				String staffPosition=(String)positionBox.getSelectedItem();
        				if(staffPosition.equals("Administrative Clerk")) {
        					
        					for(i=0;i<4;i++) {
        						dbAction.addAdminAction(staffAction[i],adminField.getText());
        					}
        					
        				}
        				else {
	        				for(i=0;i<5;i++) {
	        					dbAction.addAdminAction(staffAction[i],adminField.getText());
	        				}
        				}
        			}
        			
        		}
        		
            }
            
        });
        
        panel.add(confirmButton,gbc);
                
        gbc.gridx=1;
        gbc.gridy=20;
        clearButton = new JButton("Clear");
        gbc.insets = new Insets(20, 30, 0, 0);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all fields
                staffIDField.setText("");
                fNameField.setText("");
                lNameField.setText("");
                dobMonthField.setText("");
                dobDayField.setText("");
                dobYearField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                // Clear selection for JComboBoxes
                positionBox.setSelectedIndex(0);
                adminPositionBox.setSelectedIndex(0);
                skillSetPositionBox.setSelectedIndex(0);
                statusBox.setSelectedIndex(0);
            }
        });
        panel.add(clearButton,gbc);
              
    }
    
   public JPanel getPanel() {
	   return panel;
   }
   
}

