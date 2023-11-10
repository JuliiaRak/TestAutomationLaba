package com.solvd.laba.block1.task2_OOP.Enums;

public enum DeliveryStatus {
    PENDING,        // Очікує на обробку
    PROCESSING,     // Обробляється
    DELIVERING, // Вийшов на доставку
    DELIVERED,      // Доставлено
    FAILED,         // Невдала спроба доставки
    RETURNED,       // Повернено
    CANCELED        // Скасовано
}