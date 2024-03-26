package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import helpers.DateLabelFormatter;
import helpers.PropertyLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import beans.CompanyRepresentative;
import beans.DeliveryRoute;
import databaseAction.DeliveryRequestAction;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;
import java.util.Properties;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;


public class AddDeliveryRequestJPanel {
	private JPanel panel;
	private JLabel headingJLabel;
	private GridBagConstraints gbc;
	private JLabel lblDeliveryRoute;
	private JComboBox<CompanyRepresentative> cbxCustomer;
	private JLabel lblDestinationAddress;
	private JComboBox<DeliveryRoute> cbxDeliveryRoute;
	private JLabel lblCustomer;
	private JComboBox<?> cbxDestinationAddress;
	private JLabel lblPlateNumber;
	private JComboBox<?> cbxPlateNumber;
//	private JLabel lblNewLabel_4;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl dpOrderDate;
	private JPanel panel_2;
	private JButton btnCancelRequest;
	private JButton btnConfirmRequest;
	private JLabel lblOrderDate;
	private DeliveryRequestAction deliveryAction;
	
	
	private String selectedCustomerId;
	/**
	 * @wbp.parser.entryPoint
	 */
	public AddDeliveryRequestJPanel() {
	
		panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 1.0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0 };
		panel.setLayout(gbl_panel);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 0);

		// Labels
		headingJLabel = new JLabel("Delivery Request");
		Font font = headingJLabel.getFont();
		headingJLabel.setFont(new Font(font.getFontName(), font.getStyle(), 30));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = 2;
		panel.add(headingJLabel, gbc);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblCustomer, "2, 2");
		
		deliveryAction = new DeliveryRequestAction();
		List<CompanyRepresentative> repsList = deliveryAction.getAllCustomerCompanies();
		CompanyRepresentative[] reps = new CompanyRepresentative[repsList.size()];
		reps = repsList.toArray(reps);
		cbxCustomer = new JComboBox<CompanyRepresentative>(reps);

		panel_1.add(cbxCustomer, "6, 2, fill, default");
		
		lblDeliveryRoute = new JLabel("Delivery Route");
		lblDeliveryRoute.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblDeliveryRoute, "2, 4, right, default");
		
		List<DeliveryRoute> routesList = deliveryAction.getAllDeliveryRoutes();
		DeliveryRoute[] routes = new DeliveryRoute[routesList.size()];
		routes = routesList.toArray(routes);
		
		cbxDeliveryRoute = new JComboBox<DeliveryRoute>(routes);
		panel_1.add(cbxDeliveryRoute, "6, 4, fill, default");
		
//		lblDestinationAddress = new JLabel("Destination Address");
//		lblDestinationAddress.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_1.add(lblDestinationAddress, "2, 6, default, top");
//		
//		cbxDestinationAddress = new JComboBox();
//		panel_1.add(cbxDestinationAddress, "6, 6, fill, default");
		
		lblPlateNumber = new JLabel("Plate Number");
		lblPlateNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblPlateNumber, "2, 8");
		
		cbxPlateNumber = new JComboBox();
		panel_1.add(cbxPlateNumber, "6, 8, fill, default");
		
		lblOrderDate = new JLabel("Date of Order");
		lblOrderDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblOrderDate, "2, 10");
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		dpOrderDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel_1.add(dpOrderDate, "6, 10, fill, fill");
		
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, "6, 20, fill, fill");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnCancelRequest = new JButton("Cancel Request");
		GridBagConstraints gbc_btnCancelRequest = new GridBagConstraints();
		gbc_btnCancelRequest.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelRequest.gridx = 0;
		gbc_btnCancelRequest.gridy = 0;
		panel_2.add(btnCancelRequest, gbc_btnCancelRequest);
		
		btnConfirmRequest = new JButton("Confirm Request");
		
		btnConfirmRequest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CompanyRepresentative rep = (CompanyRepresentative) cbxCustomer.getSelectedItem();
				if(rep != null) {
					selectedCustomerId = rep.getCustomerId();
				}
				
				System.out.println(selectedCustomerId);
			}
		});
		GridBagConstraints gbc_btnConfirmRequest = new GridBagConstraints();
		gbc_btnConfirmRequest.gridx = 2;
		gbc_btnConfirmRequest.gridy = 0;
		panel_2.add(btnConfirmRequest, gbc_btnConfirmRequest);
		
	
	}

	public JPanel getPanel() {
		return panel;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
