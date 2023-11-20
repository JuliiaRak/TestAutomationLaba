package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.ObjectNotFoundExeption;
import com.solvd.laba.block1.task2_oop.interfaces.IDeliveryCostCalculator;

import java.util.LinkedList;

public class DeliveryCostCalculator implements IDeliveryCostCalculator {
    public final double initialCost = Constants.BASE_COST;

    public DeliveryCostCalculator(){
    }

    public double calculateDeliveryCost(DeliveryOrder order) throws ObjectNotFoundExeption {
        if (order == null) {
            throw new ObjectNotFoundExeption("Error calculating delivery cost (order can not be null)");
        } else {
            double distanceCost = order.getDistance()*2;
            double weightCost = order.getOrderWeight()*10;
            double courierCost = order.getCourier().getVehicle().getСoefficient()*10;
            return initialCost + weightCost + distanceCost + courierCost;
        }
    }
}
