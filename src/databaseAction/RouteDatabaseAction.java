package databaseAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import personalInfo.RouteRate;

public class RouteDatabaseAction {
	
	
    private java.sql.Connection myConn=null;
    
    public RouteDatabaseAction() {
        myConn = databaseAction.DataBase.getDatabaseConnection();
    }
    
    

    public void addRouteRate(RouteRate routeRate) {
        try {
            // Prepare the SQL statement
            String sql = "INSERT INTO RouteRate (routeId, rate, distance, sourceStreet, sourceParish, sourceCommunity, destinationStreet, destinationParish, destinationCommunity) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Set parameters using RouteRate object
            statement.setString(1, routeRate.getRouteID());
            statement.setDouble(2, routeRate.getRate());
            statement.setDouble(3, routeRate.getDistance());
            statement.setString(4, routeRate.getSourceAddress().getAddressLine1());
            statement.setString(5, routeRate.getSourceAddress().getParish());
            statement.setString(6, routeRate.getSourceAddress().getCommunity());
            statement.setString(7, routeRate.getDestinationAddress().getAddressLine1());
            statement.setString(8, routeRate.getDestinationAddress().getParish());
            statement.setString(9, routeRate.getDestinationAddress().getCommunity());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            // Close the statement
            statement.close();

            // Display JOptionPane message
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Record inserted successfully.", "Route and Rate Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Record Failed to insert data.", "Route and Rate Status", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while inserting data.", "Insertion Status", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public boolean routeExists(RouteRate route) {
        try {
            // Prepare the SQL statement to check if a route with the given ID exists
            String sql = "SELECT COUNT(*) FROM RouteRate WHERE routeId = ?";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, route.getRouteID());

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows were returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    // Display JOptionPane if duplicate route found
                    JOptionPane.showMessageDialog(null, "A route with the same ID already exists.", "Duplicate Route", JOptionPane.WARNING_MESSAGE);
                    return true; // Return true if a route with the given ID exists
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false; // Return false if an error occurs or no route with the given ID exists
    }
    
    
}
