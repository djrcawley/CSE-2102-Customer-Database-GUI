package com;

public class VehicleInfo {
    private String model;
    private String year;
    private String type;
    private String method;

    VehicleInfo(String carModel, String carYear, String carType, String carMethod){
        model = carModel;
        year = carYear;
        type = carType;
        method = carMethod;
    }

    public String getModel(){
        return model;
    }

    public String getYear(){
        return year;
    }

    public String getType(){
        return type;
    }

    public String getMethod(){
        return method;
    }

    public void updateModel(String newModel){
        this.model = newModel;
    }

    public void updateYear(String newYear){
        this.year = newYear;
    }

    public void updateType(String newType){
        this.type = newType;
    }

    public void updateMethod(String newMethod){
        this.method = newMethod;
    }
}
