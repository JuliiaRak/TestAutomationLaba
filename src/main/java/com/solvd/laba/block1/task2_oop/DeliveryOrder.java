package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.enums.DeliveryStatus;
import com.solvd.laba.block1.task2_oop.enums.PaymentStatus;
import com.solvd.laba.block1.task2_oop.enums.VehicleType;
import com.solvd.laba.block1.task2_oop.exceptions.SettingCourierException;
import com.solvd.laba.block1.task2_oop.interfaces.StatusChangeable;
import com.solvd.laba.block1.task2_oop.interfaces.Trackable;
import com.solvd.laba.block1.task2_oop.repos.CouriersRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrder implements StatusChangeable, Trackable {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryOrder.class);

    protected Customer sender;
    protected Address orderedFromAddress;
    protected Customer recipient;
    protected Address orderedToAddress;
    protected List<Item> items;
    protected Courier courier;
    protected double distance;
    protected DeliveryStatus deliveryStatus = Constants.DEFAULT_DELIVERY_STATUS;
    protected PaymentStatus paymentStatus = Constants.DEFAULT_PAYMENT_STATUS;

    static {
        System.out.println("Creating a delivery order...\n");
        LOGGER.info("Creating a delivery order...");
    }

    public DeliveryOrder() {
    }

    public DeliveryOrder(Customer sender, Address orderedFromAddress, Customer recipient, Address orderedToAddress, double distance) throws SettingCourierException {
        this.sender = sender;
        this.orderedFromAddress = orderedFromAddress;
        this.recipient = recipient;
        this.orderedToAddress = orderedToAddress;
        this.items = new ArrayList<>();
        this.distance = distance;
        setCourier(items);
    }

    @Override
    public void changeStatus(DeliveryStatus newStatus) {
        this.deliveryStatus = newStatus;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(List<Item> items) throws SettingCourierException {
        VehicleType vehicleType;
        double orderWeight = getOrderWeight();

        if (orderWeight >= 0 && orderWeight <= 2) vehicleType = VehicleType.BICYCLE;
        else if (orderWeight >= 2 && orderWeight <= 4) vehicleType = VehicleType.MOTORCYCLE;
        else if (orderWeight >= 4 && orderWeight <= 10) vehicleType = VehicleType.CAR;
        else if (orderWeight >= 10 && orderWeight <= 30) vehicleType = VehicleType.TRUCK;
        else vehicleType = null;

        this.courier = findMostPropriateCourier(vehicleType, orderWeight);
    }

    public Courier findMostPropriateCourier(VehicleType vehicleType, double orderWeight) throws SettingCourierException {
        Courier foundCourier = null;
        for (Courier courier : CouriersRepo.getCouriers(vehicleType)) {
            if (courier.getIsFree() == true) {
                foundCourier = courier;
                break;
            }
        }
        if (foundCourier == null) {
            // Якщо не знайдено кур'єра для вказаного типу транспорту, викидайте виняток
            throw new SettingCourierException("No suitable courier found for the specified vehicle type to carry order with weight " + orderWeight);
        }
        return foundCourier;
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

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
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

    public Address getOrderedFromAddress() {
        return orderedFromAddress;
    }

    public void setOrderedFromAddress(Address orderedFromAddress) {
        this.orderedFromAddress = orderedFromAddress;
    }

    public Address getOrderedToAddress() {
        return orderedToAddress;
    }

    public void setOrderedToAddress(Address orderedToAddress) {
        this.orderedToAddress = orderedToAddress;
    }

    public double getOrderWeight(){
        double orderWeight = 0;
        for (Item item : items){
            orderWeight += item.getWeight();
        }
        return  orderWeight;
    }

    @Override
    public String toString() {
        StringBuilder itemsString = new StringBuilder();
        for (Item item : items) {
            itemsString.append(item.getName() + " (" + item.getItemType().getItemTypeName() + ")").append(", ");
        }
        // Видаляємо останню кому та пробіл, якщо є хоча б один предмет
        if (!items.isEmpty()) {
            itemsString.delete(itemsString.length() - 2, itemsString.length());
        }

        return "Your delivery order details:\n" +
                "Sender: " + sender.getFullName() +"\n" +
                "Address delivery from: " +  getOrderedFromAddress() +"\n" +
                "Recipient: " + recipient.getFullName() +"\n" +
                "Address delivery to: " +  getOrderedToAddress() +"\n" +
                "Items: " + itemsString +"\n" +
                "Distance: " + distance +"\n" +
                "DeliveryStatus: " + deliveryStatus +"\n" +
                "Payment Status: " + paymentStatus +"\n";
    }

    @Override
    public DeliveryStatus trackDeliveryStatus() {
        return deliveryStatus;
    }
}
