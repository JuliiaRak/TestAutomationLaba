package com.solvd.laba.block1.task2;

public class Courier {
    private String name;
    private Vehicle vehicle;

    public Courier(String name, Vehicle vehicle){
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
