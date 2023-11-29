package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.ItemType;

public class Item {
    private ItemType itemType;
    private String name;
    private double weight;

    public Item(ItemType itemType, String name, double weight) {
        this.itemType = itemType;
        this.name = name;
        this.weight = weight;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
