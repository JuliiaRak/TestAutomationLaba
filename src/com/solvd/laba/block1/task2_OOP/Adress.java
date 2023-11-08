package com.solvd.laba.block1.task2_OOP;

public class Adress {
    private String city;
    private String street;
    private String building;

    public Adress(String city, String street, String building){
        this.city = city;
        this.street = street;
        this.building = building;
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
        return "Adress: " +
                "city " + city+
                ", street " + street +
                ", building " + building;
    }
}
