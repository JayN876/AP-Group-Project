package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.management.modelmbean.ModelMBean;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import databaseAction.GenerateInvoiceDatabaseAction;

public class GenerateInvoice {
	
    private JLabel receiptLabel;
    private JLabel sourceLabel;
    private JLabel destinationLabel;
    private JLabel cusIDLabel;
    private JLabel cusNameLabel;
    private JLabel orderIDLabel;
    private JLabel billedbyLabel;
    private JLabel rateLabel;
    private JLabel totalLabel;
    private JLabel outstandingLabel;
    
    private JFrame frame;
    private GridBagConstraints gbc;
    private JPanel panel;
    private databaseAction.GenerateInvoiceDatabaseAction generateInvoiceAction;
    private  DefaultTableModel model;
    private double totalPayment=0;
    
    public GenerateInvoice() {
    	
    	frame = new JFrame();
    	panel =  new JPanel();
    	panel.setLayout(new GridBagLayout());
    	frame.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints(); 
    	
    	
    	receiptLabel = new JLabel("Invoice");
    	Font labelFont = receiptLabel.getFont();
    	receiptLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 30)); // Set font size to 30 and make it bold
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.gridwidth = 5;
    	gbc.anchor = GridBagConstraints.NORTHWEST;
    	gbc.insets = new Insets(-50, 0, 10, 0);
    	panel.add(receiptLabel, gbc);

    	
    	gbc.insets = new Insets(0, 0, 0, 0);
    	sourceLabel =new JLabel("Source : ");
    	gbc.gridx=0;
    	gbc.gridy=1;
    	gbc.gridwidth=5;
    	gbc.anchor = GridBagConstraints.NORTHWEST;
    	panel.add(sourceLabel,gbc);
    	
    	destinationLabel =new JLabel("Destination : ");
    	gbc.gridx=0;
    	gbc.gridy=2;
    	panel.add(destinationLabel,gbc);
    	
    	cusIDLabel =new JLabel("Customer ID: ");
    	gbc.gridx=0;
    	gbc.gridy=3;
    	panel.add(cusIDLabel,gbc);
    	
    	cusNameLabel =new JLabel("Customer Name : ");
    	gbc.gridx=0;
    	gbc.gridy=4;
    	panel.add(cusNameLabel,gbc);
    	
    	
    	orderIDLabel =new JLabel("Order ID : ");
    	gbc.gridx=0;
    	gbc.gridy=5;
    	panel.add(orderIDLabel,gbc);
    	
    	billedbyLabel =new JLabel("Billed by : ");
    	gbc.gridx=0;
    	gbc.gridy=6;
    	panel.add(billedbyLabel,gbc);
    	
    	receiptLabel =new JLabel("<html>__________________________________________________________<br><br></html>");
    	gbc.gridx=0;
    	gbc.gridy=7;
    	gbc.gridwidth=5;
    	panel.add(receiptLabel,gbc);
    	
    	
    	gbc= new GridBagConstraints();
    	gbc.gridx=0;
    	gbc.gridy=8;
    	gbc.gridwidth=4;
    	
    	String[] columnNames= {"Transaction No", "Date","Payment"};
        model = new DefaultTableModel( columnNames,0);
        
        // Create a JTable with the DefaultTableModel
        JTable table = new JTable(model);
    	
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        panel.add(scrollPane,gbc);
        
        gbc= new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
    	totalLabel =new JLabel("Total Payment : ");
    	gbc.gridx=0;
    	gbc.gridy=9;
    	panel.add(totalLabel,gbc);
    	

    	rateLabel =new JLabel("Rate : ");
    	gbc.gridx=0;
    	gbc.gridy++;
    	panel.add(rateLabel,gbc);
    	
    	outstandingLabel =new JLabel("Outstanding Balance : ");
    	gbc.gridx=0;
    	gbc.gridy++;
    	panel.add(outstandingLabel,gbc);
    	
    	

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.setPreferredSize(new Dimension(450, 400));
    	frame.add(panel,gbc);
    	frame.setSize(520, 450);
    	frame.setVisible(false);//prevent window from displaying when being initialized
        
    }
    
	public GenerateInvoice getRecords(String cusID,String InvoiceNo) {
		frame.setVisible(true);//display window when records are being retrieved
	    generateInvoiceAction = new GenerateInvoiceDatabaseAction();
	    ResultSet resultSet = null;
	    try {
	        resultSet = generateInvoiceAction.getInvoiceDetails(cusID);
	
	        if (!resultSet.next()) {
	            JOptionPane.showMessageDialog(null, "No Records Found", "Invoice Records Status", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	    	String rate;
	        try {
	            do {
	                // Retrieve data from ResultSet using aliases
	                String sourceAdd = resultSet.getString("SourceAddress"); // Using alias
	                String destinationAdd = resultSet.getString("DestinationAddress"); // Using alias
	                String customerId = resultSet.getString("CustomerId");
	                String customerName = resultSet.getString("CustomerName");
	                String orderID = resultSet.getString("OrderID");
	                String billedBy = resultSet.getString("BilledBy");
	                rate = resultSet.getString("Rate");
	                sourceLabel.setText("Source Address : " + sourceAdd);
	                destinationLabel.setText("Destination Address : "+ destinationAdd);
	                cusIDLabel.setText("Customer ID : "+customerId);
	                cusNameLabel.setText("Customer Name : " +customerName);
	                orderIDLabel.setText("Order ID : "+orderID);
	                billedbyLabel.setText("Billed by : "+ billedBy);
	                rateLabel.setText("Rate : $"+rate);
	                
	            } while (resultSet.next());
	            
	            addTransactionDetails(InvoiceNo,rate);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		return null;
	}
	
	public void addTransactionDetails(String InvoiceNo,String rate) {
		try {
			ResultSet resultSet = null;
	        resultSet = generateInvoiceAction.getTransactionDetails(InvoiceNo);
	        
	        if (!resultSet.next()) {
	            JOptionPane.showMessageDialog(null, "No Records Found", "Transaction Status", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        try {
	            do {
	               
	            	// Retrieve data from ResultSet
		            String transactionNo = resultSet.getString("transactionNo");
		            String transactionDate = resultSet.getString("transactionDate");
		            String payment = resultSet.getString("payment");
		            totalPayment += Double.parseDouble(payment);
		            model.addRow(new Object[]{ transactionNo,transactionDate,payment});
	                
	            } while (resultSet.next());
	            
	           totalLabel.setText( "Total Payments: "+String.valueOf(totalPayment));
	           outstandingLabel.setText("Outstanding Balance : "+String.valueOf(Double.parseDouble(rate)-totalPayment));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		GenerateInvoice generateInvoice  = new GenerateInvoice();
		generateInvoice.getRecords("cus1", "INV001");
	}
    
}
