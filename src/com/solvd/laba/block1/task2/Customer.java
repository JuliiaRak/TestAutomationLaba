package com.solvd.laba.block1.task2;

public class Customer {
    private FullName fullName;
    private Adress address;

    public Customer(FullName fullName, Adress address) {
        this.fullName = fullName;
        this.address = address;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }
}
