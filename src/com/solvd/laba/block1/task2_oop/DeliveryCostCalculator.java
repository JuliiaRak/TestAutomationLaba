package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.DeliveryCostCalculationException;

public class DeliveryCostCalculator {
    public static double initialCost = Constants.BASE_COST;

    public static double calculateDeliveryCost(DeliveryOrder order) throws DeliveryCostCalculationException {
        try {
            double distanceCost = order.getDistance()*2;
            double weightCost = order.getItem().getWeight()*10;
            double courierCost = order.getCourier().getVehicle().getСoefficient()*10;
            return initialCost + weightCost + distanceCost + courierCost;
        } catch (Exception e) {
            throw new DeliveryCostCalculationException("Error calculating delivery cost: " + e.getMessage());
        }
    }
}
