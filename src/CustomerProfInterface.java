import java.io.*;
import java.util.*;
import java.lang.*;

public class CustomerProfInterface {
    private CustomerProfDB databaseFile; //Database

    public CustomerProfInterface(String file){
        File fileName = new File(file); //File Object
        databaseFile = new CustomerProfDB(file); //Initialize Database
    }
    public void getUserChoice(){
        //Print Options to User
        System.out.println("Please enter the number of the task you would like");
        System.out.println("1. Find Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. New Customer");
        System.out.println("4. Remove Customer");
        System.out.println("5. Display All Customers");
        System.out.println("Exit");
        //Read option and Save
        Scanner in = new Scanner(System.in);
        String selection = in.nextLine();
        //Continue until user enters exit
        while (!selection.equals("exit") && !selection.equals("Exit")){
            switch (selection) {
                case "1" -> findCustomerProf(); //Call findCustomerProf
                case "2" -> updateCustomerProf(); // Call updateCustomerProf
                case "3" -> {
                    CustomerProf newCustomer = createNewCustomerProf();
                    databaseFile.insertNewProfile(newCustomer);
                    //Create new customer and insert into database
                }
                case "4" -> deleteCustomerProf(); //Delete Customer
                case "5" -> displayAllCustomerProf(); //Display Customers with Similar AdminId
                default -> System.out.println("Invalid Operation. Please use a number (1-3) or enter 'exit' to close the session");
            }
            System.out.println("Enter new command or 'Exit'");
            //Read new input from user
            selection = in.nextLine();
        }
        //User has exited; Save to file
        writeToDB();
        //Let user know program has terminated
        System.out.println("Successfully closed session");
    }

    public void deleteCustomerProf(){
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Once a profile is deleted it cannot be recovered"); //Warning to user
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine(); //Get adminID
        System.out.println("Enter LastName:");
        String lastName = in.nextLine(); //Get lastName
        boolean wasDeleted = databaseFile.deleteProfile(adminID, lastName); //Try to delete
        if(wasDeleted){
            System.out.println("Account was successfully deleted"); //Succesfull deletion
        }
        else{
            System.out.println("Account was not deleted. Account does not exist or incorrect adminID"); //Account not found
        }
    }

    public void findCustomerProf(){
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine(); //Get adminID
        System.out.println("Enter LastName:");
        String lastName = in.nextLine(); //Get lastName
        CustomerProf customer = databaseFile.findProfile(adminID, lastName); //Try to find profile
        if (customer == null){ //Profile not found
            String adminIdString = String.format("%s has not created this customer.", adminID);
            System.out.println(adminIdString);
        }
        else{
            displayCustomerProf(customer); //Display found customer profile
        }
    }

    public void updateCustomerProf(){
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine(); //Get adminID
        System.out.println("Enter LastName:");
        String lastName = in.nextLine(); //Get lastName
        CustomerProf customer = databaseFile.findProfile(adminID, lastName); //Try to find profile
        if (customer == null){
            //Cusomter not found
            String adminIdString = String.format("%s has not created this customer.", adminID);
            System.out.println(adminIdString); //Let user know customer was not found
        }
        else{
            //Customer Found
            //Prompt user with options
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
            String selection = in.nextLine(); //Read option

            //Prompt user until 'exit' is entered
            while (!selection.equals("exit") && !selection.equals("Exit")){
                switch (selection) {
                    case "1" -> {
                        //Option 1: Update Address
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new address
                        customer.updateAddress(value); //Call Update
                    }
                    case "2" -> {
                        //Option2: Update phone
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new phone
                        customer.updatePhone(value); //Call updatePhone
                    }
                    case "3" -> {
                        //Option3: Update Use
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new use
                        customer.updateUse(value); //Call updateUse
                    }
                    case "4" -> {
                        //Option4: Update Status
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new status
                        customer.updateStatus(value); //Call updateStatus
                    }
                    case "5" -> {
                        //Option 5: Update Vehicle Model
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new model
                        customer.getVehicleInfo().updateModel(value); //Call updateModel
                    }
                    case "6" -> {
                        //Option 6: Update Vehicle Year
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new year
                        customer.getVehicleInfo().updateYear(value); //Call updateYear
                    }
                    case "7" -> {
                        //Option7: Update Vehicle Type
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new type
                        customer.getVehicleInfo().updateType(value); //Call updateType
                    }
                    case "8" -> {
                        //Option 8: Update Vehicle Method
                        System.out.println("Please Enter New Value");
                        String value = in.nextLine(); //Read new method
                        customer.getVehicleInfo().updateMethod(value); //Call updateMethod
                    }
                    //User enters unavailable option
                    default -> System.out.println("Invalid Operation");
                }
                //Prompt user to enter another operation
                System.out.println("To edit another value enter its respective number or 'Exit'");
                selection = in.nextLine(); // read option
            }

        }
    }
    public void displayCustomerProf(CustomerProf customer){
        //Format profiles as they are displayed in the database file
        String profile = String.format("%s, %s, %s, %s, %s, %.2f, %s, %s, %s, %s, %s, %s",
                customer.getadminID(), customer.getFirstName(), customer.getLastName(),
                customer.getAddress(), customer.getPhone(), customer.getIncome(),
                customer.getStatus(), customer.getUse(), customer.getVehicleInfo().getModel(),
                customer.getVehicleInfo().getYear(), customer.getVehicleInfo().getType(),
                customer.getVehicleInfo().getMethod());
        System.out.println(profile); //Print profile
    }

    public void displayAllCustomerProf(){
        boolean userFound = false; //Was a user found
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Enter AdminID:");
        String adminID = in.nextLine(); //Get adminID

        CustomerProf customer = databaseFile.findFirstProfile(); //Get first profile
        if (customer == null){
            System.out.println("There are no customers in the database."); //There are no customers
        }
        else{
            while(customer != null){
                if (customer.getadminID().equals(adminID)){ //Check customers with given adminID
                    displayCustomerProf(customer); //Display found profile
                    userFound = true; //A user was found
                }
                customer = databaseFile.findNextProfile(); //Find next customer in database
            }

        }

        if(!userFound){
            //No customers were found with the given adminID
            String adminIdString = String.format("%s has not created any users.", adminID);
            System.out.println(adminIdString);
        }
    }

    public void writeToDB(){
        databaseFile.writeAllCustomerProf(); //Write all profiles to database file
    }

    CustomerProf createNewCustomerProf(){
        Scanner in = new Scanner(System.in); //Create Scanner
        boolean valid_float = false; //isValidFloat

        System.out.println("Enter AdminID:");
        String adminID = in.nextLine(); //Get adminID
        System.out.println("Enter FirstName:");
        String firstName = in.nextLine(); //Get firstName
        System.out.println("Enter LastName:");
        String lastName = in.nextLine(); //Get lastName
        System.out.println("Enter Address:");
        String address = in.nextLine(); //Get address
        System.out.println("Enter PhoneNumber:");
        String phone = in.nextLine(); //Get phone
        System.out.println("Enter Income:");
        float income = 0F;
        while(!valid_float){ //Read until user enters valid float
            try{
                income = Float.parseFloat(in.nextLine()); //Convert to float
                valid_float = true; //Valid float found
            }catch(Exception e){
                System.out.println("Please input Income as a float:"); //Prompt user to enter float
            }
        }
        System.out.println("Enter Status:");
        String status = in.nextLine(); //Get Status
        System.out.println("Enter Use:");
        String use = in.nextLine(); //Get Use

        VehicleInfo vehicleInfo = createNewVehicleInfo(); //Create vehicle
        //Return new CusomterProf object
        return new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, vehicleInfo);
    }

    VehicleInfo createNewVehicleInfo(){
        Scanner in = new Scanner(System.in); //Create Scanner
        System.out.println("Enter CarModel:");
        String model = in.nextLine(); //Get model
        System.out.println("Enter Year:");
        String year = in.nextLine(); //Get year
        System.out.println("Enter Type:");
        String carType = in.nextLine(); //Get Type
        System.out.println("Enter Method:");
        String method = in.nextLine(); //Get Method

        return new VehicleInfo(model, year, carType, method); //Create and return vehicle
    }

    public static void main(String[] args) {
        CustomerProfInterface inter = new CustomerProfInterface("test1.txt"); //Create interface object with a fileName
        inter.getUserChoice(); //Call getUserChoice to begin
    }
}
