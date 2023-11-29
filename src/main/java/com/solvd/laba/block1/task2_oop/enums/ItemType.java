package com.solvd.laba.block1.task2_oop.enums;

public enum ItemType {
    ELECTRONICS ("Electronics"),
    CLOTHING ("Clothing"),
    BOOKS ("Books"),
    FOOD ("Food");

    private final String itemTypeName;

    ItemType(String itemTypeName){
        this.itemTypeName = itemTypeName;
    }

    public String getItemTypeName(){
        return itemTypeName;
    }
}
