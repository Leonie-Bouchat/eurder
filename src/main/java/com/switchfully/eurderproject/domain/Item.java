package com.switchfully.eurderproject.domain;
import lombok.Getter;
import java.util.UUID;

@Getter
public class Item {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
