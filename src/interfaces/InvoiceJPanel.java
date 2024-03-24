package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import databaseAction.InvoiceDatabaseAction;

public class InvoiceJPanel {
	
    private JPanel panel;

    private JLabel headingLabel;
    private GridBagConstraints gbc;
    private DefaultTableModel model;
    private databaseAction.InvoiceDatabaseAction invoiceAction;
    private JButton viewInvoiceButton;
    public GenerateInvoice generateInvoice;
    
    public InvoiceJPanel() {
		
    	panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    	invoiceAction = new InvoiceDatabaseAction();
    	
    	
        gbc = new GridBagConstraints();
        headingLabel = new JLabel("Invoice");
        gbc.gridx=0;
        gbc.gridy=0;
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(headingLabel,gbc);
    	
        gbc = new GridBagConstraints();
        headingLabel = new JLabel("Customer ID : ");
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.SOUTHWEST;
        gbc.insets = new Insets(0, 50, 0, 0);
        panel.add(headingLabel,gbc);
        
        gbc = new GridBagConstraints();
        JTextField cusAreaField = new JTextField();
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.SOUTHWEST;
        cusAreaField.setColumns(10);       
        panel.add(cusAreaField,gbc);       
        
        JButton cusGoButton = new JButton("Go");
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.SOUTHWEST;      
        
        cusGoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String customerID = cusAreaField.getText();
				
				if(customerID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Customer ID.", "Customer Invoice Status", JOptionPane.ERROR_MESSAGE);
				}
				else {
					model.setRowCount(0);
					addRecords(invoiceAction.getInvoiceDetailsByCustomerID(customerID));
				}
				
			}
		});
        panel.add(cusGoButton,gbc);	
        
        
        JButton viewAllButton = new JButton("View All");
        gbc.gridx=4;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.SOUTHWEST;
    	gbc.insets = new Insets(0, 20, 0, 0);
        viewAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				addRecords(invoiceAction.getInvoiceDetails());
			}
		});
        
        panel.add(viewAllButton,gbc);
        
        String[] columnNames = {"Invoice No", "Source Address", "Destination Address", "CustomerID","Rate","View Invoice"};

        // Create an empty table model with column names
        model = new DefaultTableModel(columnNames, 0); // 0 rows initially
        
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        
        // Add button renderer and editor to the "View Invoice" column
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        ButtonEditor buttonEditor = new ButtonEditor(new JTextField());
        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);
        table.getColumnModel().getColumn(5).setCellEditor(buttonEditor);
        
		TableColumn column;
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20); // Invoice no column width
            } else if (i == 1) {
                column.setPreferredWidth(230); // Source Address column width
            } else if (i == 2) {
                column.setPreferredWidth(230); // Destination Address column width
            } else {
            	column.setPreferredWidth(30);
            }
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(980, 400));
    	gbc = new GridBagConstraints();
    	gbc.gridx=0;
    	gbc.gridy=1;
    	gbc.gridwidth=5;
        panel.add(scrollPane,gbc);
        
        // Create a button for "View Invoice"
        viewInvoiceButton = new JButton("View Invoice");
        viewInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when "View Invoice" button is clicked
                JOptionPane.showMessageDialog(null, "View Invoice clicked for invoice number: " );
            }
        });
        
        addRecords(invoiceAction.getInvoiceDetails());
    	
        
        
     	
    	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));   	
    	panel.setPreferredSize(new Dimension(1000,600));    
    	
	}

    public JPanel getPanel() {
		return panel;
	}
    
    
    public void addRecords(ResultSet resultSet) {
        try {
            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(null, "No Records Found", "Order Records Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    do {
                        // Retrieve data from ResultSet using aliases
                        String invoiceNo = resultSet.getString("invoiceNo");
                        String sourceAdd = resultSet.getString("Source Address"); // Using alias
                        String destinationAdd = resultSet.getString("Destination Address"); // Using alias
                        String company = resultSet.getString("Company");
                        String customerId = resultSet.getString("customerId");
                        String rate = resultSet.getString("rate");
                        
                        
                        // Add record to the table along with the button
                        model.addRow(new Object[]{invoiceNo, sourceAdd, destinationAdd, customerId, rate});
                    } while (resultSet.next());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Renderer for the button in the JTable cell
    class ButtonRenderer extends JButton implements TableCellRenderer {
        
        // Constructor for the ButtonRenderer class
        public ButtonRenderer() {
            setOpaque(true);
        }
        
        // Method to render the button component in the JTable cell
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Set the button text to the value if it's not null, otherwise set it to "View Invoice"
            if (value != null) {
                setText(value.toString());
            } else {
                setText("View Invoice");
            }
            return this; // Return the rendered button component
        }
    }

    // Editor for the button in the JTable cell
    class ButtonEditor extends DefaultCellEditor {
        
        // Member variables
        JButton button; // Button component
        private String label = "View Invoice"; // Default label for the button
        private boolean isPushed; // Flag to track button clicks
        String customerID; // Customer ID associated with the button
        String invoiceNo;
        // Constructor for the ButtonEditor class
        public ButtonEditor(JTextField textField) {
            super(textField); // Call the superclass constructor
            button = new JButton(); // Initialize the button component
            button.setOpaque(true); // Set button opacity to true
            // Add action listener to the button
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped(); // Fire editing stopped event when button is clicked
                    
                }
            });
        }

        // Method to get the editor component for the JTable cell
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                // Set button foreground and background colors based on selection
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                // Set button foreground color to default foreground color and background color to default button background color
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            
            // Get the customer ID associated with the button from the table model
            customerID = (String) table.getModel().getValueAt(row, 3); 
            invoiceNo= (String) table.getModel().getValueAt(row, 0);
            button.setText(label); // Set the button text
            isPushed = true; // Set button pushed flag to true
            return button; // Return the editor component
        }

        // Method to get the cell editor value
        public Object getCellEditorValue() {
            if (isPushed) {
                // Perform action when button is clicked
                // Show the customer ID in a JOptionPane
            	generateInvoice = new GenerateInvoice();
            	generateInvoice.getRecords(customerID,invoiceNo);
            }
            isPushed = false; // Reset the button pushed flag
            return label; // Return the cell editor value
        }

        // Method to stop cell editing
        public boolean stopCellEditing() {
            isPushed = false; // Reset the button pushed flag
            return super.stopCellEditing(); // Call the superclass method to stop cell editing
        }

        // Method to fire editing stopped event
        protected void fireEditingStopped() {
            super.fireEditingStopped(); // Call the superclass method to fire editing stopped event
        }
    }


    
    public static void main(String[] args) {
		new InvoiceJPanel();
	}
    
    
}
