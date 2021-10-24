package com;
import java.io.*;
import java.util.*;
import java.lang.*;

public class CustomerProfInterface {
    private CustomerProfDB databaseFile;

    CustomerProfInterface(String file){
        File fileName = new File(file);
        databaseFile = new CustomerProfDB(file);
    }
    public void getUserChoice(){
        System.out.println("Please enter the number of the task you would like");
        System.out.println("1. Find Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. New Customer");
        System.out.println("4. Remove Customer");
        System.out.println("5. Display All Customers");
        System.out.println("Exit");

        Scanner in = new Scanner(System.in);
        String selection = in.nextLine();

        while (!selection.equals("exit") && !selection.equals("Exit")){
            switch (selection) {
                case "1" -> findCustomerProf();
                case "2" -> updateCustomerProf();
                case "3" -> {
                    CustomerProf newCustomer = createNewCustomerProf();
                    databaseFile.insertNewProfile(newCustomer);
                }
                case "4" -> deleteCustomerProf();
                case "5" -> displayAllCustomerProf();
                default -> System.out.println("Invalid Operation. Please use a number (1-3) or enter 'exit' to close the session");
            }
            System.out.println("Enter new command or 'Exit'");
            selection = in.nextLine();
        }
        writeToDB();
        System.out.println("Successfully closed session");
    }

    public void deleteCustomerProf(){
        Scanner in = new Scanner(System.in);
        System.out.println("Once a profile is deleted it cannot be recovered");
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine();
        System.out.println("Enter LastName:");
        String lastName = in.nextLine();
        boolean wasDeleted = databaseFile.deleteProfile(adminID, lastName);
        if(wasDeleted){
            System.out.println("Account was successfully deleted");
        }
        else{
            System.out.println("Account was not deleted. Account does not exist or incorrect adminID");
        }
    }

    public void findCustomerProf(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine();
        System.out.println("Enter LastName:");
        String lastName = in.nextLine();
        CustomerProf customer = databaseFile.findProfile(adminID, lastName);
        if (customer == null){
            String adminIdString = String.format("%s has not created this customer.", adminID);
            System.out.println(adminIdString);
        }
        else{
            displayCustomerProf(customer);
        }
    }

    public void updateCustomerProf(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine();
        System.out.println("Enter LastName:");
        String lastName = in.nextLine();
        CustomerProf customer = databaseFile.findProfile(adminID, lastName);
        if (customer == null){
            String adminIdString = String.format("%s has not created this customer.", adminID);
            System.out.println(adminIdString);
        }
        else{
            System.out.println("Customer Found. Please indicate which item you would like to edit.");
            System.out.println("1. Change Address");
            System.out.println("2. Change Phone");
            System.out.println("3. Change Use");
            System.out.println("4. Change Status");
            System.out.println("5. Vehicle Model");
            System.out.println("6. Vehicle Year");
            System.out.println("7. Vehicle Type");
            System.out.println("8. Vehicle Method");
            System.out.println("Exit");
            String selection = in.nextLine();

            while (!selection.equals("exit") && !selection.equals("Exit")){
                switch (selection) {
                    case "1" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.updateAddress(value);
                    }
                    case "2" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.updatePhone(value);
                    }
                    case "3" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.updateUse(value);
                    }
                    case "4" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.updateStatus(value);
                    }
                    case "5" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.getVehicleInfo().updateModel(value);
                    }
                    case "6" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.getVehicleInfo().updateYear(value);
                    }
                    case "7" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.getVehicleInfo().updateType(value);
                    }
                    case "8" -> {
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine();
                        customer.getVehicleInfo().updateMethod(value);
                    }
                    default -> System.out.println("Invalid Operation");
                }
                System.out.println("To edit another value enter its respective number or 'Exit'");
                selection = in.nextLine();
            }

        }
    }
    public void displayCustomerProf(CustomerProf customer){
        String profile = String.format("%s, %s, %s, %s, %s, %.2f, %s, %s, %s, %s, %s, %s",
                customer.getadminID(), customer.getFirstName(), customer.getLastName(),
                customer.getAddress(), customer.getPhone(), customer.getIncome(),
                customer.getStatus(), customer.getUse(), customer.getVehicleInfo().getModel(),
                customer.getVehicleInfo().getYear(), customer.getVehicleInfo().getType(),
                customer.getVehicleInfo().getMethod());
        System.out.println(profile);
    }

    public void displayAllCustomerProf(){
        boolean userFound = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine();

        CustomerProf customer = databaseFile.findFirstProfile();
        if (customer == null){
            System.out.println("There are no users in the database.");
        }
        else{
            while(customer != null){
                if (customer.getadminID().equals(adminID)){
                    displayCustomerProf(customer);
                    userFound = true;
                }
                customer = databaseFile.findNextProfile();
            }

        }

        if(!userFound){
            String adminIdString = String.format("%s has not created any users.", adminID);
            System.out.println(adminIdString);
        }
    }

    public void writeToDB(){
        databaseFile.writeAllCustomerProf();
    }

    CustomerProf createNewCustomerProf(){
        Scanner in = new Scanner(System.in);
        boolean valid_float = false;

        System.out.println("Enter AdminID:");
        String adminID = in.nextLine();
        System.out.println("Enter FirstName:");
        String firstName = in.nextLine();
        System.out.println("Enter LastName:");
        String lastName = in.nextLine();
        System.out.println("Enter Address:");
        String address = in.nextLine();
        System.out.println("Enter PhoneNumber:");
        String phone = in.nextLine();
        System.out.println("Enter Income:");
        float income = 0F;
        while(!valid_float){
            try{
                income = Float.parseFloat(in.nextLine());
                valid_float = true;
            }catch(Exception e){
                System.out.println("Please input Income as a float:");
            }
        }
        System.out.println("Enter Status:");
        String status = in.nextLine();
        System.out.println("Enter Use:");
        String use = in.nextLine();

        VehicleInfo vehicleInfo = createNewVehicleInfo();
        return new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, vehicleInfo);
    }

    VehicleInfo createNewVehicleInfo(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter CarModel:");
        String model = in.nextLine();
        System.out.println("Enter Year:");
        String year = in.nextLine();
        System.out.println("Enter Type:");
        String carType = in.nextLine();
        System.out.println("Enter Method:");
        String method = in.nextLine();

        return new VehicleInfo(model, year, carType, method);
    }

    public static void main(String[] args) {
        CustomerProfInterface inter = new CustomerProfInterface("test1.txt");
        inter.getUserChoice();
    }
}
