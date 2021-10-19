package com;
import java.io.*;
import java.util.*;
import java.lang.*;

public class CustomerProfInterface {
    CustomerProfInterface(String file){
        File fileName = new File(file);
    }
    public void getUserChoice(){
        //TODO
    }
    public void deleteCustomerProf(){

    }
    public void findCustomerProf(){
        //TODO
    }
    public void updateCustomerProf(){
        //TODO
    }
    public void displayCustomerProf(){
        //TODO
    }
    public void displayAllCustomerProf(){
        //TODO
    }
    public void writeToDB(){
        //TODO
    }
    CustomerProf createNewCustomerProf(){
        Scanner in = new Scanner(System.in);

        String adminID = in.nextLine();
        String firstName = in.nextLine();
        String lastName = in.nextLine();
        String address = in.nextLine();
        String phone = in.nextLine();
        float income = Float.parseFloat(in.nextLine());
        String status = in.nextLine();
        String use = in.nextLine();

        String vehicle = in.nextLine();
        String[] vehicleArray = vehicle.split(" ");
        VehicleInfo vehicleInfo = new VehicleInfo(vehicleArray[0], vehicleArray[1], vehicleArray[2], vehicleArray[3]);

        return new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, vehicleInfo);
    }
    VehicleInfo createNewVehicleInfo(){
        Scanner in = new Scanner(System.in);

        String model = in.nextLine();
        String year = in.nextLine();
        String carType = in.nextLine();
        String method = in.nextLine();

        return new VehicleInfo(model, year, carType, method);
    }
}
