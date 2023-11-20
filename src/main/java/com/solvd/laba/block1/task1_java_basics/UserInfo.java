package com.solvd.laba.block1.task1_java_basics;

public class UserInfo {
    public static void main(String[] args) {
        if (args.length >= 2) {
            String name = args[0];
            String surname = args[1];
            System.out.println("Hello! Nice to see you " + name + " " + surname + "!");
        } else {
            System.out.println("Please provide your name and surname as command line arguments.");
        }
    }
}