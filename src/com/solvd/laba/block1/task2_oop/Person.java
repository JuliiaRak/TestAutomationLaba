package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Person {
    protected FullName fullName;
    protected String phoneNumber;
    protected String email;

    public Person(FullName fullName, String phoneNumber, String email) throws InvalidPhoneNumberException, InvalidEmailException {
        this.fullName = fullName;
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new InvalidPhoneNumberException("Invalid phone number format");
        }
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("Invalid email format");
        }
    }

    public static boolean isValidPhoneNumber(String number) {
        String phoneRegex = "^\\+380\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(number).matches();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
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
