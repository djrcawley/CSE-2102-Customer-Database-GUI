package com;

public class CustomerProf {
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    private VehicleInfo vehicleInfo;

    CustomerProf(String userID, String first, String last, String userAddress, String phoneNum, float userIncome, String userStatus, String customerUse, VehicleInfo userVehicle) {
        adminID = userID;
        firstName = first;
        lastName = last;
        address = userAddress;
        phone = phoneNum;
        income = userIncome;
        status = userStatus;
        use = customerUse;
        vehicleInfo = userVehicle;
    }

    public String getadminID(){
        return adminID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public float getIncome(){
        return income;
    }

    public String getStatus(){
        return status;
    }

    public String getUse(){
        return use;
    }

    public VehicleInfo getVehicleInfo(){
        return vehicleInfo;
    }

    public void updateFirstName(String first){
        this.firstName = first;
    }

    public void updateLastName(String last){
        this.lastName = last;
    }

    public void updateAddress(String userAddress){
        this.address = userAddress;
    }

    public void updatePhone(String phoneNum){
        this.phone = phoneNum;
    }

    public void updateIncome(float userIncome){
        this.income = userIncome;
    }

    public void updateStatus(String userStatus){
        this.status = userStatus;
    }

    public void updateVehicleInfo(VehicleInfo userVehicle){
        this.vehicleInfo = userVehicle;
    }

    public static void main(String[] args) {
        VehicleInfo mock_vehicle = new VehicleInfo("Honda Civic", "2021", "Hatchback", "FWD");
        VehicleInfo mock_vehicle1 = new VehicleInfo("Toyota", "2021", "Hatchback", "FWD");
        VehicleInfo mock_vehicle2 = new VehicleInfo("Ford", "2021", "Hatchback", "FWD");
        CustomerProf mock_Customer = new CustomerProf("007", "James", "Bond", "2075 Hillside Rd, Storrs, CT 06269", "8675309", (float)10000, "Status", "Use", mock_vehicle);

        System.out.println(mock_Customer.getVehicleInfo().getModel());
        mock_Customer.updateVehicleInfo(mock_vehicle1);
        System.out.print(mock_Customer.getVehicleInfo().getModel());

    }
}