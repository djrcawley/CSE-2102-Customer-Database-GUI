public class VehicleInfo {
    //Private Vehicle Details
    private String model;
    private String year;
    private String type;
    private String method;

    //Vehicle Constructor
    VehicleInfo(String carModel, String carYear, String carType, String carMethod){
        model = carModel;
        year = carYear;
        type = carType;
        method = carMethod;
    }

    public String getModel(){
        return model; //Get model
    }

    public String getYear(){
        return year; //Get year
    }

    public String getType(){
        return type; //Get type
    }

    public String getMethod(){
        return method; //Get method
    }

    public void updateModel(String newModel){
        this.model = newModel; //Set model
    }

    public void updateYear(String newYear){
        this.year = newYear; //Set year
    }

    public void updateType(String newType){
        this.type = newType; //Set type
    }

    public void updateMethod(String newMethod){
        this.method = newMethod; //Set method
    }

    public static void main(String[] args) {
        VehicleInfo vehicle1 = new VehicleInfo("Honda Civic", "2021", "Hatchback", "New");
        vehicle1.updateModel("Toyota Forerunner");
        vehicle1.updateYear("2018");
        vehicle1.updateType("SUV");
        vehicle1.updateMethod("Used");
        System.out.println(vehicle1.getModel());
        System.out.println(vehicle1.getYear());
        System.out.println(vehicle1.getType());
        System.out.println(vehicle1.getMethod());
    }
}
