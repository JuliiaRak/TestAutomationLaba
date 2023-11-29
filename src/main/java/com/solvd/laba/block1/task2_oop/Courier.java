package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.Role;
import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

public class Courier extends Person {
    private Role role = Role.COURIER;
    private VehicleType vehicle;
    private Boolean isFree = true;
    private double deliveryRating;

    public Courier(FullName fullName, String phoneNumber, String email, VehicleType vehicle, double deliveryRating) throws InvalidPhoneNumberException, InvalidEmailException {
        super(fullName, phoneNumber, email);
        this.vehicle = vehicle;
        this.deliveryRating = deliveryRating;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public double getDeliveryRating() {
        return deliveryRating;
    }

    public void setDeliveryRating(double deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    @Override
    public String toString() {
        return super.toString() + "; vehicle: " + vehicle +
                "; rating: " + deliveryRating;
    }


}
