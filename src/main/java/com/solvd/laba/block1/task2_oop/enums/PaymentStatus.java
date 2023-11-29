package com.solvd.laba.block1.task2_oop.enums;

public enum PaymentStatus {
    PENDING (0),
    PAID (1),
    FAILED (2);

    private final int number;

    PaymentStatus(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static PaymentStatus getByNumber(int number) {
        for (PaymentStatus status : values()) {
            if (status.getNumber() == number) {
                return status;
            }
        }
        return PENDING;
    }
}
