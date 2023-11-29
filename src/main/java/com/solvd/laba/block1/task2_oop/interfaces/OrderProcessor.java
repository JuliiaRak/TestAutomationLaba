package com.solvd.laba.block1.task2_oop.interfaces;

import com.solvd.laba.block1.task2_oop.DeliveryOrder;

@FunctionalInterface
public interface OrderProcessor {
    void processOrder(DeliveryOrder order);
}
