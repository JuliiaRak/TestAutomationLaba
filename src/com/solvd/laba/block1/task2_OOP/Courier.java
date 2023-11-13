package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.enums.VehicleType;
import com.solvd.laba.block1.task2_OOP.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_OOP.exceptions.InvalidPhoneNumberException;
import com.solvd.laba.block1.task2_OOP.interfaces.Deliverable;
import com.solvd.laba.block1.task2_OOP.interfaces.Trackable;

public class Courier extends Person implements Trackable, Deliverable {
    private VehicleType vehicle;

    public Courier(FullName fullName, String phoneNumber, String email, VehicleType vehicle) throws InvalidPhoneNumberException, InvalidEmailException {
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
