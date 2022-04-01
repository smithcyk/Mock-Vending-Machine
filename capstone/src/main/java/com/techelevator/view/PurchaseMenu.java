package com.techelevator.view;

import com.techelevator.Audit.Audit;
import com.techelevator.Item;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseMenu extends Menu{

    public BigDecimal balance = new BigDecimal("0.00");

    public void runPurchaseMenu() {
        String fileName = "catering.csv";
        List<Item> items = readFromFile(fileName);
        boolean isRunning = true;
        Audit audit = new Audit("Audit.txt");

        while(isRunning) {
            String choice = UserInput.purchaseMenuOptionsDisplay();

            if(choice.equals("feedMoney")) {
                BigDecimal moneyToAdd = UserInput.feedMoneyIntoMachine();
                balance.add(moneyToAdd);
                 audit.write(LocalDateTime.now() + "MONEY FED: " + moneyToAdd + getBalance()); //not adding to balance
                 runPurchaseMenu();
            } else if (choice.equals("selectItem")) {
                listAllItems(items);

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
