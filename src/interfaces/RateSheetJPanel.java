package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import databaseAction.RateSheetDatabaseAction;

public class RateSheetJPanel {
	
	
	private JLabel headingLabel;
	private JTable table;
	private JPanel panel;
	private GridBagConstraints gbc;
	private  DefaultTableModel model;
	private databaseAction.RateSheetDatabaseAction rateSheetAction;
	
	public RateSheetJPanel() {
		
		panel= new JPanel();
		panel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		headingLabel= new JLabel("Rate Sheet");
		Font font =  headingLabel.getFont();
		headingLabel.setFont(new Font(font.getFontName(), font.getStyle(), 30));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(headingLabel,gbc);
		
		gbc.gridy=1;
		String[] columnName= {"RouteID","Rate","Source Address","Destination Address"};	
		model = new DefaultTableModel(columnName,0);
		
		table = new JTable();
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);		
		scrollPane.setPreferredSize(new Dimension(980,450));
		panel.add(scrollPane,gbc);
		panel.setPreferredSize(new Dimension(1000, 600));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		rateSheetAction = new RateSheetDatabaseAction();
		ResultSet resultSet = rateSheetAction.getRouteInfo();
		addRecords(resultSet);
		TableColumn column;
		
	      for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            if (i == 2) {
	                column.setPreferredWidth(350); // Source Address column width
	            } else if (i == 3) {
	                column.setPreferredWidth(350); // Destination Address column width
	            } else {
	            	column.setPreferredWidth(50);
	            }
	        }
	}
	
	public void addRecords(ResultSet resultSet) {
        try {
			if (!resultSet.next()) {
			    JOptionPane.showMessageDialog(null, "No Records Found", "RateSheet Status", JOptionPane.INFORMATION_MESSAGE);
			} else {
			    try {
			        do {
			            // Retrieve data from ResultSet using aliases
			            String routeID = resultSet.getString("routeId");
			            String rate = resultSet.getString("Rate");
			            String source = resultSet.getString("SourceAddress"); // Using alias
			            String destination = resultSet.getString("DestinationAddress"); // Using alias
			            
			            // Add record to the table
			            model.addRow(new Object[]{routeID,rate, source, destination});
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
	
	public JPanel getPanel() {
		return panel;
	}

}
