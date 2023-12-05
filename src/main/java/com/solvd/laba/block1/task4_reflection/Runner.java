package com.solvd.laba.block1.task4_reflection;

import com.solvd.laba.block1.task2_oop.Address;
import com.solvd.laba.block1.task2_oop.Customer;
import com.solvd.laba.block1.task2_oop.FullName;
import com.solvd.laba.block1.task2_oop.Person;
import com.solvd.laba.block1.task2_oop.exceptions.InvalidAddressException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        System.out.println();

        Class customerClass = Customer.class;
        System.out.println(customerClass.getName());

        // Using reflection extract information
        // (modifiers, return types, parameters, etc)
        // about fields, constructors, methods.

        int customerModifiers = customerClass.getModifiers();
        System.out.println("Class Modifiers: " + Modifier.toString(customerModifiers));

        // constructors
        Constructor[] constructors = customerClass.getDeclaredConstructors();
        System.out.println("\nConstructors:\n");
        for (Constructor constructor : constructors) {
            System.out.println(" Name: " + constructor.getName());
            int modifiers = constructor.getModifiers();
            System.out.println(" Modifiers: " + Modifier.toString(modifiers));

            // Вивести параметри конструктора
            Parameter[] parameters = constructor.getParameters();
            System.out.print(" Parameters: \n");
            for (Parameter parameter : parameters) {
                System.out.print("  " + parameter.getName() + ", " + parameter.getType() + "\n");
            }
            System.out.println();
        }

        // fields
        Field[] fields = customerClass.getDeclaredFields();
        System.out.println("Fields:\n");
        for (Field field : fields) {
            System.out.println(" Name: " + field.getName());
            int fieldModifiers = field.getModifiers();
            System.out.println(" Modifiers: " + Modifier.toString(fieldModifiers));
            System.out.println(" Type: " + field.getType());
            System.out.println();
        }

        // methods
        Method[] methods = customerClass.getDeclaredMethods();
        System.out.println("Methods:\n");
        for (Method method : methods) {
            System.out.println(" Name: " + method.getName());
            int methodModifiers = method.getModifiers();
            System.out.println(" Modifiers: " + Modifier.toString(methodModifiers));
            System.out.println(" Return Type: " + method.getReturnType());

            Parameter[] methodParameters = method.getParameters();
            System.out.println(" Parameters:");
            for (Parameter parameter : methodParameters) {
                System.out.println("  " + parameter.getName() + ", " + parameter.getType());
            }
            System.out.println();
        }


        // Create object and call method using the only reflection
        // and methods
        try {
            Constructor<Customer> privateConstructor = customerClass.getDeclaredConstructor(FullName.class);
            privateConstructor.setAccessible(true);
            Customer customer = privateConstructor.newInstance(new FullName("Julia", "Rak"));

            Method setPhoneNumberMethod = Person.class.getDeclaredMethod("setPhoneNumber", String.class);
            setPhoneNumberMethod.invoke(customer, "+380981234567");

            Method setEmailMethod = Person.class.getDeclaredMethod("setEmail", String.class);
            setEmailMethod.invoke(customer, "juliae@gmail.com");

            Method addAddressMethod = customerClass.getDeclaredMethod("addAddress", Address.class);
            addAddressMethod.invoke(customer, new Address("City", "Street", "123"));

            // Вивести результат
            System.out.println("\nCustomer created using reflection (methods): " + customer);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                  InvalidAddressException e) {
            LOGGER.error(e.getMessage());
        }

        // Create object and call method using the only reflection
        // and fields
        try {
            Constructor<Customer> privateConstructor = Customer.class.getDeclaredConstructor(FullName.class);
            privateConstructor.setAccessible(true);
            Customer customer = privateConstructor.newInstance(new FullName("Julia", "Rak"));

            Field phoneNumberField = Person.class.getDeclaredField("phoneNumber");
            phoneNumberField.setAccessible(true);
            phoneNumberField.set(customer, "+380981234567");

            Field emailField = Person.class.getDeclaredField("email");
            emailField.setAccessible(true);
            emailField.set(customer, "juliae@gmail.com");

            Field addressesField = Customer.class.getDeclaredField("addresses");
            addressesField.setAccessible(true);
            List<Address> addressesList = new ArrayList<>();
            addressesList.add(new Address("City", "Street", "123"));
            addressesField.set(customer, addressesList);

            System.out.println("\nCustomer created using reflection (fields): " + customer);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException | InvocationTargetException | InvalidAddressException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
