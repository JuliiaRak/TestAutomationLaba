package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.Role;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

import java.util.Objects;

public class Customer extends Person {
    private Role role = Role.CUSTOMER;
    private CustomLinkedList<Address> addresses;

    public Customer(FullName fullName, String phoneNumber, String email) throws InvalidPhoneNumberException, InvalidEmailException {
        super(fullName, phoneNumber, email);
        this.addresses = new CustomLinkedList<>();
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

    public CustomLinkedList<Address> getAddresses() {
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
        String parentString = super.displayPersonalInformation();
        return parentString;
    }
}
