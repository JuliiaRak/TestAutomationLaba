package com.solvd.laba.block1.task5_threads;

// Mocked Connection class
public class Connection {
    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Connection " + id;
    }
}
