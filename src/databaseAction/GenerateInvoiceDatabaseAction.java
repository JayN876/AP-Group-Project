package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateInvoiceDatabaseAction {
    
    private Connection myConn=null;
    
    public GenerateInvoiceDatabaseAction() {
        myConn = DataBase.getDatabaseConnection();
    }
    
    public ResultSet getInvoiceDetails(String customerId) {
        try {
            // Define the SQL query
            String sql = "SELECT CONCAT(rr.sourceStreet, ', ', rr.sourceCommunity, ', ', rr.sourceParish) AS SourceAddress, " +
                         "       CONCAT(rr.destinationStreet, ', ', rr.destinationCommunity, ', ', rr.destinationParish) AS DestinationAddress, " +
                         "       o.customerId AS CustomerID, " +
                         "       CONCAT(c.fName, ' ', c.lName) AS CustomerName, " +
                         "       o.invoiceNo AS OrderID, " +
                         "       rr.rate AS Rate, " +
                         "       CONCAT(s.fName, ' ', s.lName, ', ', a.adminId) AS BilledBy " +
                         "FROM Orders o " +
                         "JOIN Customer c ON o.customerId = c.customerId " +
                         "JOIN RouteRate rr ON o.routeId = rr.routeId " +
                         "JOIN Admin a ON o.adminId = a.adminId " +
                         "JOIN Staff s ON a.staffId = s.staffId " +
                         "WHERE o.customerId = ?";
        
            // Create a PreparedStatement
            PreparedStatement statement = myConn.prepareStatement(sql);
            
            // Bind the customerId parameter
            statement.setString(1, customerId);

            // Execute the query and return the ResultSet
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // or handle the error appropriately
        }
    }
    
    public ResultSet getTransactionDetails(String orderInvoiceNo) {
        try {
            // Define the SQL query
            String sql = "SELECT transactionNo, transactionDate,payment " +
                         "FROM Transaction " +
                         "WHERE orderInvoiceNo = ?";
        
            // Create a PreparedStatement
            PreparedStatement statement = myConn.prepareStatement(sql);
            
            // Bind the orderInvoiceNo parameter
            statement.setString(1, orderInvoiceNo);

            // Execute the query and return the ResultSet
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // or handle the error appropriately
        }
    }
}
