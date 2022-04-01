package com.techelevator.UI;

import com.techelevator.Item;

import java.util.List;

public class UserOutput {

    public static void displayMainMenu() {
        System.out.println();
        System.out.println("################################");
        System.out.println("Welcome to the CaTEring Machine!");
        System.out.println("################################");

    }

    public static void listItems(List<Item> items) {
        for (Item item: items) {
            System.out.println(item.getSlotIdentifier() + item.getItemName() + item.getPrice() + item.getQuantity());
        }
    }



}
