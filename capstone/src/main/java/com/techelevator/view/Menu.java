package com.techelevator.view;

import com.techelevator.Audit.Audit;
import com.techelevator.Item;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    String fileName = "catering.csv";
    List<Item> items = readFromFile(fileName);
    public BigDecimal balance = new BigDecimal("0.00");

    public void runMainMenu() {
        boolean isRunning = true;

        while(isRunning) {
            UserOutput.displayMainMenu();
            String choice = UserInput.menuOptionsDisplay();

            if(choice.equals("displayCatering")) {
                listAllItems(items);
            } else if (choice.equals("purchaseItem")) {
               runPurchaseMenu();
            } else if (choice.equals("exit")) {
                System.out.println("Have a good day.");
                isRunning = false;
            }else {
                System.out.println("Please enter valid option");
                isRunning = false;
            }
        }
    }

    public void runPurchaseMenu() {
        String fileName = "catering.csv";

        boolean isRunning = true;
        Audit audit = new Audit("Audit.txt");

        while (isRunning) {
            String choice = UserInput.purchaseMenuOptionsDisplay();

            if (choice.equals("feedMoney")) {
                BigDecimal moneyToAdd = UserInput.feedMoneyIntoMachine();
                balance = balance.add(moneyToAdd);
                audit.write(LocalDateTime.now().toString() + " " + "MONEY FED: $" + moneyToAdd + ".00 $"+ getBalance());
                System.out.println("Current money provided: " + getBalance());
                runPurchaseMenu();
            } else if (choice.equals("selectItem")) {
                listAllItems(items);
                //implement verify Item Identifier that is below this method

            } else if (choice.equals("finishTransaction")) {
                System.out.println("Have a good day.");
                isRunning = false;
            } else {
                System.out.println("Please enter valid option");
                isRunning = false;
            }
        }

    }

    public void verifyItemIdentifierExists(String itemIdentifier, List<Item> items) {
        UserInput userInput = new UserInput();
//        for (Item item : items) {
//            if (!item.getSlotIdentifier().equals(itemIdentifier)){
//                itemIdentifier.equals(item.getSlotIdentifier());
//            }
//            System.out.println("Invalid entry");
//        }
//
    }

// && item.getQuantity() > 0

    public void checkIfQuantityIsSufficient(){

    }

//    }
//        else if {
//
//        System.out.println("NO LONGER AVAILABLE");
//
public void dispenseItem() {
//    if (item.getCategory().equalsIgnoreCase("munchy")) {
//        System.out.println("Munchy, Munchy, so Good!");
//    } else if (item.getCategory().equalsIgnoreCase("sandwich")) {
//        System.out.println("Sandwich So Delicious, Yum!");
//        } else if (item.getCategery().equalsIgnoreCase("drink")){
//        System.out.println("Drinky, Drinky, Slurp Slurp!");
//    } else if (item.getCategory().equalsIgnoreCase("dessert")){
//        System.out.println("Sugar, Sugar, so Sweet!");
//    }
}

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Item> readFromFile(String fileName)  {
        File file = new File(fileName);
        List<Item> cateringItems = new ArrayList<>();
        Item items = new Item();

        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");
                Item itemList = new Item(lineArray[0], lineArray[1], lineArray[2], new BigDecimal (lineArray[3]), items.getQuantity());
                cateringItems.add(itemList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return cateringItems;
    }

    //use after D
    public void listAllItems(List<Item> items) {
        UserOutput.listItems(items);
    }

}
