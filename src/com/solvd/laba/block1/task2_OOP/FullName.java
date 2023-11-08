package com.solvd.laba.block1.task2_OOP;

import java.util.Objects;

public class FullName {
    private String name;
    private String surname;

    public FullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullName fullName)) return false;
        return Objects.equals(getName(), fullName.getName()) && Objects.equals(getSurname(), fullName.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public String toString() {
        return name + ' ' + surname;
    }
}
