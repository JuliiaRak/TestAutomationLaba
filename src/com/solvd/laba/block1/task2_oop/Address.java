package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.InvalidAddressException;

public class Address {
    private String city;
    private String street;
    private String building;

    public Address(String city, String street, String building) throws InvalidAddressException {
        if (isValidAddress(city, street, building)) {
            this.city = city;
            this.street = street;
            this.building = building;
        } else {
            throw new InvalidAddressException("Invalid address format");
        }
    }

    private boolean isValidAddress(String city, String street, String building) {
        return city != null && !city.isEmpty() &&
                street != null && !street.isEmpty() &&
                building != null && !building.isEmpty();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return city + " city, " +
                street + " street, " +
                building + " building";
    }
}
