package com;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerProfDB {
    private int numCustomer = 0;
    private int currentCustomerIndex = 0;
    private String fileName;
    ArrayList<CustomerProf> customerList = new ArrayList<>();

    CustomerProfDB(String file){
        fileName = file;
        initializeDatabase(fileName);
    }

    public void insertNewProfile(CustomerProf customer){
        customerList.add(customer);
        numCustomer++;
    }

    public boolean deleteProfile(String adminID, String lastName){
        for(CustomerProf customer : customerList)
        {
            if(customer.getadminID().equals(adminID) && customer.getLastName().equals(lastName)){
                customerList.remove(customer);
                numCustomer--;
                return true;
            }
        }
        return false;
    }

    public CustomerProf findProfile(String adminID, String lastName){
        for(CustomerProf customer : customerList)
        {
            if(customer.getadminID().equals(adminID) && customer.getLastName().equals(lastName)){
                return customer;
            }
        }
        return null;
    }

    public CustomerProf findFirstProfile() {
        if(numCustomer > 0){
            return customerList.get(0);
        }
        else{
            return null;
        }
    }

    public CustomerProf findNextProfile() {
        if(numCustomer > 1 && currentCustomerIndex + 1 < numCustomer){
            return customerList.get(++currentCustomerIndex);
        }
        else{
            currentCustomerIndex = 0;
            return null;
        }
    }

    public void writeAllCustomerProf(){
        try {
            FileWriter write_to_file = new FileWriter(fileName);
            for (CustomerProf customer : customerList) {
                String to_write = String.format("%s, %s, %s, %s, %s, %.2f, %s, %s, %s, %s, %s, %s\n",
                        customer.getadminID(), customer.getFirstName(), customer.getLastName(),
                        customer.getAddress(), customer.getPhone(), customer.getIncome(),
                        customer.getStatus(), customer.getUse(), customer.getVehicleInfo().getModel(),
                        customer.getVehicleInfo().getYear(), customer.getVehicleInfo().getType(),
                        customer.getVehicleInfo().getMethod());
                write_to_file.write(to_write);
            }
            System.out.println("Successfully wrote to the file.");
            write_to_file.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void initializeDatabase(String file) {
        try {
            File FileObj = new File(file); //Create File Object
            if (FileObj.createNewFile()) { //Try to create File
                System.out.println("File created: " + FileObj.getName());
            } else { //File Already Exists
                Scanner scanner = new Scanner(new File(file)); //Read File
                while (scanner.hasNextLine()) { //Read Next Line
                    String[] line = scanner.nextLine().split(", "); //Split With Comma and Space
                    VehicleInfo new_vehicle = new VehicleInfo(line[8], line[9], line[10], line[11]); //Create Vehicle
                    insertNewProfile(new CustomerProf(line[0], line[1], line[2], line[3], line[4], Float.parseFloat(line[5]), line[6], line[7], new_vehicle)); //Insert new customer object
                }
            }
        } catch(Exception e){ //Throw Error if error in file format
            System.out.println("Error Reading File: Please User Correct format"); //Print to user
            e.printStackTrace(); //Print StackTrace
        }

    }

    private void print_list(){ //For Testing Purposes
        System.out.format("Number of Customers: %d\n", numCustomer);
        for(CustomerProf customer : customerList)
        {
            System.out.println(customer.getFirstName());
        }

    }

    public static void main(String[] args) {
        VehicleInfo mock_vehicle = new VehicleInfo("Honda Civic", "2021", "Hatchback", "FWD");
        CustomerProf mock_Customer = new CustomerProf("007", "James", "Bond", "2075 Hillside Rd, Storrs, CT 06269", "8675309", (float)10000, "Status", "Use", mock_vehicle);

        String file =  "customer_profiles.txt";
        CustomerProfDB list = new CustomerProfDB(file);
        list.insertNewProfile(mock_Customer);
    }
}
