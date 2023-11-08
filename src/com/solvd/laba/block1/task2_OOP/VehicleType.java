package com.solvd.laba.block1.task2_OOP;

public enum VehicleType {
    CAR(120),
    TRUCK(80),
    MOTORCYCLE(150),
    BICYCLE(20);

    private final int speed;  // Додаткове поле для зберігання швидкості

    VehicleType(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name().toLowerCase() + " (speed: " + speed + ")";
    }
}

