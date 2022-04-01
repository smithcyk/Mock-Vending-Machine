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
    public List<Item> readFromFile() throws IOException {
        File file = new File("catering.csv");
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
    private void listAllItems(List<Item> items) {
        UserOutput.listItems(items);
    }
}
