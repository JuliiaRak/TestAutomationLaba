package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

import java.util.Objects;

public class Customer extends Person {
    private Address address;

    public Customer(FullName fullName, String phoneNumber, String email, Address address) throws InvalidPhoneNumberException, InvalidEmailException {
        super(fullName, phoneNumber, email);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getAddress(), customer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddress());
    }

    @Override
    public String toString() {
        String parentString = super.displayPersonalInformation();
        return parentString + "; address: " + address.toString();
    }
}
