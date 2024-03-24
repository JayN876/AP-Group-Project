package interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import databaseAction.ViewOutstandingBalanceDatabaseAction;
import personalInfo.OutstandingBalance;

public class ViewOutstandingBalanceJPanel {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;

    public ViewOutstandingBalanceJPanel() {
        panel = new JPanel(new BorderLayout());
        initializePanel();
        populateTable();
    }

    private void populateTable() {
        tableModel.setRowCount(0);
        ViewOutstandingBalanceDatabaseAction database = new ViewOutstandingBalanceDatabaseAction();
        List<OutstandingBalance> outstandingBalances = database.getOutstandingBalances();

        if (outstandingBalances != null) {
            for (OutstandingBalance balance : outstandingBalances) {
                Object[] rowData = {
                        balance.getCustomerId(),
                        balance.getCustomerName(),
                        balance.getTotalPayment(),
                        balance.getRate(),
                        balance.getStatus()
                };
                tableModel.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Error fetching outstanding balances", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializePanel() {
        String[] columnNames = {"Customer ID", "Customer Name", "Total Payment", "Rate", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}