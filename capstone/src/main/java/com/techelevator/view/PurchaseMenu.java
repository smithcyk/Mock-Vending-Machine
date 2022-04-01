package com.techelevator.view;

import com.techelevator.Item;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseMenu extends Menu{

    public BigDecimal balance;

    public void runPurchaseMenu() {
        String fileName = "catering.csv";
        List<Item> items = readFromFile(fileName);
        boolean isRunning = true;

        while(isRunning) {
            String choice = UserInput.purchaseMenuOptionsDisplay();

            if(choice.equals("feedMoney")) {
                listAllItems(items);
            } else if (choice.equals("selectItem")) {

            } else if (choice.equals("finishTransaction")) {
                System.out.println("Have a good day.");
                isRunning = false;
            }else {
                System.out.println("Please enter valid option");
                isRunning = false;
            }
        }

    }




    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
