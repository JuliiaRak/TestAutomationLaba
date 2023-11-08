package com.solvd.laba.block1.task2_OOP;

public class DeliveryOrder {
    protected Customer sender;
    protected Customer recipient;
    protected Item item;
    protected Courier courier;
    protected double distance;
    protected DeliveryStatus deliveryStatus;

    public DeliveryOrder(Customer sender, Customer recipient, Item item,
                         Courier courier, double distance, DeliveryStatus deliveryStatus) {
        this.sender = sender;
        this.recipient = recipient;
        this.item = item;
        this.courier = courier;
        this.distance = distance;
        this.deliveryStatus = deliveryStatus;
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

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
