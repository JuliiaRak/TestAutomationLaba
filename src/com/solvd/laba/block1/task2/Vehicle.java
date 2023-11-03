package com.solvd.laba.block1.task2;

public class Vehicle {
    private VehicleType type;

    public Vehicle(VehicleType type){
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}