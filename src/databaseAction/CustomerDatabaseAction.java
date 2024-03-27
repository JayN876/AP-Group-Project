package databaseAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import personalInfo.Address;
import personalInfo.Customer;

public class CustomerDatabaseAction {
	
	
    private java.sql.Connection myConn=null;
    
    public CustomerDatabaseAction() {
        myConn = databaseAction.DataBase.getDatabaseConnection();
    }
    
    public void addCustomer(Customer customer) {
        try {
            // Check if a customer with the same ID already exists
            if (customerExists(customer.getCusID())) {
                JOptionPane.showMessageDialog(null, "A customer with the same ID already exists.", "Duplicate Customer", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method as validation failed
            }
            
            // Prepare the SQL statement
            String sql = "INSERT INTO Customer (customerId, fName, lName, email, status, emergencyNo, company, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Set the parameters for the statement using the Customer object
            statement.setString(1, customer.getCusID());
            statement.setString(2, customer.getfName());
            statement.setString(3, customer.getlName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getStatus());
            statement.setString(6, customer.getEmergencyNo());
            statement.setString(7, customer.getCompany());
            statement.setString(8, customer.getTelephone());

            // Execute the insert statement
            int rowsAffected = statement.executeUpdate();

            // Check if the customer was added successfully
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Customer Added Successfully", "Customer Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Customer", "Customer Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
            
            // Check if address line one is blank
            if (customer.getAddress().isEmpty()==false) {//if data was entered in address line one then it is added to the database
            	addAddress(customer.getAddress());
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addAddress(Address address) {
        try {
            // Check if the address already exists
            if (addressExists(address)) {
                JOptionPane.showMessageDialog(null, "An address with the same details already exists.", "Duplicate Address", JOptionPane.WARNING_MESSAGE);
                return; // Exit the method as validation failed
            }

            // Prepare the SQL statement
            String sql = "INSERT INTO CustomerAddress (customerId, addressLine1, addressLine2, community, parish, country) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Set the parameters for the statement using the Address object
            statement.setString(1, address.getId());
            statement.setString(2, address.getAddressLine1());
            statement.setString(3, address.getAddressLine2());
            statement.setString(4, address.getCommunity());
            statement.setString(5, address.getParish());
            statement.setString(6, address.getCountry());
            // Execute the insert statement
            int rowsAffected = statement.executeUpdate();

            // Check if the address was added successfully
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Address Added Successfully", "Address Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Address", "Address Status", JOptionPane.ERROR_MESSAGE);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean addressExists(Address address) throws SQLException {
        // Prepare the SQL statement to check if the address already exists
        String sql = "SELECT COUNT(*) FROM CustomerAddress WHERE customerId = ? AND addressLine1 = ? AND addressLine2 = ? AND community = ? AND parish = ?";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, address.getId()); // Assuming getCustomerId() method exists in the Address class
        statement.setString(2, address.getAddressLine1());
        statement.setString(3, address.getAddressLine2());
        statement.setString(4, address.getCommunity());
        statement.setString(5, address.getParish());

        // Execute the query
        ResultSet resultSet = statement.executeQuery();

        // Check if any rows were returned
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Return true if the address already exists
        }

        // Close resources
        resultSet.close();
        statement.close();

        return false; // Return false if the address does not exist
    }

    
    public boolean customerExists(String customerId) throws SQLException {
        // Prepare the SQL statement to check if a customer with the given ID exists
        String sql = "SELECT COUNT(*) FROM Customer WHERE customerId = ?";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, customerId);

        // Execute the query
        ResultSet resultSet = statement.executeQuery();

        // Check if any rows were returned
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Return true if a customer with the given ID exists
        }

        // Close resources
        resultSet.close();
        statement.close();

        return false; // Return false if no customer with the given ID exists
    }
    
}
