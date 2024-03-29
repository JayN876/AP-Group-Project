package databaseAction;

import javax.swing.JOptionPane;

import helpers.PropertyLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AdminPasswordLogin {
    
    private Connection myConn = null;
    private final PropertyLoader _propertyLoader = new PropertyLoader(
			"DeliveryRequestPreparedStatements.properties");
	private final Properties _properties;

    public AdminPasswordLogin() {
        myConn = DataBase.getDatabaseConnection();
        _properties = _propertyLoader.getProperties();
    }
    
    
    public Boolean verifyPasswordAndID(String staffID, String password) {
        try {
            // Prepare SQL query to check admin credentials with case sensitivity and status
            String query = "SELECT COUNT(*), s.staffId FROM AdminLogin AS a INNER JOIN Staff AS s ON a.staffId = s.staffId WHERE a.staffId = ? AND BINARY a.password = ? AND s.status = 'Active'";
            PreparedStatement stmt = myConn.prepareStatement(query);
            stmt.setString(1, staffID);
            stmt.setString(2, password);
            
            // Execute query
            ResultSet rs = stmt.executeQuery();
            
            // If any row is returned, credentials are valid
            if (rs.next()) {
                int count = rs.getInt(1);
                String adminId = rs.getString(2);
                String currentUser = (String) _properties.get("CURRENT_USER");
                if(currentUser != null) {
                	_properties.remove("CURRENT_USER");
                	_propertyLoader.addKeyValue("CURRENT_USER", adminId);
                }else {
                	_propertyLoader.addKeyValue("CURRENT_USER", adminId);
                }
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    return true;
                }
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        return false;
    }



}
