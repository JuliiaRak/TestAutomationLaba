package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;
import com.solvd.laba.block1.task2_oop.repos.CouriersRepo;
import org.apache.commons.lang3.function.TriFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

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
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);
            System.out.printf(order.toString());
            System.out.println("Delivery cost: " + cost);
        });

        // Виведення інформації в файл
        DELIVERY_SERVICE.printInfo(() -> {
            DeliveryOrder order = DELIVERY_SERVICE.createNewOrder();
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);
            try (DeliveryOrderFileWriter orderWriter = new DeliveryOrderFileWriter("orders.txt")) {
                orderWriter.write(order.toString());
                orderWriter.write("Delivery cost: " + cost);
            } catch (IOException e) {
                LOGGER.error("Error reading and writing to file in DeliveryService class" + e.getMessage());
            }
        });
        System.out.println();

        DeliveryOrder myOrder = DELIVERY_SERVICE.createNewOrder();
        DELIVERY_SERVICE.processCustomOrder(myOrder, (order, author, task) -> {
                System.out.println("Custom lambda order processing in class: " + order.getClass()
                        + ", author: " + author + ", task: " + task  + "\n");
            }
        );

        TriFunction<String, Integer, Double, String> TriFunctionOrderProcessor = (productName, quantity, price) -> {
            double totalCost = quantity * price;
            return "(myTriFunction interface) PRODUCT: " + productName + ", quantity: " + quantity + ", total cost: " + totalCost;
        };
        String result = TriFunctionOrderProcessor.apply("Laptop", 2, 1200.0);
        System.out.println(result);
        System.out.println();

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

        // використання Consumer
        // створюємо кастомне замовлення
        Supplier<DeliveryOrder> createOrderSupplier = () -> {
            DeliveryOrder customDeliveryOrder = DELIVERY_SERVICE.createNewOrder();
            try {
                customDeliveryOrder.setSender(new Customer(new FullName("Julia", "Rak"), "0980207334", "juliarak@ukr.net"));
            } catch (InvalidPhoneNumberException | InvalidEmailException e) {
                LOGGER.error(e.getMessage());
            }
            return customDeliveryOrder;
        };
        DeliveryOrder customDeliveryOrder = createCustomOrder(createOrderSupplier);

        // використання Consumer
        // обробляємо замовлення
        Consumer<DeliveryOrder> processOrderConsumer1 = order -> {
            System.out.println("Processing order from: " + order.getSender() + " to " + order.getRecipient());
        };
        processOrder(customDeliveryOrder, processOrderConsumer1);

        // використання UnaryOperator
        // додаємо знижку до замовлення
        UnaryOperator<Double> calculateDiscountUnaryOperator = cost -> cost * 0.9;
        double costWithDiscount = applyDiscount(customDeliveryOrder, calculateDiscountUnaryOperator);
        System.out.println(costWithDiscount);
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

    public static DeliveryOrder createCustomOrder(Supplier<DeliveryOrder> createOrderSupplier) {
        return createOrderSupplier.get();
    }

    public static void processOrder(DeliveryOrder order, Consumer<DeliveryOrder> processOrderConsumer) {
        processOrderConsumer.accept(order);
    }

    public static double applyDiscount(DeliveryOrder order, UnaryOperator<Double> calculateDiscountUnaryOperator) {
        double cost = DeliveryCostCalculator.calculateDeliveryCost(order);
        return calculateDiscountUnaryOperator.apply(cost);
    }
}
