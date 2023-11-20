package com.solvd.laba.block1.task2_oop.repos;

import com.solvd.laba.block1.task2_oop.Courier;
import com.solvd.laba.block1.task2_oop.DeliveryService;
import com.solvd.laba.block1.task2_oop.FullName;
import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouriersRepo {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    private static Map<VehicleType, List<Courier>> courierMap = new HashMap<>();
    private static Courier courierWithCar;
    private static Courier courierWithTruck;
    private static Courier courierWithMoto;
    private static Courier courierWithBicycle;

    static {
        try {
            courierWithCar = new Courier(new FullName("Alex", "Yemets"), "+380673962558", "alex@gmail.com", VehicleType.CAR);
            courierWithTruck = new Courier(new FullName("Oleh", "Ovharcyn"), "+380973528462", "oleh@gmail.com", VehicleType.TRUCK);
            courierWithMoto = new Courier(new FullName("Stepan", "Bys"), "+380672605773", "stepan@gmail.com", VehicleType.MOTORCYCLE);
            courierWithBicycle = new Courier(new FullName("Denys", "Derh"), "+380982640638", "denys@gmail.com", VehicleType.BICYCLE);
            } catch (InvalidPhoneNumberException | InvalidEmailException e) {
                LOGGER.error(e.getMessage());
            }
        addCourier(courierWithCar);
        addCourier(courierWithTruck);
        addCourier(courierWithMoto);
        addCourier(courierWithBicycle);
    }

    public static void addCourier(Courier courier) {
        VehicleType vehicleType = courier.getVehicle();

        // Перевірка, чи вже існує запис для даного VehicleType
        if (courierMap.containsKey(vehicleType)) {
            courierMap.get(vehicleType).add(courier);
        } else {
            List<Courier> courierList = new ArrayList<>();
            courierList.add(courier);
            courierMap.put(vehicleType, courierList);
        }
    }

    public static List<Courier> getCouriers(VehicleType vehicleType){
        return courierMap.get(vehicleType);
    }
}
