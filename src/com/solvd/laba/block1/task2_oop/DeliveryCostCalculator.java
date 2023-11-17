package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.DeliveryCostCalculationException;
import com.solvd.laba.block1.task2_oop.interfaces.IDeliveryCostCalculator;

public class DeliveryCostCalculator implements IDeliveryCostCalculator {
    public final double initialCost = Constants.BASE_COST;

    public DeliveryCostCalculator(){
    }

    public double calculateDeliveryCost(DeliveryOrder order) throws DeliveryCostCalculationException {
        if (order == null) {
            throw new DeliveryCostCalculationException("Error calculating delivery cost (order can not be null)");
        } else {
            double distanceCost = order.getDistance()*2;
            double weightCost = order.getItem().getWeight()*10;
            double courierCost = order.getCourier().getVehicle().getСoefficient()*10;
            return initialCost + weightCost + distanceCost + courierCost;
        }
    }
}
