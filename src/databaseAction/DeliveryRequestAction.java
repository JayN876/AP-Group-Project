package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import helpers.PropertyLoader;

public class DeliveryRequestAction {
	private final Connection myConn;
	private final PropertyLoader _propertyLoader = new PropertyLoader(
			"resources/RateSheetPreparedStatements.properties");
	private final Properties _properties;

	public DeliveryRequestAction() {
		myConn = databaseAction.DataBase.getDatabaseConnection();
		_propertyLoader.loadPropertyResource();
		_properties = _propertyLoader.getProperties();
	}

	public ResultSet getAllCustomerCompanies() {
		ResultSet resultSet = null;
		
		try {
			String sql = (String)_properties.get("GET_ALL_ACTIVE_COMPANIES_WITH_REPRESENTATIVES");
			PreparedStatement preparedStatement = myConn.prepareStatement(sql);
			preparedStatement.setString(0, "active");
			
			resultSet = preparedStatement.executeQuery();
			
		}catch(Exception e) {
			//TODO: Add logs and handle error
			resultSet = null;
		}
		return resultSet;
	}
}
