package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneratePaySlipDatabaseAction {
    private Connection myConn = null;

    public GeneratePaySlipDatabaseAction() {
        myConn = DataBase.getDatabaseConnection();
    }

    public ResultSet getPaySlipDetails(String staffID) {
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
}
