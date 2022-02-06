package com.switchfully.eurderproject.domain;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "ITEM")
@Getter
public class Item {

    @Id
    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "AMOUNT")
    private int amount;

    public Item(String name, String description, double price, int amount) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item() {

    }
}
