package com.solvd.laba.block1.task2_oop.enums;

public enum DeliveryStatus {
    PENDING (0),        // Очікує на обробку
    PROCESSING (1),     // Обробляється
    DELIVERING (2), // Вийшов на доставку
    DELIVERED (3),      // Доставлено
    FAILED (4),         // Невдала спроба доставки
    RETURNED (5),       // Повернено
    CANCELED (6);        // Скасовано

    private final int number;

    DeliveryStatus(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static DeliveryStatus getByNumber(int number) {
        for (DeliveryStatus status : values()) {
            if (status.getNumber() == number) {
                return status;
            }
        }
        return PENDING;
    }
}