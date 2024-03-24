package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databaseAction.AdminPasswordLogin;

public class AdminLogin extends JPanel{
	
	
	private static final Logger logger = LogManager.getLogger(AdminLogin.class);
	
	private JLabel staffIDJLabel;
	private JTextField staffIDJTextField;
	private JLabel pwdJLabel;
	private JTextField pwdJTextField;
	private JButton clearButton;
	private JButton confirmButton;
	private JFrame adminFrame;
	private JLabel formHeading;
	private GridBagConstraints gbc;
	private int attempt=3;
	
	
	public AdminLogin() {
		
		logger.info("Admin Login Launched");
		int positionTop=-120;
		
		adminFrame = new JFrame("JHT Login");
		adminFrame.setLayout(new GridBagLayout());
		
		//setting form heading
		gbc=new GridBagConstraints();
		formHeading = new JLabel("JAVA Haulage and Trucking (JHT) LOGIN");
		gbc.gridx = 0;
		gbc.gridy=0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridwidth =3;
		gbc.insets = new Insets(positionTop - 50, 0, 0, 0);
		
		// Increase font size of heading
        Font font = formHeading.getFont();
        formHeading.setFont(new Font(font.getFontName(), font.getStyle(), 20));
		adminFrame.add(formHeading,gbc);
		
		
		//setting staffID FLabel
		gbc= new GridBagConstraints();
		staffIDJLabel = new JLabel("Staff ID : ");
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets= new Insets(positionTop, 0, 0, 0);
		adminFrame.add(staffIDJLabel,gbc);
		
		//setting staffID Text field
		gbc = new GridBagConstraints();
		staffIDJTextField = new JTextField();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(positionTop, 12, 0, 0);
		staffIDJTextField.setColumns(18);
		adminFrame.add(staffIDJTextField,gbc);
		
		//setting Password Label
		gbc = new GridBagConstraints();
		pwdJLabel = new JLabel("Password : ");
		gbc.gridx = 0;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(positionTop+40, 0, 0, 0);
		adminFrame.add(pwdJLabel,gbc);
		
		//setting pwd Field
		gbc = new GridBagConstraints();
		pwdJTextField = new JTextField();
		gbc.gridx =1;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		pwdJTextField.setColumns(18);
		gbc.insets = new Insets(positionTop+40, 12, 0, 0);
		adminFrame.add(pwdJTextField,gbc);
		
		//setting confirm JButton
		gbc=new GridBagConstraints();
		confirmButton = new JButton("Confirm");
		gbc.gridx =0;
		gbc.gridy= 3;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(positionTop+80, 0, 0, 0);
		adminFrame.add(confirmButton,gbc);
		
		//setting clear Button
		gbc = new GridBagConstraints();
		clearButton = new JButton("Clear");
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor = new GridBagConstraints().NORTHWEST;
		gbc.insets = new Insets(positionTop + 80, 20, 0, 0);
		adminFrame.add(clearButton,gbc);
		
		
		//setting Frame
		adminFrame.setSize(500, 500);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setVisible(true);
		
		//Action listener
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				databaseAction.AdminPasswordLogin adminAction = new AdminPasswordLogin();
				if(adminAction.verifyPasswordAndID(staffIDJTextField.getText(),pwdJTextField.getText())==true) {
					logger.info("Successful login");
					adminFrame.dispose();
					new DashBoard();
					
				}
				else if(attempt==1) {
					JOptionPane.showMessageDialog(null, "Maximum attemps reached\nSystem will close","Login Status",JOptionPane.INFORMATION_MESSAGE);
					logger.warn("Maximum attempts reached, System closed");
					adminFrame.dispose();
				}
				else {
					logger.warn("Unsuccessful Login Attempt");
					attempt--;
					JOptionPane.showMessageDialog(null, attempt+" attempts left","Login Status",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				staffIDJTextField.setText(null);
				pwdJTextField.setText(null);
				logger.info("Clear Button Clicked");
			}
		});
	}

	public static void main(String[] args) {
		new AdminLogin();
	}
	
}
