package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class DashBoard {
	
	private static final Logger logger = LogManager.getLogger(DashBoard.class);
	private JLabel dashboardLabel;
	private JButton delivery;
	private JButton staffRecord;
	private JButton cusRecord;
	private JButton routeAndRate;
	private JButton viewOutstandingBalance;
	private JButton viewRateSheetButton;
	private JButton reportButton;
	private JButton invoiceButton;
	private JFrame dashBoardFrame;
	private JPanel sidebar;
	private JPanel mainPanel;
	private JPanel displayPanel;
	private GridBagConstraints gbc;
	private StaffJPanel staffJPanel;
	private RoutesAndRatesJPanel routesAndRatesJPanel;
	private ReportJPanel reportJPanel;
	private CustomerJPanel customerJPanel;
	private InvoiceJPanel invoiceJPanel;
	private RateSheetJPanel ratePanel;
	private ViewOutstandingBalanceJPanel balancePanel;
	private AddDeliveryRequestJPanel addDeliveryPanel;
	
	
	public DashBoard() {
		logger.info("Dashboard launched");
		dashBoardFrame = new JFrame ("JHT DashBoard");
		staffJPanel = new StaffJPanel();
		routesAndRatesJPanel = new RoutesAndRatesJPanel();
		gbc = new GridBagConstraints();
		mainPanel = new JPanel();	
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		mainPanel.setLayout(new GridBagLayout());		
		dashBoardFrame.setLayout(new GridBagLayout());
		sidebar = new JPanel();
		int buttonFont=16;
		int buttonWidth =250, buttonHeight=50;
		
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Get the screen width and height
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
			
		//Dashboard heading 
		dashboardLabel = new JLabel("DASHBOARD");
		Font font =  dashboardLabel.getFont();
		dashboardLabel.setForeground(Color.WHITE);
		dashboardLabel.setFont(new Font(font.getFontName(), font.getStyle(), 30));
		sidebar.add(dashboardLabel);
		
		//setting delivery Button
		delivery = new JButton("Add Delivery Request");
		delivery.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));	
		delivery.setPreferredSize(new Dimension(buttonWidth,buttonHeight)); 
		sidebar.add(delivery);
		
		delivery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDeliveryPanel = new AddDeliveryRequestJPanel();
				mainPanel.remove(displayPanel);
				displayPanel = addDeliveryPanel.getPanel();
				mainPanel.add(displayPanel, gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
			}
		});
		
		//setting Staff Record
		staffRecord = new JButton("Add Staff Record");
		staffRecord.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		staffRecord.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		
		staffRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(displayPanel);
				displayPanel = staffJPanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				logger.info("Click Option to add Staff Record");
				
			}
		});
		sidebar.add(staffRecord);
		
		
		//setting Customer Record button
		cusRecord = new JButton("Add Customer Record");
		cusRecord.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		cusRecord.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		cusRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Click Option to add Customer Record");
				customerJPanel = new CustomerJPanel();
				mainPanel.remove(displayPanel);
				displayPanel = customerJPanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
				
			}
		});
		sidebar.add(cusRecord);
		
		//setting routeAndRate
		routeAndRate = new JButton("Add Routes And Rate");
		routeAndRate.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		routeAndRate.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		routeAndRate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Click Option to add Route Rate");
				mainPanel.remove(displayPanel);
				displayPanel = routesAndRatesJPanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
			}
		});
		sidebar.add(routeAndRate);
		
		//Setting viewOutstandingBalance
		viewOutstandingBalance = new JButton("View Outstanding Balances");
		viewOutstandingBalance.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		viewOutstandingBalance.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		
		viewOutstandingBalance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Click Option to View Outstanding Balances");
				balancePanel = new ViewOutstandingBalanceJPanel();
				
				mainPanel.remove(displayPanel);
				displayPanel = balancePanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
			}
		});
		sidebar.add(viewOutstandingBalance);
		
		//Rate sheet button
		viewRateSheetButton = new JButton("View Rate Sheet");
		viewRateSheetButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		viewRateSheetButton.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		viewRateSheetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				logger.info("Click Option to View Rate Sheet");
				ratePanel = new RateSheetJPanel();
				
				mainPanel.remove(displayPanel);
				displayPanel = ratePanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
				
			}
		});
		sidebar.add(viewRateSheetButton);
		
		//View Report Button
		reportButton = new JButton("View Report");
		reportButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		reportButton.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		reportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				logger.info("Click Option to View Report");
				reportJPanel= new ReportJPanel();
				mainPanel.remove(displayPanel);
				displayPanel = reportJPanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
			}
		});
		
		sidebar.add(reportButton);
		
		
		//View Invoice Button
		invoiceButton = new JButton("View Invoice");
		invoiceButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		invoiceButton.setFont(new Font(font.getFontName(), font.getStyle(), buttonFont));
		invoiceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Click Option to View Invoice");
				invoiceJPanel = new InvoiceJPanel();
				mainPanel.remove(displayPanel);
				displayPanel = invoiceJPanel.getPanel();
				mainPanel.add(displayPanel,gbc);
				mainPanel.revalidate();
				mainPanel.repaint();
				
			}
		});
		sidebar.add(invoiceButton);
		
		// Side Panel
		sidebar.setPreferredSize(new Dimension(250, 600)); // Set the preferred size
		sidebar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sidebar.setBackground(Color.BLACK);				
		mainPanel.add(sidebar);
		
		JLabel defaultLabel = new JLabel("<html>Please<br> Select<br> an<br> Action</html>");
		font = defaultLabel.getFont();
		defaultLabel.setFont(new Font(font.getName(), font.getStyle(), 60));	
		

		displayPanel.add(defaultLabel);
		
		displayPanel.setBackground(Color.white);
		displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		displayPanel.setPreferredSize(new DimensionUIResource(700, 600)); // Set size to 700x600
		
		
		mainPanel.add(displayPanel);
		dashBoardFrame.add(mainPanel);
		
		dashBoardFrame.setLocation(100,0);
		dashBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashBoardFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dashBoardFrame.setVisible(true);
		dashBoardFrame.setResizable(true);
		dashBoardFrame.setSize(1366, 768);
		
	}
	
	public static void main(String[] args) {
		new DashBoard();
	}
}
