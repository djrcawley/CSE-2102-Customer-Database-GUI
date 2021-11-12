public class CustomerProf {
    //Private Cusomter Details
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    private VehicleInfo vehicleInfo;

    //Customer Constructor
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
        return adminID; //Get adminID
    }

    public String getFirstName(){
        return firstName; //Get firstName
    }

    public String getLastName(){
        return lastName; //Get lastName
    }

    public String getAddress(){
        return address; //Get address
    }

    public String getPhone(){
        return phone; //Get phone
    }

    public float getIncome(){
        return income; //Get income
    }

    public String getStatus(){
        return status; //Get status
    }

    public String getUse(){
        return use; //Get use
    }

    public VehicleInfo getVehicleInfo(){
        return vehicleInfo; //Get vehicleInfo
    }

    public void updateFirstName(String first){
        this.firstName = first; //Set firstName
    }

    public void updateLastName(String last){
        this.lastName = last; //Set lastName
    }

    public void updateAddress(String userAddress){
        this.address = userAddress; //Set address
    }

    public void updatePhone(String phoneNum){
        this.phone = phoneNum; //Set phone
    }

    public void updateIncome(float userIncome){
        this.income = userIncome; //Set income
    }

    public void updateStatus(String userStatus){
        this.status = userStatus;//Set status
    }

    public void updateUse(String intendedUse){
        this.use = intendedUse; //Set use
    }

    public void updateVehicleInfo(VehicleInfo userVehicle){
        this.vehicleInfo = userVehicle; //Set vehicleInfo
    }

    public static void main(String[] args) {
        VehicleInfo mock_vehicle = new VehicleInfo("Honda Civic", "2021", "Hatchback", "FWD");
        VehicleInfo mock_vehicle1 = new VehicleInfo("Toyota", "2021", "Hatchback", "FWD");
        CustomerProf mock_Customer = new CustomerProf("007", "James", "Bond", "2075 Hillside Rd, Storrs, CT 06269", "8675309", (float)10000, "Status", "Use", mock_vehicle);

        System.out.println(mock_Customer.getVehicleInfo().getModel());
        mock_Customer.updateVehicleInfo(mock_vehicle1);
        mock_Customer.updateFirstName("John");
        mock_Customer.updateLastName("Smith");
        mock_Customer.updateAddress("123 Sesame Street");
        mock_Customer.updatePhone("12345678");
        System.out.println(mock_Customer.getVehicleInfo().getModel());
        System.out.println(mock_Customer.getLastName());
        System.out.println(mock_Customer.getFirstName());
        System.out.println(mock_Customer.getAddress());
        System.out.println(mock_Customer.getPhone());
    }
}