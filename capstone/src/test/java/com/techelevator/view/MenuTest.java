package com.techelevator.view;

import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {
    Menu testMenu = new Menu();
    @Test
    public void the_catering_file_should_return_correct_list_size() {
        //arrange
        String testFileName = "test.csv";

        //act
        List<Item> actualResults = testMenu.readFromFile(testFileName);

        //assert
        Assert.assertEquals(3, actualResults.size());

    }

    @Test
    public void the_catering_file_should_return_a_list() {
        //arrange
        String testFileName = "test.csv";

        //act
        List<Item> actualResults = testMenu.readFromFile(testFileName);

        //assert
        Assert.assertEquals("Popcorn", actualResults.get(0).getItemName());
        Assert.assertEquals("C1", actualResults.get(0).getSlotIdentifier());
        Assert.assertEquals("Munchy", actualResults.get(0).getCategory());
       //Assert.assertEquals("1.75", actualResults.get(0).getPrice());

    }

    @Test//isthebalancegreaterorequaltoitemprice
    public void balance_greater_than_price_should_return_true(){
        //arrange
        Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 7);
        BigDecimal balance = new BigDecimal("8.00");
        boolean expected = true;
        //act
        boolean actual = testMenu.isTheBalanceGreaterOrEqualToItemPrice(testItem, balance);
        //assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void balance_less_than_price_should_return_false(){
        //arrange
        Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 7);
        BigDecimal balance = new BigDecimal("0.75");
        boolean expected = false;
        //act
        boolean actual = testMenu.isTheBalanceGreaterOrEqualToItemPrice(testItem, balance);
        //assert
        Assert.assertEquals(expected, actual);
    }
    //test for verifyitemidentifierexists
    @Test
    public void if_item_doesntExist_should_return_null(){
        //arrange
        String testFileName = "test.csv";
        List<Item> actualResults = testMenu.readFromFile(testFileName);
        String testSlotIdentifer = "Z1";
        //act
        Item expected = null;
        //assert
        Assert.assertEquals(expected, testMenu.verifyItemIdentifierExists(testSlotIdentifer, actualResults));
    }
 @Test public void if_item_doesExist_should_return_item(){
     //arrange
     String testFileName = "test.csv";
     List<Item> actualResults = testMenu.readFromFile(testFileName);
     String testSlotIdentifer = "C1";
     Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 7);
     //act
     Item expected = testItem;
     Item actual = testMenu.verifyItemIdentifierExists(testSlotIdentifer, actualResults);
     //assert
     Assert.assertEquals(expected.getSlotIdentifier(), actual.getSlotIdentifier());
 }
//testing checkifquantityissufficient
    @Test public void if_quantity_is_sufficient_should_return_true(){
        //arrange
        Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 7);
        boolean expected = true;
        //act
        boolean actual = testMenu.checkIfQuantityIsSufficient(testItem);
        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test public void if_quantity_is_not_sufficient_should_return_false(){
        //arrange
        Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 0);
        boolean expected = false;
        //act
        boolean actual = testMenu.checkIfQuantityIsSufficient(testItem);
        //assert
        Assert.assertEquals(expected, actual);
    }
    @Test public void if_quantity_is_one_should_return_true(){
        //arrange
        Item testItem = new Item("C1", "Popcorn","Munchy",new BigDecimal("1.75"), 1);
        boolean expected = true;
        //act
        boolean actual = testMenu.checkIfQuantityIsSufficient(testItem);
        //assert
        Assert.assertEquals(expected, actual);
    }
}
