package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.DeliveryStatus;
import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.SettingCourierException;
import com.solvd.laba.block1.task2_oop.interfaces.StatusChangeable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryOrder implements StatusChangeable {

    private static final Logger logger = LogManager.getLogger(DeliveryOrder.class);

    protected Customer sender;
    protected Customer recipient;
    protected Item item;
    protected Courier courier;
    protected double distance;
    protected DeliveryStatus deliveryStatus = Constants.DEFAULT_STATUS;

    static {
        System.out.println("Creating a delivery order...\n");
        logger.info("Creating a delivery order...\n");
    }

    public DeliveryOrder() {
    }

    public DeliveryOrder(Customer sender, Customer recipient, Item item, double distance) throws SettingCourierException {
        this.sender = sender;
        this.recipient = recipient;
        this.item = item;
        this.distance = distance;
        setCourier(item);
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Item item) throws SettingCourierException{
        VehicleType vehicleType;
        if (item.getWeight() >= 0 && item.getWeight() <= 2) vehicleType = VehicleType.BICYCLE;
        else if (item.getWeight() >= 2 && item.getWeight() <= 4) vehicleType = VehicleType.MOTORCYCLE;
        else if (item.getWeight() >= 4 && item.getWeight() <= 10) vehicleType = VehicleType.CAR;
        else if (item.getWeight() >= 10 && item.getWeight() <= 30) vehicleType = VehicleType.TRUCK;
        else vehicleType = null;

        Courier foundCourier = null;
        for (Courier courier : CouriersRepo.getCouriers()) {
            if (courier.getVehicle() == vehicleType) {
                foundCourier = courier;
                break;
            }
        }
        if (foundCourier == null) {
            // Якщо не знайдено кур'єра для вказаного типу транспорту, викидайте виняток
            throw new SettingCourierException("No suitable courier found for the specified vehicle type.");
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

    @Override
    public void changeStatus(DeliveryStatus newStatus) {
        this.deliveryStatus = newStatus;
    }

    @Override
    public String toString() {
        return "Your delivery order details:\n" +
                "Sender: " + sender.getFullName() +"\n" +
                "Recipient: " + recipient.getFullName() +"\n" +
                "Item: " + item.getName() +"\n" +
                "Distance: " + distance +"\n" +
                "DeliveryStatus: " + deliveryStatus +"\n";
    }
}
