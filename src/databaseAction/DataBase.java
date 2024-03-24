package databaseAction;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DataBase {
	
	private static java.sql.Connection myConn=null;
	
	public static java.sql.Connection getDatabaseConnection(){
		
		String url="jdbc:mysql://localhost:3306/approjectdatabase";
		
		try {
		myConn= DriverManager.getConnection(url,"root","");
		
		if(myConn==null) {
			JOptionPane.showMessageDialog(null,"Connected to local servcer","JDBC Connection Status",JOptionPane.INFORMATION_MESSAGE);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return myConn;
	}
	
	public static void main(String[] args) {
		new DataBase();
	}
	
}
