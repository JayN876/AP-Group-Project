package databaseAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ReportDatabaseAction {
	
    private java.sql.Connection myConn=null;
    
    public ReportDatabaseAction() {
        myConn = databaseAction.DataBase.getDatabaseConnection();
    }
    
    public ResultSet viewReports() {
        ResultSet resultSet = null;
        
        try {
        	String sql = "SELECT " +
                    "r.routeId, " +
                    "CONCAT(r.sourceStreet, ', ', r.sourceCommunity, ', ', r.sourceParish) AS 'Source Address', " +
                    "CONCAT(r.destinationStreet, ', ', r.destinationCommunity, ', ', r.destinationParish) AS 'Destination Address', " +
                    "r.rate AS 'Rate', " + // Include the rate column
                    "dr.staffId AS 'StaffID', " +
                    "CONCAT(s.fName, ' ', s.lName) AS 'DriverName', " +
                    "o.dateOfOrder AS 'DateOfTrip' " +
                "FROM " +
                    "RouteRate r " +
                "JOIN " +
                    "Orders o ON r.routeId = o.routeId " +
                "JOIN " +
                    "Driver dr ON o.plateNumber = dr.plateNumber " +
                "JOIN " +
                    "Staff s ON dr.staffId = s.staffId";


            PreparedStatement statement = myConn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            JOptionPane.showMessageDialog(null, "Successfully retrieved all Records", "Report Status",JOptionPane.INFORMATION_MESSAGE );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
    
    
    
    public ResultSet viewReportsByDateRange(String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear) {
        ResultSet resultSet = null;

        try {
            // Parse string parameters into integers
            int startDayInt = Integer.parseInt(startDay);
            int startMonthInt = Integer.parseInt(startMonth);
            int startYearInt = Integer.parseInt(startYear);
            int endDayInt = Integer.parseInt(endDay);
            int endMonthInt = Integer.parseInt(endMonth);
            int endYearInt = Integer.parseInt(endYear);

            // Construct the SQL query with date range conditions
            String sql = "SELECT " +
                            "r.routeId, " +
                            "CONCAT(r.sourceStreet, ', ', r.sourceCommunity, ', ', r.sourceParish) AS 'Source Address', " +
                            "CONCAT(r.destinationStreet, ', ', r.destinationCommunity, ', ', r.destinationParish) AS 'Destination Address', " +
                            "r.rate AS 'Rate', " +
                            "dr.staffId AS 'StaffID', " +
                            "CONCAT(s.fName, ' ', s.lName) AS 'DriverName', " +
                            "o.dateOfOrder AS 'DateOfTrip' " +
                        "FROM " +
                            "RouteRate r " +
                        "JOIN " +
                            "Orders o ON r.routeId = o.routeId " +
                        "JOIN " +
                            "Driver dr ON o.plateNumber = dr.plateNumber " +
                        "JOIN " +
                            "Staff s ON dr.staffId = s.staffId " +
                        "WHERE " +
                            "o.dateOfOrder BETWEEN ? AND ?";
            
            // Create prepared statement
            PreparedStatement statement = myConn.prepareStatement(sql);
            // Set start date parameter
            statement.setDate(1, java.sql.Date.valueOf(startYearInt + "-" + startMonthInt + "-" + startDayInt));
            // Set end date parameter
            statement.setDate(2, java.sql.Date.valueOf(endYearInt + "-" + endMonthInt + "-" + endDayInt));

            // Execute query
            resultSet = statement.executeQuery();
            JOptionPane.showMessageDialog(null, "Successfully filtered orders by date", "Report Status",JOptionPane.INFORMATION_MESSAGE );
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
    
    
    public ResultSet viewReportsOrderedByDriverName() {
        ResultSet resultSet = null;

        try {
            // Construct the SQL query to select reports and order by driver name in ascending order
            String sql = "SELECT " +
                            "r.routeId, " +
                            "CONCAT(r.sourceStreet, ', ', r.sourceCommunity, ', ', r.sourceParish) AS 'Source Address', " +
                            "CONCAT(r.destinationStreet, ', ', r.destinationCommunity, ', ', r.destinationParish) AS 'Destination Address', " +
                            "r.rate AS 'Rate', " +
                            "dr.staffId AS 'StaffID', " +
                            "CONCAT(s.fName, ' ', s.lName) AS 'DriverName', " +
                            "o.dateOfOrder AS 'DateOfTrip' " +
                        "FROM " +
                            "RouteRate r " +
                        "JOIN " +
                            "Orders o ON r.routeId = o.routeId " +
                        "JOIN " +
                            "Driver dr ON o.plateNumber = dr.plateNumber " +
                        "JOIN " +
                            "Staff s ON dr.staffId = s.staffId " +
                        "ORDER BY " +
                            "CONCAT(s.fName, ' ', s.lName) ASC"; // Ordering by driver name in ascending order
                
            // Create prepared statement
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Execute query
            resultSet = statement.executeQuery();

            // Show JOptionPane to indicate successful filtering
            JOptionPane.showMessageDialog(null, "Filtering done successfully", "Report Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
    
    
    public ResultSet viewReportsOrderedByDriverID() {
        ResultSet resultSet = null;

        try {
            // Construct the SQL query to select reports and order by driver ID in ascending order
            String sql = "SELECT " +
                            "r.routeId, " +
                            "CONCAT(r.sourceStreet, ', ', r.sourceCommunity, ', ', r.sourceParish) AS 'Source Address', " +
                            "CONCAT(r.destinationStreet, ', ', r.destinationCommunity, ', ', r.destinationParish) AS 'Destination Address', " +
                            "r.rate AS 'Rate', " +
                            "dr.staffId AS 'StaffID', " +
                            "CONCAT(s.fName, ' ', s.lName) AS 'DriverName', " +
                            "o.dateOfOrder AS 'DateOfTrip' " +
                        "FROM " +
                            "RouteRate r " +
                        "JOIN " +
                            "Orders o ON r.routeId = o.routeId " +
                        "JOIN " +
                            "Driver dr ON o.plateNumber = dr.plateNumber " +
                        "JOIN " +
                            "Staff s ON dr.staffId = s.staffId " +
                        "ORDER BY " +
                            "dr.staffId ASC"; // Ordering by driver ID in ascending order
                
            // Create prepared statement
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Execute query
            resultSet = statement.executeQuery();

            // Show JOptionPane to indicate successful filtering
            JOptionPane.showMessageDialog(null, "Filtering done successfully", "Report Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    
}
