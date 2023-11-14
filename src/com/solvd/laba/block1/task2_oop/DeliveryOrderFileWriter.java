package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.interfaces.IDeliveryOrderFileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class DeliveryOrderFileWriter implements AutoCloseable, IDeliveryOrderFileWriter {

    private FileWriter fileWriter;

    public DeliveryOrderFileWriter(String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
    }

    @Override
    public void write(String string) throws IOException {
        fileWriter.write(string);
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }
}