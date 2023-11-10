package com.solvd.laba.block1.task2_OOP.Interfaces;

import com.solvd.laba.block1.task2_OOP.Enums.DeliveryStatus;

public interface StatusChangeable {
    void changeStatus(DeliveryStatus newStatus);
}