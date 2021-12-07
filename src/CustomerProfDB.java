import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerProfDB {
    private int numCustomer = 0; //Number of Customers
    private int currentCustomerIndex = 0; //Index of current customer
    private String fileName; //FileName
    ArrayList<CustomerProf> customerList = new ArrayList<>(); //Array of customers
    public boolean isValidfile = true;

    //Database Constructor
    CustomerProfDB(String file){
        fileName = file; //Set fileName
        initializeDatabase(fileName); //Initialize local database from file
    }

    public void insertNewProfile(CustomerProf customer){
        customerList.add(customer); //Add Customer
        numCustomer++; //Increment
    }

    public boolean deleteProfile(String adminID, String lastName){
        for(CustomerProf customer : customerList) //Loop through array of customers
        {
            //Match adminID and lastName
            if(customer.getadminID().equals(adminID) && customer.getLastName().equals(lastName)){
                customerList.remove(customer); //Remove from array
                numCustomer--; //Decrement number of customers
                return true; //Customer Found; return true
            }
        }
        return false; //Customer not found
    }

    public CustomerProf findProfile(String adminID, String lastName){
        for(CustomerProf customer : customerList) //Loop through array of customers
        {
            //Match adminID and lastName
            if(customer.getadminID().equals(adminID) && customer.getLastName().equals(lastName)){
                return customer; //Customer Found; Return Profile
            }
        }
        //Return null if customer not found
        return null;
    }

    public CustomerProf findFirstProfile() {
        if(numCustomer > 0){
            //Get first profile
            return customerList.get(0);
        }
        else{
            //Return null if array is empty
            return null;
        }
    }

    public CustomerProf findNextProfile() {
        if(numCustomer > 1 && currentCustomerIndex + 1 < numCustomer){
            return customerList.get(++currentCustomerIndex); //Return Next Customer; Increment index
        }
        else{
            currentCustomerIndex = 0; //Reset Index
            return null; //Return Null if there are no more customers
        }
    }

    public void writeAllCustomerProf(){
        try {
            FileWriter write_to_file = new FileWriter(fileName); //File object with write permission
            for (CustomerProf customer : customerList) { //Loop through customers
                //Format Customer Data
                String to_write = String.format("%s, %s, %s, %s, %s, %.2f, %s, %s, %s, %s, %s, %s\n",
                        customer.getadminID(), customer.getFirstName(), customer.getLastName(),
                        customer.getAddress(), customer.getPhone(), customer.getIncome(),
                        customer.getStatus(), customer.getUse(), customer.getVehicleInfo().getModel(),
                        customer.getVehicleInfo().getYear(), customer.getVehicleInfo().getType(),
                        customer.getVehicleInfo().getMethod());
                write_to_file.write(to_write); //Write to file
            }
            System.out.println("Successfully wrote to the file."); //Everything Worked Correctly
            write_to_file.close(); //Close File
        } catch (Exception e) { //Catch Error
            System.out.println("An error occurred."); //Print to user
            e.printStackTrace(); //Print stackTrace
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
            isValidfile = false;
        }

    }

    private void print_list(){ //For Testing Purposes
        System.out.format("Number of Customers: %d\n", numCustomer); //Number of Cusomters
        for(CustomerProf customer : customerList) //Loop through Array
        {
            System.out.println(customer.getFirstName()); //Print First Name
        }

    }

    public static void main(String[] args) {
        VehicleInfo mock_vehicle = new VehicleInfo("Honda Civic", "2021", "Hatchback", "FWD");
        CustomerProf mock_Customer = new CustomerProf("007", "James", "Bond", "2075 Hillside Rd, Storrs, CT 06269", "8675309", (float)10000, "Status", "Use", mock_vehicle);

        String file =  "customer_profiles.txt";
        CustomerProfDB list = new CustomerProfDB(file);
        list.insertNewProfile(mock_Customer);
        list.print_list();
    }
}
