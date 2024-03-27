INSERT INTO Staff (staffId, fName, lName, telephone, dob, email, position, status) 
VALUES 
('1001', 'John', 'Doe', '18761234567', '1990-01-01', 'john.doe@example.com', 'Administrative Staff', 'Active'),
('1002', 'Jane', 'Smith', '18762458345', '1995-05-15', 'jane.smith@example.com', 'Administrative Staff', 'Active'),
('1003', 'Michael', 'Johnson', '18763284957', '1985-11-20', 'michael.johnson@example.com', 'Administrative Staff', 'Active'),
('1004', 'Emily', 'Brown', '18763426381', '1988-09-10', 'emily.brown@example.com', 'Administrative Staff', 'Active'),
('1005', 'David', 'Wilson', '18763547281', '1992-03-25', 'david.wilson@example.com', 'Administrative Staff', 'Active'),
('1006', 'Sarah', 'Davis', '18763274826', '1987-07-18', 'sarah.davis@example.com', 'Administrative Staff', 'Active'),
('1007', 'Daniel', 'Martinez', '18761122334', '1993-12-05', 'daniel.martinez@example.com', 'Administrative Staff', 'Active'),
('1008', 'Jennifer', 'Taylor', '18762233446', '1989-08-30', 'jennifer.taylor@example.com', 'Administrative Staff', 'Active'),
('1009',  'Christopher', 'Thomas', '18766378491', '1994-04-12', 'christopher.thomas@example.com', 'Driver', 'Active'),
('1010', 'Michelle', 'Anderson', '18767303902', '1986-02-20', 'michelle.anderson@example.com', 'Driver', 'Active'),
('1011', 'Matthew', 'Garcia', '18763789026', '1991-06-28', 'matthew.garcia@example.com', 'Maintenance Workers', 'Active'),
('1012', 'Amanda', 'Rodriguez', '18767783664', '1984-10-15', 'amanda.rodriguez@example.com', 'Maintenance Workers', 'Active');
 
INSERT INTO AdminLogin (staffId, password) 
VALUES 
('1001', 'password1'),
('1002', 'password2'),
('1003', 'password3'),
('1004', 'password4'),
('1005', 'password5'),
('1006', 'password6'),
('1007', 'password7'),
('1008', 'password8');
 
 
-- Insert staff addresses into the StaffAddress table
INSERT INTO StaffAddress (staffId, street, community, parish)
VALUES
('1001', '123 Main Street', 'Portmore', 'Kingston'),
('1002', '456 Elm Street', 'YorkTown', 'St. Andrew'),
('1003', '789 Oak Street', 'Spanish Town', 'St. Catherine'),
('1004', '101 Pine Street', 'Montego Bay', 'St. James'),
('1005', '202 Maple Street', 'Morant Bay', 'St. Thomas'),
('1006', '303 Cedar Street', 'Chapelton', 'Clarendon'),
('1007', '404 Birch Street', 'Christiana', 'Manchester'),
('1008', '505 Walnut Street', 'Black River', 'St. Elizabeth'),
('1009', '606 Cherry Street', 'Port Antonio', 'Portland'),
('1010', '707 Spruce Street', 'Lucea', 'Hanover'),
('1011', '808 Willow Street', 'Bluefields', 'Westmoreland'),
('1012', '909 Sycamore Street', 'Annotto Bay', 'St. Mary');


-- Insert staff address2 into staffAddress
INSERT INTO StaffAddress (staffId, street, community, parish)
VALUES
('1001', '456 Elm Street', 'Downtown', 'Kingston'),
('1003', '789 Maple Avenue', 'Riverside', 'St. Catherine'),
('1005', '321 Oak Road', 'Hillside', 'St. Andrew'),
('1007', '654 Pine Lane', 'Meadowbrook', 'St. James'),
('1010', '987 Birch Boulevard', 'Highland', 'St. Ann');
 
INSERT INTO Admin (adminId, staffId, position)
VALUES
('ADM1', '1001', 'Manager'),
('ADM2', '1002', 'Supervisor'),
('ADM3', '1003', 'HR Manager'),
('ADM4', '1004', 'Administrative Clerk'),
('ADM5', '1005', 'Manager'),
('ADM6', '1006', 'Supervisor'),
('ADM7', '1007', 'HR Manager'),
('ADM8', '1008', 'Administrative Clerk');


 
INSERT INTO Contractor (Contractor_ID, staffId)
VALUES
('3001CTR1', '1009'),
('3001CTR2', '1010'),
('3001CTR3', '1011'),
('3001CTR4', '1012');


 
-- Insert drivers into the Driver table
INSERT INTO Driver (plateNumber, staffId, contractorId)
VALUES
('8723PZ', '1009', '3001CTR1'),
('8634RX', '1010', '3001CTR2');

 
-- Insert maintenance workers into the Maintenance table
INSERT INTO Maintenance (Contractor_ID, staffId, skillSet)
VALUES
('3001CTR3', '1011', 'Vehicle Maintenance'),
('3001CTR4', '1012', 'Facility Maintenance');


 
-- Insert admin actions for ADM1 (Manager) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM1', 'Add Deliver Request'),
('ADM1', 'Add Route and Rate'),
('ADM1', 'Add Staff'),
('ADM1', 'Add Customer'),
('ADM1', 'View Outstanding Balance'),
('ADM1', 'View Report and Invoice');
 
-- Insert admin actions for ADM2 (Supervisor) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM2', 'Add Deliver Request'),
('ADM2', 'Add Route and Rate'),
('ADM2', 'Add Staff'),
('ADM2', 'Add Customer'),
('ADM2', 'View Outstanding Balance'),
('ADM2', 'View Report and Invoice');
 
-- Insert admin actions for ADM3 (HR Manager) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM3', 'Add Deliver Request'),
('ADM3', 'Add Route and Rate'),
('ADM3', 'Add Staff'),
('ADM3', 'Add Customer'),
('ADM3', 'View Outstanding Balance'),
('ADM3', 'View Report and Invoice');
 
-- Insert admin actions for ADM4 (Administrative Clerk) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM4', 'View Rate Sheet'),
('ADM4', 'Add Route and Rate'),
('ADM4', 'Add Deliver Request'),
('ADM4', 'View Report and Invoice');
 
-- Insert admin actions for ADM5 (Manager) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM5', 'Add Deliver Request'),
('ADM5', 'Add Route and Rate'),
('ADM5', 'Add Staff'),
('ADM5', 'Add Customer'),
('ADM5', 'View Outstanding Balance'),
('ADM5', 'View Report and Invoice');
 
-- Insert admin actions for ADM6 (Supervisor) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM6', 'Add Deliver Request'),
('ADM6', 'Add Route and Rate'),
('ADM6', 'Add Staff'),
('ADM6', 'Add Customer'),
('ADM6', 'View Outstanding Balance'),
('ADM6', 'View Report and Invoice');
 
-- Insert admin actions for ADM7 (HR Manager) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM7', 'Add Deliver Request'),
('ADM7', 'Add Route and Rate'),
('ADM7', 'Add Staff'),
('ADM7', 'Add Customer'),
('ADM7', 'View Outstanding Balance'),
('ADM7', 'View Report and Invoice');
 
-- Insert admin actions for ADM8 (Administrative Clerk) into the AdminAction table
INSERT INTO AdminAction (adminId, action)
VALUES
('ADM8', 'View Rate Sheet'),
('ADM8', 'Add Route and Rate'),
('ADM8', 'Add Deliver Request'),
('ADM8', 'View Report and Invoice');
 
 
-- Insert customers into the Customer table with different names
INSERT INTO Customer (customerId, fName, lName, email, status, contactPerson, company, telephone)
VALUES
('CUS1', 'William', 'Johnson', 'william.johnson@example.com', 'active', '18762348888', 'Grace Kennedy LTD', '18765362732'),
('CUS2', 'Sophia', 'Williams', 'sophia.williams@example.com', 'active', '1876564912', 'JPS', '1876776644'),
('CUS3', 'Ethan', 'Brown', 'ethan.brown@example.com', 'active', '18766348913', 'Caribbean Cement', '1876453673'),
('CUS4', 'Olivia', 'Davis', 'olivia.davis@example.com', 'active', '18769080730', 'Island Farm Supplies', '18766635173'),
('CUS5', 'James', 'Martinez', 'james.martinez@example.com', 'active', '18763547891', 'Red Stripe', '18766678365'),
('CUS6', 'Ava', 'Taylor', 'ava.taylor@example.com', 'active', '18769873416', 'Nutramix Farm Supplies', '18767783526'),
('CUS7', 'Liam', 'Thomas', 'liam.thomas@example.com', 'active', '18766633903', 'Kingston Bookshop', '18767654340'),
('CUS8', 'Isabella', 'Anderson', 'isabella.anderson@example.com', 'active', '18764329054', 'Blakes Pharmacy', '187628309871');
 
 
-- Inserting records with rates within the specified range (5000 to 10000) and addresses in Jamaica
INSERT INTO RouteRate (routeId, rate, sourceStreet, sourceCommunity, sourceParish, destinationStreet, destinationCommunity, destinationParish) 
VALUES 
('RTE001', 5000, '21 Half Way Tree Road', 'Half Way Tree', 'Kingston', 'Gloucester Avenue', 'Montego Bay', 'St. James'),
('RTE002', 6000, '5 Main Street', 'Ocho Rios', 'St. Ann', 'Norman Manley Boulevard', 'Negril', 'Westmoreland'),
('RTE003', 7000, 'Manchester Road', 'Mandeville', 'Manchester', 'West Street', 'Port Antonio', 'Portland'),
('RTE004', 8000, 'Barbara Lane', 'Spanish Town', 'St. Catherine', 'Queen Street', 'Falmouth', 'Trelawny'),
('RTE005', 9000, '38 Main Street', 'May Pen', 'Clarendon', 'Beach Road', 'Savanna-la-Mar', 'Westmoreland'),
('RTE006', 10000, '18 High Street', 'Black River', 'St. Elizabeth', 'Church Street', 'Port Maria', 'St. Mary');

 
-- Inserting customer addresses into the CustomerAddress table with different parishes
INSERT INTO CustomerAddress (customerId, street, community, parish)
VALUES
('CUS1', '12 Hope Road', 'Kingston Gardens', 'Kingston'),
('CUS2', '7 Knutsford Boulevard', 'New Kingston', 'St. Andrew'),
('CUS3', '34 Half Way Tree Road', 'Half Way Tree', 'St. Catherine'),
('CUS4', '18 Barbican Road', 'Barbican', 'Clarendon'),
('CUS5', '77 Marcus Garvey Drive', 'Spanish Town', 'Manchester'),
('CUS6', '3 Windsor Avenue', 'May Pen', 'St. Elizabeth'),
('CUS7', '42 Orange Street', 'Downtown', 'Portland'),
('CUS8', '25 Main Street', 'Ocho Rios', 'St. James');


 
-- Inserting sample orders into the Orders table
INSERT INTO Orders (invoiceNo, dateOfOrder, routeId, plateNumber, customerId, adminId)
VALUES 
('INV001','2024-03-14','RTE001','8723PZ','CUS1','ADM1'),
('INV002','2024-03-21','RTE002','8723PZ','CUS2','ADM2'),
('INV003','2024-02-01','RTE003','8723PZ','CUS3','ADM3'),
('INV004','2024-03-18','RTE004','8634RX','CUS4','ADM4'),
('INV005','2024-01-30','RTE005','8634RX','CUS5','ADM5'),
('INV006','2024-03-17','RTE006','8634RX','CUS6','ADM6');
 
UPDATE Orders 
SET paymentDue = dateOfOrder + INTERVAL '30' DAY;



 
INSERT INTO Transaction (transactionNo, transactionDate, payment, customerId, orderInvoiceNo)
VALUES 
('TRX001', '2024-03-22', 150.00, 'CUS1', 'INV001'),
('TRX002', '2024-03-23', 200.00, 'CUS2', 'INV002'),
('TRX003', '2024-03-04', 175.50, 'CUS3', 'INV003'),
('TRX004', '2024-03-25', 300.75, 'CUS4', 'INV004'),
('TRX005', '2024-03-05', 400.25, 'CUS5', 'INV005'),
('TRX006', '2024-03-27', 250.00, 'CUS6', 'INV006'),
('TRX007', '2024-03-28', 180.00, 'CUS1', 'INV001'),
('TRX008', '2024-03-29', 250.50, 'CUS4', 'INV004'),
('TRX009', '2024-03-30', 320.75, 'CUS6', 'INV006');


INSERT INTO Salary (payId, startDate, endDate, salary, staffId, adminId)
VALUES 
('PAY001', '2024-01-01', '2024-01-31', 50000.00, '1001', 'ADM2'),
('PAY002', '2024-02-01', '2024-02-29', 55000.00, '1001', 'ADM3'),
('PAY003', '2024-03-01', '2024-03-31', 60000.00, '1001', 'ADM4'),
('PAY004', '2024-01-01', '2024-01-31', 45000.00, '1002', 'ADM5'),
('PAY005', '2024-02-01', '2024-02-29', 50000.00, '1002', 'ADM5'),
('PAY006', '2024-03-01', '2024-03-31', 55000.00, '1002', 'ADM6'),
('PAY007', '2024-01-01', '2024-01-31', 40000.00, '1003', 'ADM7'),
('PAY008', '2024-02-01', '2024-02-29', 45000.00, '1003', 'ADM7'),
('PAY009', '2024-03-01', '2024-03-31', 50000.00, '1003', 'ADM8'),
('PAY010', '2024-01-01', '2024-01-31', 35000.00, '1004', 'ADM1'),
('PAY011', '2024-02-01', '2024-02-29', 40000.00, '1004', 'ADM2'),
('PAY012', '2024-03-01', '2024-03-31', 45000.00, '1004', 'ADM3'),
('PAY013', '2024-01-01', '2024-01-31', 30000.00, '1005', 'ADM1'),
('PAY014', '2024-02-01', '2024-02-29', 35000.00, '1005', 'ADM2'),
('PAY015', '2024-03-01', '2024-03-31', 40000.00, '1005', 'ADM7'),
('PAY016', '2024-01-01', '2024-01-31', 25000.00, '1006', 'ADM8'),
('PAY017', '2024-02-01', '2024-02-29', 30000.00, '1006', 'ADM3'),
('PAY018', '2024-03-01', '2024-03-31', 35000.00, '1006', 'ADM2'),
('PAY019', '2024-01-01', '2024-01-31', 20000.00, '1007', 'ADM4'),
('PAY020', '2024-02-01', '2024-02-29', 25000.00, '1007', 'ADM5'),
('PAY021', '2024-03-01', '2024-03-31', 30000.00, '1007', 'ADM6'),
('PAY022', '2024-01-01', '2024-01-31', 15000.00, '1008', 'ADM7'),
('PAY023', '2024-02-01', '2024-02-29', 20000.00, '1008', 'ADM4'),
('PAY024', '2024-03-01', '2024-03-31', 25000.00, '1008', 'ADM5');



-- Insert salary records for drivers with corresponding adminId
INSERT INTO Salary (payId, startDate, endDate, salary, staffId, adminId)
VALUES 
('PAY025', '2024-01-01', '2024-01-31', 40000.00, '1009', 'ADM1'),
('PAY026', '2024-02-01', '2024-02-29', 45000.00, '1009', 'ADM2'),
('PAY027', '2024-03-01', '2024-03-31', 50000.00, '1009', 'ADM3'),
('PAY028', '2024-01-01', '2024-01-31', 35000.00, '1010', 'ADM4'),
('PAY029', '2024-02-01', '2024-02-29', 40000.00, '1010', 'ADM5'),
('PAY030', '2024-03-01', '2024-03-31', 45000.00, '1010', 'ADM6');

-- Insert salary records for maintenance workers with corresponding adminId
INSERT INTO Salary (payId, startDate, endDate, salary, staffId, adminId)
VALUES 
('PAY031', '2024-01-01', '2024-01-31', 30000.00, '1011', 'ADM1'),
('PAY032', '2024-02-01', '2024-02-29', 35000.00, '1011', 'ADM2'),
('PAY033', '2024-03-01', '2024-03-31', 40000.00, '1011', 'ADM3'),
('PAY034', '2024-01-01', '2024-01-31', 25000.00, '1012', 'ADM4'),
('PAY035', '2024-02-01', '2024-02-29', 30000.00, '1012', 'ADM5'),
('PAY036', '2024-03-01', '2024-03-31', 35000.00, '1012', 'ADM6');


