package com.solvd.laba.block1.task2_oop;

public class DeliveryCostCalculator {
    public static final double INITIAL_COST = Constants.BASE_COST;

    public DeliveryCostCalculator(){
    }

    public static double calculateDeliveryCost(DeliveryOrder order) {
        double distanceCost = order.getDistance()*2;
        double weightCost = order.getOrderWeight()*10;
        double courierCost = order.getCourier().getVehicle().getСoefficient()*10;
        return INITIAL_COST + weightCost + distanceCost + courierCost;
    }
}
