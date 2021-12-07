package com.switchfully.eurderproject.services.dtos;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class CreateItemDto {
    private String name;
    private String description;
    private double price;
    private int amount;

    public CreateItemDto(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
