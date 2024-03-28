package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaySlipDatabaseAction {
    private Connection myConn = null;

    public PaySlipDatabaseAction() {
        myConn = DataBase.getDatabaseConnection();
    }

    public ResultSet getPaySlipDetails() {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM Salary";

            PreparedStatement statement = myConn.prepareStatement(sql);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet getPaySlipDetailsByStaffID(String staffID) {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM Salary WHERE staffId = ?";

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, staffID);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet getPaySlipDetailsByDateRange(String startDate, String endDate) {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM Salary WHERE startDate >= ? AND endDate <= ?";

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
