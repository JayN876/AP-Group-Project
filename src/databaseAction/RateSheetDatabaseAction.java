package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RateSheetDatabaseAction {
    
    private Connection myConn = null;
    
    public RateSheetDatabaseAction() {
        myConn = DataBase.getDatabaseConnection();
    }
    
    public ResultSet getRouteInfo() {
        try {
            // Define the SQL query
            String sql = "SELECT routeId, rate, CONCAT(sourceStreet, ', ', sourceCommunity, ', ', sourceParish) AS SourceAddress, " +
                         "CONCAT(destinationStreet, ', ', destinationCommunity, ', ', destinationParish) AS DestinationAddress " +
                         "FROM RouteRate";
        
            // Create a PreparedStatement
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            
            // Display success message
            JOptionPane.showMessageDialog(null, "Records retrieved successfully.", "RateSheet Status", JOptionPane.INFORMATION_MESSAGE);
            
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // or handle the error appropriately
        }
    }

}
