package com.techelevator.view;

import com.techelevator.Item;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void runMainMenu() {
        String fileName = "catering.csv";
        List<Item> items = readFromFile(fileName);
        boolean isRunning = true;

        while(isRunning) {
            UserOutput.displayMainMenu();
            String choice = UserInput.menuOptionsDisplay();

            if(choice.equals("displayCatering")) {
                listAllItems(items);
            } else if (choice.equals("purchaseItem")) {

            } else if (choice.equals("exit")) {
                System.out.println("Have a good day.");
                isRunning = false;
            }else {
                System.out.println("Please enter valid option");
                isRunning = false;
            }
        }

    }


    public List<Item> readFromFile(String fileName)  {
        File file = new File(fileName);
        List<Item> cateringItems = new ArrayList<>();
        Item items = new Item();
//TESTS

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
