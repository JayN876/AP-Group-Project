CREATE DATABASE `approjectdatabase`;
-- DROP DATABASE `approjectdatabase`; 

USE `approjectdatabase`;

CREATE TABLE Staff (
    staffId VARCHAR(50) PRIMARY KEY,
    fName VARCHAR(50),
    lName VARCHAR(50),
    telephone VARCHAR(20),
    dob DATE,
    email VARCHAR(100),
    position VARCHAR(100),
    status VARCHAR(50)
);

CREATE TABLE AdminLogin (
    staffId VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (staffId) REFERENCES Staff(staffId)
);

CREATE TABLE StaffAddress (
    staffAddressId INT AUTO_INCREMENT PRIMARY KEY,
    staffId VARCHAR(50),
    street VARCHAR(100),
    community VARCHAR(100),
    parish VARCHAR(100),    
    CONSTRAINT UC_StaffAddress UNIQUE (staffId, street, parish, community),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId)
);

CREATE TABLE Contractor (
    Contractor_ID VARCHAR(50),
    staffId VARCHAR(50),
    PRIMARY KEY (Contractor_ID, staffId),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId)
);

CREATE TABLE Admin (
    adminId VARCHAR(50) PRIMARY KEY,
    staffId VARCHAR(50),
    position VARCHAR(100),
    CONSTRAINT UC_Admin UNIQUE (adminId, staffId),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId)
);

CREATE TABLE AdminAction (
    adminId VARCHAR(50),
    action VARCHAR(100),
    PRIMARY KEY (action, adminId),
    FOREIGN KEY (adminId) REFERENCES Admin(adminId)
);

CREATE TABLE Salary (
    payId VARCHAR(50) PRIMARY KEY,
    startDate DATE,
    endDate DATE,
    salary DOUBLE,
    staffId VARCHAR(50),
    adminId VARCHAR(50),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId),
    FOREIGN KEY (adminId) REFERENCES Admin(adminId)
);

CREATE TABLE Maintenance (
    Contractor_ID VARCHAR(50),
    staffId VARCHAR(50),
    skillSet VARCHAR(100),
    PRIMARY KEY (Contractor_ID, staffId),
    FOREIGN KEY (Contractor_ID) REFERENCES Contractor(Contractor_ID),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId)
);

CREATE TABLE Driver (
    plateNumber VARCHAR(20),
    staffId VARCHAR(50),
    contractorId VARCHAR(50),
    PRIMARY KEY (plateNumber, contractorId, staffId),
    FOREIGN KEY (staffId) REFERENCES Staff(staffId),
    FOREIGN KEY (contractorId) REFERENCES Contractor(Contractor_ID)
);

CREATE TABLE Customer (
    customerId VARCHAR(50) PRIMARY KEY,
    fName VARCHAR(50),
    lName VARCHAR(50),
    email VARCHAR(100),
    status VARCHAR(50),
    contactPerson VARCHAR(100),
    company VARCHAR(100),
    telephone VARCHAR(20)
);

CREATE TABLE CustomerAddress (
    customerId VARCHAR(50),
    street VARCHAR(100),
    community VARCHAR(100),
    parish VARCHAR(100),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);






CREATE TABLE RouteRate (
    routeId VARCHAR(50) PRIMARY KEY,
    rate DOUBLE,
    sourceStreet VARCHAR(100),
   sourceCommunity VARCHAR(100),
    sourceParish VARCHAR(100),   
    destinationStreet VARCHAR(100),    
    destinationCommunity VARCHAR(100),
    destinationParish VARCHAR(100)
);

CREATE TABLE Orders (
    invoiceNo VARCHAR(50) PRIMARY KEY,
    paymentDue DATE,
    dateOfOrder DATE,
    routeId VARCHAR(50),
    plateNumber VARCHAR(20),
    customerId VARCHAR(50),
    adminId VARCHAR(50),
    FOREIGN KEY (routeId) REFERENCES RouteRate(routeId),
    FOREIGN KEY (plateNumber) REFERENCES Driver(plateNumber),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (adminId) REFERENCES Admin(adminId)
);

CREATE TABLE Transaction (
    transactionNo VARCHAR(50) PRIMARY KEY,
    transactionDate DATE,
    payment DOUBLE,
    customerId VARCHAR(50),
    orderInvoiceNo VARCHAR(50),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (orderInvoiceNo) REFERENCES Orders(invoiceNo)
);
