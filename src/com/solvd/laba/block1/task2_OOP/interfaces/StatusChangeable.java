package com.solvd.laba.block1.task2_OOP.interfaces;

import com.solvd.laba.block1.task2_OOP.enums.DeliveryStatus;

public interface StatusChangeable {
    void changeStatus(DeliveryStatus newStatus);
}