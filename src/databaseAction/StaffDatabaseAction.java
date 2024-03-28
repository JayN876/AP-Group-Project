package databaseAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import personalInfo.Address;
import personalInfo.Contractor;
import personalInfo.Date;
import personalInfo.Driver;
import personalInfo.Staff;



public class StaffDatabaseAction {
    
    private java.sql.Connection myConn=null;
    
    public StaffDatabaseAction() {
        myConn = databaseAction.DataBase.getDatabaseConnection();
    }
    
    public boolean insertStaff(Staff staff) {
        try {
        	
            // Check if a staff member with the same ID already exists
            if (staffExists(staff.getStaffID())) {
                return true; // Exit the method as validation failed
            }
            // Prepare the SQL statement
            String sql = "INSERT INTO approjectdatabase.staff (staffId, fName, lName, telephone, email, position, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);
            
            // Set the parameters for the statement using the Staff object
            statement.setString(1, staff.getStaffID());
            statement.setString(2, staff.getFirstName());
            statement.setString(3, staff.getLastName());
            statement.setString(4, staff.getTelephone());
            statement.setString(5, staff.getEmail());
            statement.setString(6, staff.getPosition());
            statement.setString(7, staff.getStatus());
            
            // Execute the insert statement
            if(statement.executeUpdate()==1) {
            	JOptionPane.showMessageDialog(null, "Staff Record Added Successfully","Staff Record Status",JOptionPane.INFORMATION_MESSAGE);                
            }
            else {
            	JOptionPane.showMessageDialog(null, "Staff Record NOT ADDED","Staff Record Status",JOptionPane.ERROR_MESSAGE);                
                
            }
            addDate(staff);
            // Check if address line one is blank
            if (staff.getAddress().isEmpty()==false) {//if data was entered in address line one then it is added to the database
            	addAddressLine1(staff);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }
    
    public boolean adminExists(String adminID) {
        try {
            // Prepare the SQL statement to check if a staff member with the given admin ID exists
            String sql = "SELECT COUNT(*) FROM approjectdatabase.Admin WHERE adminId = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, adminID);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);//if a row was return then a staff member already has that ID
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "A staff member with the same Admin ID already exists.", "Duplicate Admin ID", JOptionPane.WARNING_MESSAGE);
                    return true; // Return true if a staff member with the given ID exists
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no staff member with the given ID exists
    }

    public boolean staffExists(String staffID) {
        try {
            // Prepare the SQL statement to check if a staff member with the given ID exists
            String sql = "SELECT COUNT(*) FROM approjectdatabase.staff WHERE staffId = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, staffID);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);//if a row was return then a staff member already has that ID
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "A staff member with the same ID already exists.", "Duplicate Staff Member", JOptionPane.WARNING_MESSAGE);
                    return true; // Return true if a staff member with the given ID exists
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no staff member with the given ID exists
    }
    
    public void addDate(Staff staff) {
        try {
            // Get the date of birth as a string
            String dobString = staff.getDob().toString();
            // Get the staff ID
            String staffID = staff.getStaffID();

            // Construct the SQL query with placeholders for the values
            String sqlString = "UPDATE approjectdatabase.staff SET dob = ? WHERE staffId = ?";

            // Prepare the SQL statement
            PreparedStatement statement = myConn.prepareStatement(sqlString);
            // Set the parameters for the statement
            statement.setString(1, dobString);
            statement.setString(2, staffID);

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();
            
            if(rowsAffected==1) {
            	JOptionPane.showMessageDialog(null, "Date Record Added Successfully","Date Record Status",JOptionPane.INFORMATION_MESSAGE);                
            }
            else {
            	JOptionPane.showMessageDialog(null, "Date Record NOT ADDED","Date Record Status",JOptionPane.ERROR_MESSAGE);                
                
            }
            
            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void addAddressLine1(Staff staff) {
        try {           
            // Get the address details for address line 1
            Address address1 = staff.getAddress();
            
            // Construct the SQL query
            String sqlString = "INSERT INTO StaffAddress (staffId, addressLine1, addressLine2, community, parish, country) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare the SQL statement
            PreparedStatement statement = myConn.prepareStatement(sqlString);
            
            // Set the parameters for address line 1
            statement.setString(1, staff.getStaffID());
            statement.setString(2, address1.getAddressLine1());
            statement.setString(3, address1.getAddressLine2());
            statement.setString(4, address1.getCommunity());
            statement.setString(5, address1.getParish());
            statement.setString(6, address1.getCountry());

            // Execute the SQL statement for address line 1
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Address Line 1 Added Successfully", "Address Record Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Address Line 1 NOT ADDED", "Address Record Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   

    public Boolean addDriver(Driver driver) {
        try {
            // Check for duplicates
            if (checkDuplicateDriver(driver.getPlateNumber(), driver.getStaffID(), driver.getContractorID())) {
                JOptionPane.showMessageDialog(null, "Duplicate entry: Plate Number, Staff ID, and Contractor ID combination already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return false; // Exit the method as validation failed
            }
            
            // Construct the SQL query
            String sql = "INSERT INTO approjectdatabase.driver (plateNumber, staffId, contractorId) VALUES (?, ?, ?)";
            
            // Prepare the SQL statement
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, driver.getPlateNumber());
            statement.setString(2, driver.getStaffID());
            statement.setString(3, driver.getContractorID());

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Driver Added Successfully", "Driver Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Driver NOT ADDED", "Driver Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return true;
    }
    
    public void addContractor(String contractorID, String staffID) {
        try {
            // Construct the SQL query
            String sql = "INSERT INTO approjectdatabase.contractor (Contractor_ID, staffId) VALUES (?, ?)";
            
            // Prepare the SQL statement
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, contractorID);
            statement.setString(2, staffID);

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Contractor Added Successfully", "Contractor Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Contractor NOT ADDED", "Contractor Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkDuplicateDriver(String plateNumber, String staffId, String contractorId) throws SQLException {
        // Prepare the SQL statement to check for duplicates
        String sql = "SELECT COUNT(*) FROM approjectdatabase.driver WHERE plateNumber = ? AND staffId = ? AND contractorId = ?";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, plateNumber);
        statement.setString(2, staffId);
        statement.setString(3, contractorId);

        // Execute the query
        ResultSet resultSet = statement.executeQuery();

        // Check if any rows were returned
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Return true if duplicates exist
        }

        // Close resources
        resultSet.close();
        statement.close();

        return false; // Return false if no duplicates found
    }
    
    
    public void addMaintenance(String contractorID, String staffID, String skillSet) {
        try {
            // Construct the SQL query
            String sql = "INSERT INTO approjectdatabase.maintenance (Contractor_ID, staffId, skillSet) VALUES (?, ?, ?)";

            // Prepare the SQL statement
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, contractorID);
            statement.setString(2, staffID);
            statement.setString(3, skillSet);

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Maintenance record added successfully", "Maintenance Record Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add maintenance record", "Maintenance Record Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addAdmin(String adminId, String staffId, String position) {
        try {
            // Prepare the SQL statement
            String sql = "INSERT INTO approjectdatabase.admin (adminId, staffId, position) VALUES (?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Set the parameters for the statement
            statement.setString(1, adminId);
            statement.setString(2, staffId);
            statement.setString(3, position);

            // Execute the insert statement
            int rowsAffected = statement.executeUpdate();

            // Check if the admin was added successfully
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Admin Added Successfully", "Admin Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Admin", "Admin Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void addAdminAction(String action, String adminId) {
        try {
            // Check for duplicates
            if (checkDuplicateAdminAction(action, adminId)) {
                JOptionPane.showMessageDialog(null, "Duplicate entry: Action and Admin ID combination already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method as validation failed
            }

            // Prepare the SQL statement
            String sql = "INSERT INTO approjectdatabase.AdminAction (action, adminId) VALUES (?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Set the parameters for the statement
            statement.setString(1, action);
            statement.setString(2, adminId);

            // Execute the insert statement
            int rowsAffected = statement.executeUpdate();

            // Check if the data was inserted successfully
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Admin Action : "+action +"\nAdded Successfully", "Admin Action Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Admin Action: "+action, "Admin Action Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkDuplicateAdminAction(String action, String adminId) {
        try {
            // Prepare the SQL statement to check for duplicates
            String sql = "SELECT COUNT(*) FROM approjectdatabase.AdminAction WHERE action = ? AND adminId = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, action);
            statement.setString(2, adminId);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if duplicates exist
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if an error occurs or no duplicates found
    }


    public boolean contractorExists(String contractorID) {
        try {
            // Prepare the SQL statement to check if a contractor with the given ID exists
            String sql = "SELECT COUNT(*) FROM approjectdatabase.Contractor WHERE Contractor_ID = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, contractorID);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);//if a row was return then a contractor already has that ID
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "A contractor with the same ID already exists.", "Duplicate Contractor", JOptionPane.WARNING_MESSAGE);
                    return true; // Return true if a contractor with the given ID exists
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no contractor with the given ID exists
    }
    
    
    public boolean driverExists(String plateNumber) {
        try {
            // Prepare the SQL statement to check if a driver with the given plateNumber exists
            String sql = "SELECT COUNT(*) FROM approjectdatabase.Driver WHERE plateNumber = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, plateNumber);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);//if a row was return then a driver already has that plateNumber
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "A driver with the same plate number already exists.", "Duplicate Driver", JOptionPane.WARNING_MESSAGE);
                    return true; // Return true if a driver with the given plateNumber exists
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no driver with the given plateNumber exists
    }
    
    
    public void addLoginInfo(String staffID, String password) {
        String sql = "INSERT INTO AdminLogin (staffId, password) VALUES (?, ?)";
        
        try {
            // Create a PreparedStatement
            PreparedStatement statement = myConn.prepareStatement(sql);
            
            // Set values for parameters
            statement.setString(1, staffID);
            statement.setString(2, password);
            
            // Execute the insert statement
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Admin login record added successfully", "Admin Login Record Status",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    	
}
