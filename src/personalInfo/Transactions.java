package personalInfo;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame {
    private JLabel transactionNoLabel, transactionDateLabel, customerIDLabel, orderInvoiceNoLabel, paymentLabel;
    private JTextField transactionNoField, transactionDateField, customerIDField, orderInvoiceNoField, paymentField;
    private JButton confirmButton, clearButton;

    public Transactions() {
        setTitle("Transactions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        transactionNoLabel = new JLabel("Transaction No:");
        transactionDateLabel = new JLabel("Transaction Date:");
        customerIDLabel = new JLabel("Customer ID:");
        orderInvoiceNoLabel = new JLabel("Order Invoice No:");
        paymentLabel = new JLabel("Payment:");

        transactionNoField = new JTextField();
        transactionDateField = new JTextField();
        customerIDField = new JTextField();
        orderInvoiceNoField = new JTextField();
        paymentField = new JTextField();

        panel.add(transactionNoLabel);
        panel.add(transactionNoField);
        panel.add(transactionDateLabel);
        panel.add(transactionDateField);
        panel.add(customerIDLabel);
        panel.add(customerIDField);
        panel.add(orderInvoiceNoLabel);
        panel.add(orderInvoiceNoField);
        panel.add(paymentLabel);
        panel.add(paymentField);

        confirmButton = new JButton("Confirm");
        clearButton = new JButton("Clear");

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when confirm button is clicked
                // You can add your logic here
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when clear button is clicked
                transactionNoField.setText("");
                transactionDateField.setText("");
                customerIDField.setText("");
                orderInvoiceNoField.setText("");
                paymentField.setText("");
            }
        });

        panel.add(confirmButton);
        panel.add(clearButton);

        JButton accessTransactionsButton = new JButton("Access Transactions");
        accessTransactionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
            }
        });
        panel.add(accessTransactionsButton);

        add(panel);
        setVisible(false); // Hide initially
    }

    public static void main(String[] args) {
        new Transactions();
    }
}
