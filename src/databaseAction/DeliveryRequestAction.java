package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import beans.CompanyRepresentative;

import helpers.PropertyLoader;

public class DeliveryRequestAction {
	private final Connection myConn;
	private final PropertyLoader _propertyLoader = new PropertyLoader(
			"DeliveryRequestPreparedStatements.properties");
	private final Properties _properties;

	public DeliveryRequestAction() {
		myConn = databaseAction.DataBase.getDatabaseConnection();
		_propertyLoader.loadPropertyResource();
		_properties = _propertyLoader.getProperties();
	}

	public List<CompanyRepresentative> getAllCustomerCompanies() {
		List<CompanyRepresentative> companies = new ArrayList<>();
		
		try {
			String sql = (String)_properties.get("GET_ALL_ACTIVE_COMPANIES_WITH_REPRESENTATIVES");
			PreparedStatement preparedStatement = myConn.prepareStatement(sql);
			preparedStatement.setString(1, "active");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(sql);
			if(resultSet != null) {
				while (resultSet.next()) {
					String customerId = resultSet.getString("customerId");
					String customer = resultSet.getString("companyRep");
					CompanyRepresentative rep = new CompanyRepresentative(customerId, customer);
					companies.add(rep);
					
				}
			}
			
		}catch(Exception e) {
			//TODO: Add logs and handle error
			e.printStackTrace();
			
		}
		return companies;
	}
}
