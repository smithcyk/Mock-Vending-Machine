package com.techelevator.UI;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {

    private static Scanner userInput = new Scanner(System.in);

    public static String menuOptionsDisplay() {

        System.out.println("(D) Display catering items.");
        System.out.println("(P) Purchase catering items.");
        System.out.println("(E) Exit main menu.");

        System.out.println("Please select an option (Enter D, P or E): ");
        String selectedOption = userInput.nextLine();
        String option = selectedOption.trim().toUpperCase();

        switch (option) {
            case "D":
                return "displayCatering";
            case "P":
                return "purchaseItem";
            case "E":
                return "exit";
            default:
                return "";
        }
    }

    public static String purchaseMenuOptionsDisplay() {
        Menu menu = new Menu();
        System.out.println("(M) Feed Money.");
        System.out.println("(S) Select item.");
        System.out.println("(F) Finish transaction");

        System.out.println("Please select an option ");
        String selectedOption = userInput.nextLine();
        String option = selectedOption.trim().toUpperCase();


        switch (option) {
            case "M":
                return "feedMoney";
            case "S":
                return "selectItem";
            case "F":
                return "finishTransaction";
            default:
                return "";
        }

    }

    public static void selectItemForPurchase() {

        System.out.println("Please, select an item. (A1 - format)");

        String selectedItem = userInput.nextLine();
        String itemIdentifier = selectedItem.trim().toUpperCase();

    }


    public static BigDecimal feedMoneyIntoMachine(){
        System.out.println("Feed money into catering machine. Please enter either $1, $5, $10, or $20: ");
        String userInputMoney = userInput.nextLine();
        BigDecimal moneyEntered = new BigDecimal(userInputMoney);
        return moneyEntered;
    }

}
