package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

public class Courier extends Person {
    private VehicleType vehicle;
    private Boolean isFree = true;

    public Courier(FullName fullName, String phoneNumber, String email, VehicleType vehicle) throws InvalidPhoneNumberException, InvalidEmailException {
        super(fullName, phoneNumber, email);
        this.vehicle = vehicle;
    }

    public VehicleType getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleType vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setNotFree() {
        this.isFree = false;
    }

    @Override
    public String toString() {
        String parentString = super.displayPersonalInformation();
        return parentString + "; vehicle: " + vehicle.toString();
    }

}
