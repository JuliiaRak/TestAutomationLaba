package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.DeliveryStatus;
import com.solvd.laba.block1.task2_oop.enums.PaymentStatus;

public final class Constants {
    public static final double BASE_COST = 50.0;
    public static final DeliveryStatus DEFAULT_DELIVERY_STATUS = DeliveryStatus.PENDING;
    public static final PaymentStatus DEFAULT_PAYMENT_STATUS = PaymentStatus.PENDING;

    private Constants() {
    }
}