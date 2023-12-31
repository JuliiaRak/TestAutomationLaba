package com.solvd.laba.block1.task2_oop.repos;

import com.solvd.laba.block1.task2_oop.DeliveryService;
import com.solvd.laba.block1.task2_oop.Item;
import com.solvd.laba.block1.task2_oop.enums.ItemType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepo {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    private List<Item> items = new ArrayList<>();

    public ItemsRepo(){
        Item item1 = new Item(ItemType.ELECTRONICS, "Laptop", 2.5);
        Item item2 = new Item(ItemType.CLOTHING, "Shirt", 0.5);
        items.add(item1);
        items.add(item2);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
