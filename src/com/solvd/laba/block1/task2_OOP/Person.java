package com.solvd.laba.block1.task2_OOP;

import java.util.Objects;

public abstract class Person {
    protected FullName fullName;
    protected String phoneNumber;
    protected String email;

    public Person(FullName fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public abstract void trackDeliveryStatus();

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getFullName(), person.getFullName()) && Objects.equals(getPhoneNumber(), person.getPhoneNumber()) && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getPhoneNumber(), getEmail());
    }

    @Override
    public String toString() {
        return fullName.toString() +
                ", phoneNumber: " + phoneNumber+
                ", email: " + email;
    }
}
