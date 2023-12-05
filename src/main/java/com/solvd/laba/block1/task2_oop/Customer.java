package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.Role;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends Person {
    private Role role = Role.CUSTOMER;
    private List<Address> addresses;

    private Customer(FullName fullName) {
        super(fullName);
        this.addresses = new ArrayList<>();
    }

    public Customer(FullName fullName, String phoneNumber, String email) throws InvalidPhoneNumberException, InvalidEmailException {
        super(fullName, phoneNumber, email);
        this.addresses = new ArrayList<>();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getAddresses(), customer.getAddresses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddresses());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
