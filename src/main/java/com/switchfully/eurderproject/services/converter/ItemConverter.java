package com.switchfully.eurderproject.services.converter;

import com.switchfully.eurderproject.domain.Item;
import com.switchfully.eurderproject.services.dtos.CreateItemDto;
import com.switchfully.eurderproject.services.dtos.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {
    public ItemDto convertItemInItemDto(Item item) {
        return new ItemDto(item.getItemId(), item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
    }

    public Item convertCreateItemDtoInItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());
    }
}
