
package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import personalInfo.OutstandingBalance;

public class ViewOutstandingBalanceDatabaseAction {
    private Connection myConn = null;

    public ViewOutstandingBalanceDatabaseAction() {
        myConn = DataBase.getDatabaseConnection();
    }

    public void updateCustomerStatus() {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE Customer c " +
                         "INNER JOIN ( " +
                         "    SELECT c.customerId, " +
                         "           SUM(t.payment) AS total_payment, " +
                         "           MAX(rr.rate) AS max_rate " +
                         "    FROM Customer c " +
                         "    INNER JOIN Orders o ON c.customerId = o.customerId " +
                         "    INNER JOIN Transaction t ON o.invoiceNo = t.orderInvoiceNo " +
                         "    INNER JOIN RouteRate rr ON o.routeId = rr.routeId " +
                         "    WHERE o.dateOfOrder < t.transactionDate " +
                         "    GROUP BY c.customerId " +
                         "    HAVING DATEDIFF(MAX(t.transactionDate), MAX(o.dateOfOrder)) > 30 " +
                         "       AND SUM(t.payment) < MAX(rr.rate) " +
                         ") AS inactive_customers ON c.customerId = inactive_customers.customerId " +
                         "SET c.status = 'inactive'";
            statement = myConn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<OutstandingBalance> getOutstandingBalances() {
        // Update the customer status before fetching the data
        updateCustomerStatus();

        List<OutstandingBalance> outstandingBalances = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT c.customerId, CONCAT(c.fName, ' ', c.lName) AS CustomerName, total_payment AS TotalPayment, max_rate AS Rate, CASE WHEN total_payment >= max_rate THEN 'Active' ELSE 'Inactive' END AS Status " +
                         "FROM Customer c " +
                         "JOIN ( " +
                         "    SELECT c.customerId, " +
                         "           SUM(t.payment) AS total_payment, " +
                         "           MAX(rr.rate) AS max_rate " +
                         "    FROM Customer c " +
                         "    INNER JOIN Orders o ON c.customerId = o.customerId " +
                         "    INNER JOIN Transaction t ON o.invoiceNo = t.orderInvoiceNo " +
                         "    INNER JOIN RouteRate rr ON o.routeId = rr.routeId " +
                         "    WHERE o.dateOfOrder < t.transactionDate " +
                         "    GROUP BY c.customerId " +
                         "    HAVING DATEDIFF(MAX(t.transactionDate), MAX(o.dateOfOrder)) > 30 " +
                         "       AND SUM(t.payment) < MAX(rr.rate) " +
                         ") AS inactive_customers ON c.customerId = inactive_customers.customerId";
            statement = myConn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String customerId = resultSet.getString("customerId");
                String customerName = resultSet.getString("CustomerName");
                double totalPayment = resultSet.getDouble("TotalPayment");
                double rate = resultSet.getDouble("Rate");
                String status = resultSet.getString("Status");
                OutstandingBalance balance = new OutstandingBalance(customerId, customerName, totalPayment, rate, status);
                outstandingBalances.add(balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outstandingBalances;
    }
}