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

    public ResultSet getPaySlipDetails(String staffID, String payID) {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT s.payId, s.staffId, CONCAT(st.fName, ' ', st.lName) AS staffName, s.startDate, s.endDate, s.salary, CONCAT(ad.fName, ' ', ad.lName, ', ', a.adminId) AS billedBy " +
                         "FROM Salary s " +
                         "JOIN Staff st ON s.staffId = st.staffId " +
                         "JOIN Admin a ON s.adminId = a.adminId " +
                         "JOIN Staff ad ON a.staffId = ad.staffId " +
                         "WHERE s.staffId = ? AND s.payId = ?"; 

            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1, staffID);
            statement.setString(2, payID);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

}
