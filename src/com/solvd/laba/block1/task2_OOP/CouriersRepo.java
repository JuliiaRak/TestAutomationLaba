package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.enums.VehicleType;
import com.solvd.laba.block1.task2_OOP.exceptions.InvalidAddressException;
import com.solvd.laba.block1.task2_OOP.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_OOP.exceptions.InvalidPhoneNumberException;

public class CouriersRepo {

    static Courier courierWithCar;
    static Courier courierWithTruck;
    static Courier courierWithMoto;
    static Courier courierWithBicycle;

    static {
        try {
            courierWithCar = new Courier(new FullName("Alex", "Yemets"), "+380673962558", "alex@gmail.com", VehicleType.CAR);
            courierWithTruck = new Courier(new FullName("Oleh", "Ovharcyn"), "+380973528462", "oleh@gmail.com", VehicleType.TRUCK);
            courierWithMoto = new Courier(new FullName("Stepan", "Bys"), "+380672605773", "stepan@gmail.com", VehicleType.MOTORCYCLE);
            courierWithBicycle = new Courier(new FullName("Denys", "Derh"), "+380982640638", "denys@gmail.com", VehicleType.BICYCLE);
            } catch (InvalidPhoneNumberException e) {
                System.err.println(e.getMessage());
            } catch (InvalidEmailException e) {
                System.err.println(e.getMessage());
            }
    }

    public static Courier[] getCouriers(){
        Courier[] couriers = {courierWithCar, courierWithTruck, courierWithMoto, courierWithBicycle};
        return couriers;
    }
}
