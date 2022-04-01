package com.techelevator;

import java.math.BigDecimal;

    public class Items {
    private String slotIdentifier;
    private String itemName;
    private String category;
    private BigDecimal price;
    private int quantity = 7;

    public Items(String slotIdentifier, String itemName, String category, BigDecimal price, int quantity){
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;

    }
    public Items(){

    }

//    public int itemQuantityCalculator(){ WE ARE NOT DONE WITH THIS
//
//    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
