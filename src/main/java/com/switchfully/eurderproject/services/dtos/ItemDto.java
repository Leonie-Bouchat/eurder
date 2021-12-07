package com.switchfully.eurderproject.services.dtos;

import lombok.Getter;

@Getter
public class ItemDto {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int amount;

    public ItemDto(String itemId, String name, String description, double price, int amount) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public ItemDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
