package com.techelevator.view;

import com.techelevator.Items;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public List<Items> readFromFile() throws IOException {
        File file = new File("catering.csv");
        List<Items> cateringItems = new ArrayList<>();
        Items item = new Items();

        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");
                Items itemList = new Items(lineArray[0], lineArray[1], lineArray[2], new BigDecimal (lineArray[3]), item.getQuantity());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
