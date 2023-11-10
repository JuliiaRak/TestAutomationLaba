package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.Enums.VehicleType;
import com.solvd.laba.block1.task2_OOP.Interfaces.Deliverable;
import com.solvd.laba.block1.task2_OOP.Interfaces.Trackable;

public class Courier extends Person implements Trackable, Deliverable {
    private VehicleType vehicle;

    public Courier(FullName fullName, String phoneNumber, String email, VehicleType vehicle) {
        super(fullName, phoneNumber, email);
        this.vehicle = vehicle;
    }

    @Override
    public void trackDeliveryStatus() {
        System.out.println("Tracking delivery status as a courier...");
    }

    public VehicleType getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleType vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        String parentString = super.toString();
        return parentString + ", address: " + vehicle.toString();
    }

    @Override
    public void deliver() {

    }
}
