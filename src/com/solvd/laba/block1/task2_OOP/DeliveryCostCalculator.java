package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.Interfaces.CostCalculatable;

public class DeliveryCostCalculator implements CostCalculatable {
    public double initialCost = Constants.BASE_COST;

    public DeliveryCostCalculator(){
    }

    @Override
    public double calculateDeliveryCost(DeliveryOrder order) {
        return initialCost + order.item.getWeight()*10 + order.distance*2 + order.courier.getVehicle().getСoefficient()*10;
    }

}
