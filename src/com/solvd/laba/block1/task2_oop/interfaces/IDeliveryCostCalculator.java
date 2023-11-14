package com.solvd.laba.block1.task2_oop.interfaces;

import com.solvd.laba.block1.task2_oop.DeliveryOrder;
import com.solvd.laba.block1.task2_oop.exceptions.DeliveryCostCalculationException;

public interface IDeliveryCostCalculator {
    double calculateDeliveryCost(DeliveryOrder order) throws DeliveryCostCalculationException;
}
