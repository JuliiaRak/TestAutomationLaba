package com.solvd.laba.block1.task2_oop.interfaces;

@FunctionalInterface
public
interface TriFunctionOrderProcessor<T, U, V, R> {
    R apply(T t, U u, V v);
}
