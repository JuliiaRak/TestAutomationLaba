package com.solvd.laba.block1.task2;

public class DeliveryOrder {
    private Customer sender;
    private Customer recipient;
    private Item item;
    private Courier courier;
    private double distance;

    public DeliveryOrder(Customer sender, Customer recipient, Item item,  Courier courier, double distance) {
        this.sender = sender;
        this.recipient = recipient;
        this.item = item;
        this.courier = courier;
        this.distance = distance;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
