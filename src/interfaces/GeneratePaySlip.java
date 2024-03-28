package interfaces;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseAction.GeneratePaySlipDatabaseAction;

public class GeneratePaySlip {
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel, paySlipIdLabel, staffIdLabel, staffNameLabel, startDateLabel, endDateLabel, salaryLabel, billedByLabel;
    private GeneratePaySlipDatabaseAction paySlipAction;

    public GeneratePaySlip() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        titleLabel = new JLabel("Pay Slip");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(titleLabel, gbc);

        paySlipIdLabel = new JLabel("PayID: ");
        staffIdLabel = new JLabel("StaffID: ");
        staffNameLabel = new JLabel("Staff Name: ");
        startDateLabel = new JLabel("Start Date: ");
        endDateLabel = new JLabel("End Date: ");
        salaryLabel = new JLabel("Salary: ");
        billedByLabel = new JLabel("Billed by: ");

        gbc.anchor = GridBagConstraints.NORTHWEST; // Aligns the labels to the left
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(paySlipIdLabel, gbc);

        gbc.gridy = 2;
        panel.add(staffIdLabel, gbc);

        gbc.gridy = 3;
        panel.add(staffNameLabel, gbc);

        gbc.gridy = 4;
        panel.add(startDateLabel, gbc);

        gbc.gridy = 5;
        panel.add(endDateLabel, gbc);

        gbc.gridy = 6;
        panel.add(salaryLabel, gbc);

        gbc.gridy = 7;
        panel.add(billedByLabel, gbc);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setPreferredSize(new Dimension(450, 400));
        frame.add(panel, gbc);
        frame.setSize(520, 450);
        frame.setVisible(false);
    }

    public void getRecords(String staffID,String paySlipID) {
        frame.setVisible(true);
        paySlipAction = new GeneratePaySlipDatabaseAction();
        ResultSet resultSet = paySlipAction.getPaySlipDetails(staffID,paySlipID);

        try {
            while (resultSet.next()) {
                String paySlipId = resultSet.getString("payId");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                String salary = resultSet.getString("salary");
                String staffName = resultSet.getString("staffName");
                String billedBy = resultSet.getString("BilledBy");

                paySlipIdLabel.setText("PayID: " + paySlipId);
                staffIdLabel.setText("StaffID: " + staffID);
                staffNameLabel.setText("Staff Name: " + staffName);
                startDateLabel.setText("Start Date: " + startDate);
                endDateLabel.setText("End Date: " + endDate);
                salaryLabel.setText("Salary: " + salary);
                billedByLabel.setText("Billed by: " + billedBy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}