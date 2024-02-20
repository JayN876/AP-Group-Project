package employees_salaries;

import java.util.Date;

//Abstract class for all employees
abstract class Employee_Salary {
 protected int staffId;
 protected Date startDate;
 protected Date endDate;

 public Employee_Salary (int staffId, Date startDate, Date endDate) {
     this.staffId = staffId;
     this.startDate = startDate;
     this.endDate = endDate;
 }

 public abstract double calculateSalary();
}

//Concrete class for Administrative Worker
class AdministrativeWorker extends Employee_Salary {
 private double salary;

 public AdministrativeWorker(int staffId, Date startDate, Date endDate, double salary) {
     super(staffId, startDate, endDate);
     this.salary = salary;
 }

 @Override
 public double calculateSalary() {
     return salary;
 }
}

//Concrete class for Maintenance Worker
class MaintenanceWorker extends Employee_Salary {
 private double salary;

 public MaintenanceWorker(int staffId, Date startDate, Date endDate, double salary) {
     super(staffId, startDate, endDate);
     this.salary = salary;
 }

 @Override
 public double calculateSalary() {
     return salary;
 }
}


class Driver extends Employee_Salary {
 private int trips;
 private double earningsPerTrip;

 public Driver(int staffId, Date startDate, Date endDate, int trips, double earningsPerTrip) {
     super(staffId, startDate, endDate);
     this.trips = trips;
     this.earningsPerTrip = earningsPerTrip;
 }

 @Override
 public double calculateSalary() {
     return trips * earningsPerTrip * 0.3; // 30% of total earnings from trips
 }
}

//Salary Calculator class
public class Employee {
 public static void main(String[] args) {
     
     AdministrativeWorker adminWorker = new AdministrativeWorker(101, new Date(), new Date(), 3000);
     MaintenanceWorker maintenanceWorker = new MaintenanceWorker(102, new Date(), new Date(), 2500);
     Driver driver = new Driver(103, new Date(), new Date(), 20, 100); // 20 trips, $100 earnings per trip

     System.out.println("Salary for Administrative Worker: $" + adminWorker.calculateSalary());
     System.out.println("Salary for Maintenance Worker: $" + maintenanceWorker.calculateSalary());
     System.out.println("Salary for Driver: $" + driver.calculateSalary());
 }
}