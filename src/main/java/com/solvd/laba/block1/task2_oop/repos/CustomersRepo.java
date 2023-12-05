package com.solvd.laba.block1.task2_oop.repos;

import com.solvd.laba.block1.task2_oop.Address;
import com.solvd.laba.block1.task2_oop.Customer;
import com.solvd.laba.block1.task2_oop.DeliveryService;
import com.solvd.laba.block1.task2_oop.FullName;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidAddressException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidEmailException;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidPhoneNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersRepo {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    private List<Customer> customers = new ArrayList<>();

    public CustomersRepo(){
        try {
            Address addressKyiv1 = new Address("Kyiv", "Shevchenka", "8a");
            Address addressKyiv2 = new Address("Kyiv", "Khreshchatyk", "7");
            Customer sender = new Customer(new FullName("Julia", "Rak"), "+380980207334", "juliarak@gmail.com");
            sender.addAddress(addressKyiv1);
            sender.addAddress(addressKyiv2);

            Address addressRivne  = new Address("Rivne", "Shevchenka", "5");
            Customer recipient = new Customer(new FullName("Marta", "Rak"), "+380676757226", "olenarak@gmail.com");
            recipient.addAddress(addressRivne);

            customers.add(sender);
            customers.add(recipient);
        } catch (InvalidAddressException |
                 InvalidPhoneNumberException |
                 InvalidEmailException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Address> getAllCustomerAddresses() {
        return customers.stream()
                .flatMap(customer -> customer.getAddresses().stream())
                .collect(Collectors.toList());
    }
}
