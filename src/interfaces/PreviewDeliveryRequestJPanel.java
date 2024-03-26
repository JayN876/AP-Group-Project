package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;

public class PreviewDeliveryRequestJPanel {

	private GridBagConstraints gbc;
	private JPanel panel;
	private JLabel headingJLabel;
	private JLabel lblInvoiceDueOn;
	private JLabel lblCompnayName;
	private JLabel lblBilledByCompany;
	private JLabel lblCompanyAddress1;
	private JLabel lblBilledByFirstName;
	private JLabel lblCompanyCity;
	private JLabel lblBilledByLastName;
	private JLabel lblCompanyCountry;
	private JLabel lblBilledOn;
	private JLabel lblInvoiceNumber;
	
	private String invoiceDueOn;
	private String compnayName;
	private String billedByCompany;
	private String companyAddress1;
	private String billedByFirstName;
	private String companyCity;
	private String billedByLastName;
	private String companyCountry;
	private String billedOn;
	private String invoiceNumber;
	

	public PreviewDeliveryRequestJPanel() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new GridBagLayout());
		panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 1.0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0 };
		panel.setLayout(gbl_panel);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 0);

		// Labels
		headingJLabel = new JLabel("Rates Sheet");
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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblBilledTo = new JLabel("BILLED TO:");
		GridBagConstraints gbc_lblBilledTo = new GridBagConstraints();
		gbc_lblBilledTo.gridwidth = 3;
		gbc_lblBilledTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledTo.anchor = GridBagConstraints.LINE_START;
		gbc_lblBilledTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledTo.gridx = 0;
		gbc_lblBilledTo.gridy = 0;
		panel_1.add(lblBilledTo, gbc_lblBilledTo);

		JLabel lblBilledBy = new JLabel("BILLED BY:");
		GridBagConstraints gbc_lblBilledBy = new GridBagConstraints();
		gbc_lblBilledBy.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledBy.anchor = GridBagConstraints.LINE_START;
		gbc_lblBilledBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledBy.gridx = 21;
		gbc_lblBilledBy.gridy = 0;
		panel_1.add(lblBilledBy, gbc_lblBilledBy);

		lblCompnayName = new JLabel(this.getCompnayName());
		GridBagConstraints gbc_lblCompnayName = new GridBagConstraints();
		gbc_lblCompnayName.gridwidth = 3;
		gbc_lblCompnayName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCompnayName.anchor = GridBagConstraints.LINE_START;
		gbc_lblCompnayName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompnayName.gridx = 0;
		gbc_lblCompnayName.gridy = 2;
		panel_1.add(lblCompnayName, gbc_lblCompnayName);

		lblBilledByCompany = new JLabel("JHT Company");
		GridBagConstraints gbc_lblBilledByCompany = new GridBagConstraints();
		gbc_lblBilledByCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledByCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledByCompany.gridx = 21;
		gbc_lblBilledByCompany.gridy = 2;
		panel_1.add(lblBilledByCompany, gbc_lblBilledByCompany);

		lblCompanyAddress1 = new JLabel(this.getCompanyAddress1());
		GridBagConstraints gbc_lblCompanyAddress1 = new GridBagConstraints();
		gbc_lblCompanyAddress1.gridwidth = 4;
		gbc_lblCompanyAddress1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCompanyAddress1.anchor = GridBagConstraints.LINE_START;
		gbc_lblCompanyAddress1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompanyAddress1.gridx = 0;
		gbc_lblCompanyAddress1.gridy = 3;
		panel_1.add(lblCompanyAddress1, gbc_lblCompanyAddress1);

		lblBilledByFirstName = new JLabel(this.getBilledByFirstName());
		GridBagConstraints gbc_lblBilledByFirstName = new GridBagConstraints();
		gbc_lblBilledByFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledByFirstName.anchor = GridBagConstraints.LINE_START;
		gbc_lblBilledByFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledByFirstName.gridx = 21;
		gbc_lblBilledByFirstName.gridy = 3;
		panel_1.add(lblBilledByFirstName, gbc_lblBilledByFirstName);

		lblCompanyCity = new JLabel(this.getCompanyCity());
		GridBagConstraints gbc_lblCompanyCity = new GridBagConstraints();
		gbc_lblCompanyCity.gridwidth = 4;
		gbc_lblCompanyCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCompanyCity.anchor = GridBagConstraints.LINE_START;
		gbc_lblCompanyCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompanyCity.gridx = 0;
		gbc_lblCompanyCity.gridy = 4;
		panel_1.add(lblCompanyCity, gbc_lblCompanyCity);

		lblBilledByLastName = new JLabel(this.getBilledByLastName());
		GridBagConstraints gbc_lblBilledByLastName = new GridBagConstraints();
		gbc_lblBilledByLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledByLastName.anchor = GridBagConstraints.LINE_START;
		gbc_lblBilledByLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledByLastName.gridx = 21;
		gbc_lblBilledByLastName.gridy = 4;
		panel_1.add(lblBilledByLastName, gbc_lblBilledByLastName);

		lblCompanyCountry = new JLabel(this.getCompanyCountry());
		GridBagConstraints gbc_lblCompanyCountry = new GridBagConstraints();
		gbc_lblCompanyCountry.gridwidth = 3;
		gbc_lblCompanyCountry.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCompanyCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompanyCountry.anchor = GridBagConstraints.LINE_START;
		gbc_lblCompanyCountry.gridx = 0;
		gbc_lblCompanyCountry.gridy = 5;
		panel_1.add(lblCompanyCountry, gbc_lblCompanyCountry);

		JLabel lblDateOnLabel = new JLabel("Billed On:");
		GridBagConstraints gbc_lblDateOnLabel = new GridBagConstraints();
		gbc_lblDateOnLabel.anchor = GridBagConstraints.LINE_START;
		gbc_lblDateOnLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOnLabel.gridx = 21;
		gbc_lblDateOnLabel.gridy = 5;
		panel_1.add(lblDateOnLabel, gbc_lblDateOnLabel);

		lblBilledOn = new JLabel(this.getBilledOn());
		GridBagConstraints gbc_lblBilledOn = new GridBagConstraints();
		gbc_lblBilledOn.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBilledOn.anchor = GridBagConstraints.LINE_START;
		gbc_lblBilledOn.insets = new Insets(0, 0, 5, 5);
		gbc_lblBilledOn.gridx = 21;
		gbc_lblBilledOn.gridy = 6;
		panel_1.add(lblBilledOn, gbc_lblBilledOn);

		JLabel lblInvoiceNumberLabel = new JLabel("INVOICE #:");
		GridBagConstraints gbc_lblInvoiceNumberLabel = new GridBagConstraints();
		gbc_lblInvoiceNumberLabel.gridwidth = 4;
		gbc_lblInvoiceNumberLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInvoiceNumberLabel.anchor = GridBagConstraints.LINE_START;
		gbc_lblInvoiceNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvoiceNumberLabel.gridx = 0;
		gbc_lblInvoiceNumberLabel.gridy = 7;
		panel_1.add(lblInvoiceNumberLabel, gbc_lblInvoiceNumberLabel);

		JLabel lblInvoiceDueDateLabel = new JLabel("Payment Due On:");
		GridBagConstraints gbc_lblInvoiceDueDateLabel = new GridBagConstraints();
		gbc_lblInvoiceDueDateLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInvoiceDueDateLabel.anchor = GridBagConstraints.LINE_START;
		gbc_lblInvoiceDueDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvoiceDueDateLabel.gridx = 21;
		gbc_lblInvoiceDueDateLabel.gridy = 7;
		panel_1.add(lblInvoiceDueDateLabel, gbc_lblInvoiceDueDateLabel);

		lblInvoiceNumber = new JLabel(this.getInvoiceNumber());
		GridBagConstraints gbc_lblInvoiceNumber = new GridBagConstraints();
		gbc_lblInvoiceNumber.gridwidth = 3;
		gbc_lblInvoiceNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInvoiceNumber.anchor = GridBagConstraints.LINE_START;
		gbc_lblInvoiceNumber.insets = new Insets(0, 0, 0, 5);
		gbc_lblInvoiceNumber.gridx = 0;
		gbc_lblInvoiceNumber.gridy = 8;
		panel_1.add(lblInvoiceNumber, gbc_lblInvoiceNumber);

		lblInvoiceDueOn = new JLabel(this.getInvoiceDueOn());
		GridBagConstraints gbc_lblInvoiceDueOn = new GridBagConstraints();
		gbc_lblInvoiceDueOn.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInvoiceDueOn.anchor = GridBagConstraints.LINE_START;
		gbc_lblInvoiceDueOn.insets = new Insets(0, 0, 0, 5);
		gbc_lblInvoiceDueOn.gridx = 21;
		gbc_lblInvoiceDueOn.gridy = 8;
		panel_1.add(lblInvoiceDueOn, gbc_lblInvoiceDueOn);

		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getInvoiceDueOn() {
		return invoiceDueOn;
	}

	public void setInvoiceDueOn(String invoiceDueOn) {
		this.invoiceDueOn = invoiceDueOn;
	}

	public String getCompnayName() {
		return compnayName;
	}

	public void setCompnayName(String compnayName) {
		this.compnayName = compnayName;
	}

	public String getBilledByCompany() {
		return billedByCompany;
	}

	public void setBilledByCompany(String billedByCompany) {
		this.billedByCompany = billedByCompany;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getBilledByFirstName() {
		return billedByFirstName;
	}

	public void setBilledByFirstName(String billedByFirstName) {
		this.billedByFirstName = billedByFirstName;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getBilledByLastName() {
		return billedByLastName;
	}

	public void setBilledByLastName(String billedByLastName) {
		this.billedByLastName = billedByLastName;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getBilledOn() {
		return billedOn;
	}

	public void setBilledOn(String billedOn) {
		this.billedOn = billedOn;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public JPanel getPanel() {
		return panel;
	}

	public static void main(String[] args) {
		new PreviewDeliveryRequestJPanel();

	}

}
