package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.Enums.VehicleType;

public class CouriersRepo {

    static Courier courierWithCar = new Courier(new FullName("Alex", "Yemets"), "0673962558", "alex@gmail.com", VehicleType.CAR);
    static Courier courierWithTruck = new Courier(new FullName("Oleh", "Ovharcyn"), "0973528462", "oleh@gmail.com", VehicleType.TRUCK);
    static Courier courierWithMoto = new Courier(new FullName("Stepan", "Bys"), "0672605773", "stepan@gmail.com", VehicleType.MOTORCYCLE);
    static Courier courierWithBicycle = new Courier(new FullName("Denys", "Derh"), "0982640638", "denys@gmail.com", VehicleType.BICYCLE);
    static public Courier[] couriers = {courierWithCar, courierWithTruck, courierWithMoto, courierWithBicycle};

}
