package com.solvd.laba.block1.task2_OOP;

public class DeliveryCostCalculator {
    public final Double initialCost = 50.0;

    public DeliveryCostCalculator(){
    }

    public double calculateDeliveryCost(DeliveryOrder order) {
        return initialCost + order.item.getWeight()*10 + order.distance*2 + order.courier.getVehicle().getСoefficient()*10;
    }
}
