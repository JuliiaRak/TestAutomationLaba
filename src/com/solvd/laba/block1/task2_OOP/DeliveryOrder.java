package com.solvd.laba.block1.task2_OOP;

public class DeliveryOrder {
    protected Customer sender;
    protected Customer recipient;
    protected Item item;
    protected Courier courier;
    protected double distance;
    protected DeliveryStatus deliveryStatus;

    public DeliveryOrder(Customer sender, Customer recipient, Item item, double distance) {
        this.sender = sender;
        this.recipient = recipient;
        this.item = item;
        this.distance = distance;
        this.deliveryStatus = DeliveryStatus.PENDING;
        setCourier(item);
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Item item) {
        VehicleType vehicleType;
        if (item.getWeight() >= 0 && item.getWeight() <= 2) vehicleType = VehicleType.BICYCLE;
        else if (item.getWeight() >= 2 && item.getWeight() <= 4) vehicleType = VehicleType.MOTORCYCLE;
        else if (item.getWeight() >= 4 && item.getWeight() <= 10) vehicleType = VehicleType.CAR;
        else if (item.getWeight() >= 10 && item.getWeight() <= 30) vehicleType = VehicleType.TRUCK;
        else vehicleType = null;

        Courier foundCourier = null;
        for (Courier courier : CouriersRepo.couriers) {
            if (courier.getVehicle() == vehicleType) {
                foundCourier = courier;
                break;
            }
        }

        this.courier = foundCourier;
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
