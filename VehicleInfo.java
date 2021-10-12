//package cse-2102-project-1-josh-and-dennis;

public class VehicleInfo {
    String model;
    String year;
    String type;
    String method;

    VehicleInfo(String carModel, String carYear, String carType, String carMethod){
        model = carModel;
        year = carYear;
        type = carType;
        method = carMethod;
    }

    static String getModel(VehicleInfo vehicle){
        return vehicle.model;
    }

    static String getYear(VehicleInfo vehicle){
        return vehicle.year;
    }

    static String getType(VehicleInfo vehicle){
        return vehicle.type;
    }
    
    static String getMethod(VehicleInfo vehicle){
        return vehicle.method;
    }

    static void updateModel(VehicleInfo vehicle, String newModel){
        vehicle.model = newModel;
    }

    static void updateYear(VehicleInfo vehicle, String newYear){
        vehicle.year = newYear;
    }

    static void updateType(VehicleInfo vehicle, String newType){
        vehicle.type = newType;
    }

    static void updateMethod(VehicleInfo vehicle, String newMethod){
        vehicle.method = newMethod;
    }
}
