package databaseAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import beans.CompanyRepresentative;
import beans.CreateDeliveryRequest;
import beans.DeliveryDriver;
import beans.DeliveryRoute;
import helpers.PropertyLoader;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	public List<DeliveryRoute> getAllDeliveryRoutes() {
		List<DeliveryRoute> deliveryRoutes = new ArrayList<>();
		
		try {
			String sql = (String)_properties.get("GET_ALL_DELIVERY_ROUTES");
			PreparedStatement preparedStatement = myConn.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(sql);
			if(resultSet != null) {
				while (resultSet.next()) {
					String routeId = resultSet.getString("routeId");
					String route = resultSet.getString("route");
					DeliveryRoute deliveryRoute = new DeliveryRoute(routeId, route);
					deliveryRoutes.add(deliveryRoute);
					
				}
			}
			
		}catch(Exception e) {
			//TODO: Add logs and handle error
			e.printStackTrace();
			
		}
		return deliveryRoutes;
	}
	public List<DeliveryDriver> getAllDrivers() {
		List<DeliveryDriver> deliveryRoutes = new ArrayList<>();
		
		try {
			String sql = (String)_properties.get("GET_ALL_ACTIVE_DRIVERS");
			PreparedStatement preparedStatement = myConn.prepareStatement(sql);
			preparedStatement.setString(1, "active");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(sql);
			if(resultSet != null) {
				while (resultSet.next()) {
					String contractorId = resultSet.getString("contractorId");
					String fullName = resultSet.getString("fullName");
					String plateNumber = resultSet.getString("plateNumber");
					String staffId = resultSet.getString("staffId");
					DeliveryDriver deliveryDriver = new DeliveryDriver(contractorId,staffId,plateNumber,fullName);
					deliveryRoutes.add(deliveryDriver);
					
				}
			}
			
		}catch(Exception e) {
			//TODO: Add logs and handle error
			e.printStackTrace();
			
		}
		return deliveryRoutes;
	}
	
	public boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
		List<DeliveryDriver> deliveryRoutes = new ArrayList<>();
		
		boolean isSuccesful = false;
		try {
			String sql = (String)_properties.get("CREATE_DELIVERY");
			System.out.println(sql);
			PreparedStatement preparedStatement = myConn.prepareStatement(sql);
			preparedStatement.setString(1, "active");
			LocalDate dateOfOrder = createDeliveryRequest.getOrderDate();
			LocalDate paymentDue = dateOfOrder.plusDays(30);
			preparedStatement.setString(1, "INV00"+ (Math.random()*LocalDateTime.now().getNano()));
			preparedStatement.setString(2,  dateOfOrder.toString());
			preparedStatement.setString(3, paymentDue.toString());
			preparedStatement.setString(4, createDeliveryRequest.getRouteId());
			preparedStatement.setString(4, createDeliveryRequest.getPlateNumber() );
			preparedStatement.setString(6, createDeliveryRequest.getCustomerId());
			preparedStatement.setString(7, createDeliveryRequest.getAdminId());
			
			int rowsAffected = preparedStatement.executeUpdate();

            // Close the statement
			preparedStatement.close();

            // Display JOptionPane message
			if (rowsAffected > 0) {
                isSuccesful = true;
            } else {
                isSuccesful = false;
            }
			
			
		}catch(Exception e) {
			//TODO: Add logs and handle error
			e.printStackTrace();
			isSuccesful = false;
		}
		return isSuccesful;
	}
}
