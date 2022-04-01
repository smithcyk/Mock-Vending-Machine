package com.techelevator.view;

import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void the_catering_file_should_return_correct_list_size() {
        //arrange
//        List<Item> testFileToList = new List<Item>() {
//        }
//        File file = new File();
        Menu testMenu = new Menu();
        String testFileName = "test.csv";

        //act
        List<Item> actualResults = testMenu.readFromFile(testFileName);

        //assert
        Assert.assertEquals(3, actualResults.size());

    }

    @Test
    public void the_catering_file_should_return_a_list() {
        //arrange
        Menu testMenu = new Menu();
        String testFileName = "test.csv";

        //act
        List<Item> actualResults = testMenu.readFromFile(testFileName);

        //assert
        Assert.assertEquals("Popcorn", actualResults.get(0).getItemName());
        Assert.assertEquals("C1", actualResults.get(0).getSlotIdentifier());
        Assert.assertEquals("Munchy", actualResults.get(0).getCategory());
//        Assert.assertEquals(new BigDecimal("1.75"), actualResults.get(0).getPrice());

    }
}
