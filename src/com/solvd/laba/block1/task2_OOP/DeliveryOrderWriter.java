package com.solvd.laba.block1.task2_OOP;

import java.io.FileWriter;
import java.io.IOException;

public class DeliveryOrderWriter implements AutoCloseable {

    private FileWriter fileWriter;

    public DeliveryOrderWriter(String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
    }

    public void write(String string) throws IOException {
        fileWriter.write(string);
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }
}