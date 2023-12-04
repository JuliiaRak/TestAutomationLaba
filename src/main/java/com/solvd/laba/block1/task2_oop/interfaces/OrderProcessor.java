package com.solvd.laba.block1.task2_oop.interfaces;

@FunctionalInterface
public interface OrderProcessor<T, U> {
    void processOrder(T order, U author, U task);
}
