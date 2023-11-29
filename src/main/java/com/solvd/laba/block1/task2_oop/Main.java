package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.repos.CouriersRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final DeliveryService DELIVERY_SERVICE = new DeliveryService();

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) {
        LOGGER.info("PROGRAM STARTED");

        // Виведення інформації в консоль
        DELIVERY_SERVICE.printInfo(() -> {
            DeliveryOrder order = DELIVERY_SERVICE.createNewOrder();
            double cost = DELIVERY_SERVICE.getDeliveryCostCalculator().calculateDeliveryCost(order);
            System.out.printf(order.toString());
            System.out.println("Delivery cost: " + cost);
        });

        // Виведення інформації в файл
        DELIVERY_SERVICE.printInfo(() -> {
            DeliveryOrder order = DELIVERY_SERVICE.createNewOrder();
            double cost = DELIVERY_SERVICE.getDeliveryCostCalculator().calculateDeliveryCost(order);
            try (DeliveryOrderFileWriter orderWriter = new DeliveryOrderFileWriter("orders.txt")) {
                orderWriter.write(order.toString());
                orderWriter.write("Delivery cost: " + cost);
            } catch (IOException e) {
                LOGGER.error("Error reading and writing to file in DeliveryService class" + e.getMessage());
            }
        });
        System.out.println();

        DeliveryOrder myOrder = DELIVERY_SERVICE.createNewOrder();
        DELIVERY_SERVICE.processCustomOrder(myOrder, order -> {
                System.out.println("Custom lambda order processing: " + order.getClass() + "\n");
            }
        );

        useLambdas();
        LOGGER.info("PROGRAM ENDED\n");
    }

    public static void useLambdas(){
        List<Courier> couriers = CouriersRepo.getCouriers();

        // використання Function
        // Збільшуємо рейтинг кур'єрів на 1
        Function<Courier, Courier> increaseRating = courier -> {
            courier.setDeliveryRating(courier.getDeliveryRating() + 1);
            return  courier;
        };
        List<Courier> updatedCouriers = updateCouriers(couriers, increaseRating);
        updatedCouriers.forEach(courier -> System.out.println(courier));
        System.out.println();

        // використання Predicate
        // фільтруємо курєрів по рейтингу >= 4.5
        Predicate<Courier> filterHighRatedCouriers = courier -> courier.getDeliveryRating() >= 4.5;
        List<Courier> couriersFilteredByRating = filterCouriersByRating(updatedCouriers, filterHighRatedCouriers);
        couriersFilteredByRating.forEach(courier -> System.out.println(courier));
        System.out.println();
    }

    public static List<Courier> updateCouriers(List<Courier> couriers, Function<Courier, Courier> updateFunction) {
        for (int i = 0; i < couriers.size(); i++) {
            couriers.set(i, updateFunction.apply(couriers.get(i)));
        }
        return couriers;
    }

    public static List<Courier> filterCouriersByRating(List<Courier> couriers, Predicate<Courier> predicate) {
        List<Courier> filteredCouriers = new ArrayList<>();

        for (Courier courier : couriers) {
            if (predicate.test(courier)) {
                filteredCouriers.add(courier);
            }
        }

        return filteredCouriers;
    }

}
