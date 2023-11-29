package com.solvd.laba.block1.task2_oop.interfaces;

import com.solvd.laba.block1.task2_oop.exceptions.ObjectNotFoundExeption;
import java.io.IOException;

@FunctionalInterface
public interface Printer {
    void printInfo() throws IOException, ObjectNotFoundExeption;
}
