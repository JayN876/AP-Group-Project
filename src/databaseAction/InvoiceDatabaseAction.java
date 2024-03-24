package databaseAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class InvoiceDatabaseAction {
    private java.sql.Connection myConn = null;

    public InvoiceDatabaseAction() {
        myConn = databaseAction.DataBase.getDatabaseConnection();
    }

    public ResultSet getInvoiceDetails() {
        ResultSet resultSet = null;

        try {
            // Construct the SQL query to select invoice details
            String sql = "SELECT " +
                            "o.invoiceNo, " +
                            "CONCAT(rr.sourceStreet, ', ', rr.sourceCommunity, ', ', rr.sourceParish) AS 'Source Address', " +
                            "CONCAT(rr.destinationStreet, ', ', rr.destinationCommunity, ', ', rr.destinationParish) AS 'Destination Address', " +
                            "c.company AS 'Company', " +
                            "o.customerId, " +
                            "o.adminId AS 'Billed by', " +
                            "rr.rate " +
                        "FROM " +
                            "Orders o " +
                        "JOIN " +
                            "RouteRate rr ON o.routeId = rr.routeId " +
                        "JOIN " +
                            "Customer c ON o.customerId = c.customerId";

            // Create prepared statement
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Execute query
            resultSet = statement.executeQuery();

            JOptionPane.showMessageDialog(null, "Successfully retrieved All records", "Invoice Records Status",JOptionPane.INFORMATION_MESSAGE );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
    
    
    public ResultSet getInvoiceDetailsByCustomerID(String customerID) {
        ResultSet resultSet = null;

        try {
            // Construct the SQL query to select invoice details for a specific customer
            String sql = "SELECT " +
                            "o.invoiceNo, " +
                            "CONCAT(rr.sourceStreet, ', ', rr.sourceCommunity, ', ', rr.sourceParish) AS 'Source Address', " +
                            "CONCAT(rr.destinationStreet, ', ', rr.destinationCommunity, ', ', rr.destinationParish) AS 'Destination Address', " +
                            "c.company AS 'Company', " +
                            "o.customerId, " +
                            "o.adminId AS 'Billed by', " +
                            "rr.rate " +
                        "FROM " +
                            "Orders o " +
                        "JOIN " +
                            "RouteRate rr ON o.routeId = rr.routeId " +
                        "JOIN " +
                            "Customer c ON o.customerId = c.customerId " +
                        "WHERE " +
                            "o.customerId = ?";  // Use parameter placeholder for customerID

            // Create prepared statement
            PreparedStatement statement = myConn.prepareStatement(sql);
            // Set the customerID parameter
            statement.setString(1, customerID);

            // Execute query
            resultSet = statement.executeQuery();

            JOptionPane.showMessageDialog(null, "Successfully retrieved records with Customer ID : "+ customerID, "Invoice Records Status",JOptionPane.INFORMATION_MESSAGE );
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

}
