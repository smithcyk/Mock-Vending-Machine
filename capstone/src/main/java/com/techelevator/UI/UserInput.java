package com.techelevator.UI;

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

        System.out.println("(M) Feed Money.");
        System.out.println("(S) Select item.");
        System.out.println("(F) Finish transaction");

        //System.out.println("Current money provided: " + balance);

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

}
