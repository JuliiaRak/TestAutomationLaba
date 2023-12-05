package com.solvd.laba.block1.task2_oop.repos;

import com.solvd.laba.block1.task2_oop.Courier;
import com.solvd.laba.block1.task2_oop.DeliveryService;
import com.solvd.laba.block1.task2_oop.FullName;
import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class CouriersRepo {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    private static Map<VehicleType, List<Courier>> courierMap = new HashMap<>();
    private static Courier courierWithCar;
    private static Courier courierWithTruck;
    private static Courier courierWithMoto;
    private static Courier courierWithBicycle;

    static {
        try {
            courierWithCar = new Courier(new FullName("Alex", "Yemets"), "+380673962558", "alex@gmail.com", VehicleType.CAR, 4.5);
            courierWithTruck = new Courier(new FullName("Oleh", "Ovharcyn"), "+380973528462", "oleh@gmail.com", VehicleType.TRUCK, 4.0);
            courierWithMoto = new Courier(new FullName("Stepan", "Bys"), "+380672605773", "stepan@gmail.com", VehicleType.MOTORCYCLE, 3.5);
            courierWithBicycle = new Courier(new FullName("Denys", "Derh"), "+380982640638", "denys@gmail.com", VehicleType.BICYCLE, 3.0);
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

    public static List<Courier> getCouriers() {
        return courierMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<Courier> getCouriers(VehicleType vehicleType){
        return courierMap.get(vehicleType);
    }

    public static Optional<Courier> findFirstFreeCourierByType(VehicleType vehicleType) {
        return courierMap.values().stream()
                .flatMap(List::stream)
                .filter(courier -> courier.getVehicle() == vehicleType && courier.getIsFree())
                .findFirst();
    }

    public static List<Courier> sortedCouriersByRating() {
        return courierMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingDouble(Courier::getDeliveryRating).reversed())
                .collect(Collectors.toList());
    }
}
