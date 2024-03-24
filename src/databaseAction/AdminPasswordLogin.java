package databaseAction;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPasswordLogin {
    
    private Connection myConn = null;
    
    public AdminPasswordLogin() {
        myConn = DataBase.getDatabaseConnection();
    }
    
    
    public Boolean verifyPasswordAndID(String staffID, String password) {
        try {
            // Prepare SQL query to check admin credentials with case sensitivity and status
            String query = "SELECT COUNT(*) FROM AdminLogin AS a INNER JOIN Staff AS s ON a.staffId = s.staffId WHERE a.staffId = ? AND BINARY a.password = ? AND s.status = 'Active'";
            PreparedStatement stmt = myConn.prepareStatement(query);
            stmt.setString(1, staffID);
            stmt.setString(2, password);
            
            // Execute query
            ResultSet rs = stmt.executeQuery();
            
            // If any row is returned, credentials are valid
            if (rs.next()) {
                int count = rs.getInt(1);
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
