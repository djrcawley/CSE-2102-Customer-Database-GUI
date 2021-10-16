package com;
import java.util.ArrayList;

public class CustomerProfDB {
    private int numCustomer;
    private int currentCustomerIndex;
    private String fileName;
    ArrayList<CustomerProf> customerList = new ArrayList<>();

    public void insertNewProfile(CustomerProf customer){
        customerList.add(customer);
        numCustomer++;
    }

    public boolean deleteProfile(String adminID, String lastName){
        //Will likely need to edited with First & Next Profile methods
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

    public CustomerProf findFirstProfile(){
        //TODO
        return null;
    }

    public CustomerProf findNextProfile(){
        //TODO
        return null;
    }

    public void writeAllCustomerProf(){
        //TODO
    }

    public void initializeDatabase(String file){
        //TODO
    }

    private void print_list(){ //For Testing Purposes
        System.out.println(customerList);
        for(CustomerProf customer : customerList)
        {
            System.out.println(customer.getFirstName());
        }
        System.out.println(numCustomer);
    }

    public static void main(String[] args) {
        VehicleInfo vehicle_1 = new VehicleInfo("Honda Civic", "2021", "Hatchback", "FWD");
        VehicleInfo vehicle_2 = new VehicleInfo("Toyota Prius", "2021", "Hatchback", "FWD");
        CustomerProf customer_1 = new CustomerProf("007", "James", "Bond", "2075 Hillside Rd, Storrs, CT 06269", "8675309", (float)10000, "Status", "Use", vehicle_1);
        CustomerProf customer_2 = new CustomerProf("001", "Dennis", "Cawley", "123 Sesame Street", "1234567890", (float)10000, "Status_1", "Use_1", vehicle_2);

        CustomerProfDB list = new CustomerProfDB();
        list.insertNewProfile(customer_1);
        list.insertNewProfile(customer_2);
        list.insertNewProfile(customer_1);
        list.print_list();
        list.deleteProfile("007", "Bond");
        list.print_list();
    }
}
