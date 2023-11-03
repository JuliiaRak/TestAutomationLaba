package com.solvd.laba.block1.task2;

public class DeliveryCostCalculator {
    public Double initialCost = 100.0;

    public DeliveryCostCalculator(){
    }

    public DeliveryCostCalculator(double initialCost){
        this.initialCost = initialCost;
    }

    public double calculateDeliveryCost(DeliveryOrder order) {
        return initialCost;
    }
}
