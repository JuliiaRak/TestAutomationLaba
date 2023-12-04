package com.solvd.laba.block1.task2_oop.interfaces;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
