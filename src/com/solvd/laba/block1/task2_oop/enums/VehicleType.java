package com.solvd.laba.block1.task2_oop.enums;

public enum VehicleType {
    TRUCK(8),
    CAR(5),
    MOTORCYCLE(4),
    BICYCLE(2);

    private final int coefficient;  // Додаткове поле для зберігання швидкості

    VehicleType(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getСoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return name().toLowerCase() + " (coefficient: " + coefficient + ")";
    }
}

