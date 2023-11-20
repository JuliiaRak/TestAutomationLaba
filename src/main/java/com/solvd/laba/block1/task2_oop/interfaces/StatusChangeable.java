package com.solvd.laba.block1.task2_oop.interfaces;

import com.solvd.laba.block1.task2_oop.enums.DeliveryStatus;

public interface StatusChangeable {
    void changeStatus(DeliveryStatus newStatus);
}