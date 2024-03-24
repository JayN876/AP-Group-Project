package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import databaseAction.ReportDatabaseAction;

public class ReportJPanel {
    
    private JPanel panel;
    private JTable table;
    private JLabel timePeriod;
    private JLabel headingLabel;
    private JTextField startDayArea;
    private JTextField startYearArea;
    private JTextField startMonthArea;
    private JTextField endDayArea;
    private JTextField endMonthArea;
    private JTextField endYearArea;
    private JTextField cusAreaField;
    private JButton goButton;
    private JButton cusGoButton;
    private GridBagConstraints gbc;
    private ResultSet resultSet;
    private JLabel label;
    private databaseAction.ReportDatabaseAction reportAction;
    private DefaultTableModel model;
    
    
    public ReportJPanel() {
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        reportAction = new ReportDatabaseAction();
        
        headingLabel = new JLabel("Report");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Set font size to 30
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(headingLabel, gbc);
        
        
        label = new JLabel("<html>Filters:<br>_________________________________________________________________________________________________________________________________________</html>");
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=13;
        panel.add(label,gbc);
        
        gbc = new GridBagConstraints();  
        gbc.anchor = GridBagConstraints.NORTHWEST;
        label = new JLabel("Start Period (yy/mm/dd)  :  ");
        gbc.gridx=0;
        gbc.gridy=2;
        panel.add(label,gbc);
        
        gbc.gridx = 1;
        startYearArea= new JTextField();
        startYearArea.setColumns(3);
        panel.add(startYearArea,gbc);
        
        label = new JLabel(" / ");
        gbc.gridx=2;
        panel.add(label,gbc);
        
        gbc.gridx = 3;
        startMonthArea= new JTextField();
        startMonthArea.setColumns(2);
        panel.add(startMonthArea,gbc);
        
 
        label = new JLabel(" / ");
        gbc.gridx=4;
        panel.add(label,gbc);
        
        gbc.gridx = 5;
        startDayArea= new JTextField();
        startDayArea.setColumns(2);
        panel.add(startDayArea,gbc);
        
        gbc = new GridBagConstraints();  
        gbc.anchor = GridBagConstraints.NORTHWEST;
        label = new JLabel("End Period (yy/mm/dd)  :  ");
        gbc.gridx=6;
        gbc.gridy=2;
        gbc.insets = new Insets(0, 90, 0, 0);
        panel.add(label,gbc);
        
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 7;
        endYearArea= new JTextField();
        endYearArea.setColumns(3);
        panel.add(endYearArea,gbc);
        
        label = new JLabel(" / ");
        gbc.gridx=8;
        panel.add(label,gbc);
        
        gbc.gridx = 9;
        endMonthArea= new JTextField();
        endMonthArea.setColumns(2);
        panel.add(endMonthArea,gbc);
        
 
        label = new JLabel(" / ");
        gbc.gridx=10;
        panel.add(label,gbc);
        
        gbc.gridx = 11;
        endDayArea= new JTextField();
        endDayArea.setColumns(2);
        panel.add(endDayArea,gbc);
        
        JButton goButton = new JButton("Go");
        gbc.gridx=12;
        gbc.insets = new Insets(0, 10, 0, 0);
        
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if start date and end date fields are empty
                String startYear = startYearArea.getText();
                String startMonth = startMonthArea.getText();
                String startDay = startDayArea.getText();
                String endYear = endYearArea.getText();
                String endMonth = endMonthArea.getText();
                String endDay = endDayArea.getText();

                if (startYear.isEmpty() || startMonth.isEmpty() || startDay.isEmpty() ||
                    endYear.isEmpty() || endMonth.isEmpty() || endDay.isEmpty()) {
                    // Display JOptionPane with an error message if start date and end date  was not filled out
                    JOptionPane.showMessageDialog(null, "Please enter both start date and end date.", "Report Status", JOptionPane.ERROR_MESSAGE);
                } else {
                	model.setRowCount(0);
                    resultSet=reportAction.viewReportsByDateRange(startDay, startMonth, startYear, endDay, endMonth, endYear);
                	addRecords(resultSet);
                }
            }
        });

        panel.add(goButton,gbc);
        
        gbc.insets = new Insets(0, 0, 0, 0);
        JButton driverFilterButton = new JButton("Filter by Driver Name");
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        driverFilterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				addRecords(reportAction.viewReportsOrderedByDriverName());
				
				
			}
		});
        panel.add(driverFilterButton,gbc);
        
        JButton filterByDriverIDButton = new JButton("Filter by DriverID");
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.insets = new Insets(0, 10,0, 0);
        gbc.gridwidth=6;
        filterByDriverIDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				addRecords(reportAction.viewReportsOrderedByDriverID());
				
			}
		});
        
        panel.add(filterByDriverIDButton,gbc);
        
        JButton viewAllButton = new JButton("View All");
        gbc.gridx=6;
        gbc.gridy=3;

        gbc.insets = new Insets(0, 40,0, 0);
        
        viewAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				addRecords(reportAction.viewReports());
				
			}
		});
        panel.add(viewAllButton,gbc);
        
        gbc = new GridBagConstraints();        
        String[] columnNames = {"RouteID", "Source", "Destination", "Driver-ID", "DriverName", "Date of Trip","Rate"};     
        resultSet = reportAction.viewReports();
               
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=13;
      
        // Create table model
        model = new DefaultTableModel(columnNames,0);


        table = new JTable(model);
        
        // Set table model for the JTable
        table.setModel(model);
        
       
        addRecords(resultSet);
        TableColumn column;
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(13); // RouteID column width
            } else if (i == 1) {
                column.setPreferredWidth(230); // Source Address column width
            } else if (i == 2) {
                column.setPreferredWidth(230); // Destination Address column width
            } else {
            	column.setPreferredWidth(50);
            }
        }
        
        
        table.setFillsViewportHeight(true);
        // Create JScrollPane and add table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(980, 400));
        
        // Add scroll pane to panel
        panel.add(scrollPane,gbc);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        panel.setPreferredSize(new Dimension(1000, 600));
        
    }
    

    public JPanel getPanel() {
		return panel;
	}
    
    public void addRecords(ResultSet resultSet) {
    	
        try {
			if (!resultSet.next()) {
			    JOptionPane.showMessageDialog(null, "No Records Found", "Report Status", JOptionPane.INFORMATION_MESSAGE);
			} else {
			    try {
			        do {
			            // Retrieve data from ResultSet using aliases
			            String routeID = resultSet.getString("routeId");
			            String source = resultSet.getString("Source Address"); // Using alias
			            String destination = resultSet.getString("Destination Address"); // Using alias
			            String staffID = resultSet.getString("StaffID");
			            String driverName = resultSet.getString("DriverName");
			            String dateOfTrip = resultSet.getString("DateOfTrip");
			            String rate = resultSet.getString("Rate");
			            // Add record to the table
			            model.addRow(new Object[]{routeID, source, destination, staffID, driverName, dateOfTrip,rate});
			        } while (resultSet.next());
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
        new ReportJPanel();
    }
    
}
