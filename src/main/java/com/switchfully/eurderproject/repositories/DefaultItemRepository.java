package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.Item;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Getter
public class DefaultItemRepository {
    private ConcurrentHashMap<String, Item> items;

    public DefaultItemRepository() {
        items = new ConcurrentHashMap<>();
    }

    public Item saveById(Item item) {
        items.put(item.getItemId(), item);
        return item;
    }
}
