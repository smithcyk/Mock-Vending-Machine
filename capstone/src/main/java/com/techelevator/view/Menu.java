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
                audit.write(LocalDateTime.now().toString() + " " + "MONEY FED: $" + moneyToAdd + ".00 $" + getBalance());
                System.out.println("Current money provided: " + getBalance());
                runPurchaseMenu();
            } else if (choice.equals("selectItem")) {
                listAllItems(items);
                String slotInput = UserInput.selectItemForPurchase();
                Item item = verifyItemIdentifierExists(slotInput, items);
                if (item != null && checkIfQuantityIsSufficient(item) && isTheBalanceGreaterOrEqualToItemPrice(item)) {
                    balance = balance.subtract(item.getPrice());
                    System.out.println(item.getItemName() + " $" + item.getPrice() + " $" + balance);
                    dispenseItemWithItemMessage(item);

                    //audit file
                } else {
                    System.out.println("Transaction cannot be completed");
                }

            } else if (choice.equals("finishTransaction")) {
                System.out.println("Have a good day.");
                isRunning = false;
            } else {
                System.out.println("Please enter valid option");
            }
        }
    }

    public boolean isTheBalanceGreaterOrEqualToItemPrice(Item item){
        if (balance.compareTo(item.getPrice()) == 0 || balance.compareTo(item.getPrice()) == 1){
            return true;
        } return false;
    }

    public Item verifyItemIdentifierExists(String itemIdentifier, List<Item> items) {
        for (Item item : items){
            if (item.getSlotIdentifier().equals(itemIdentifier)){
                return item;
            }
        }
        return null;
    }

    public boolean checkIfQuantityIsSufficient(Item item){
        if (item.getQuantity() > 0){
            return true;
        } else {
            return false;
        }
    }

public void dispenseItemWithItemMessage(Item item) {
    if (item.getCategory().equalsIgnoreCase("munchy")) {
        System.out.println("Munchy, Munchy, so Good!");
    } else if (item.getCategory().equalsIgnoreCase("sandwich")) {
        System.out.println("Sandwich So Delicious, Yum!");
        } else if (item.getCategory().equalsIgnoreCase("drink")){
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    } else if (item.getCategory().equalsIgnoreCase("dessert")){
        System.out.println("Sugar, Sugar, so Sweet!");
    }
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
