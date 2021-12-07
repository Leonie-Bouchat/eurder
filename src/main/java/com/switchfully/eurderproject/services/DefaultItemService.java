package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.Item;
import com.switchfully.eurderproject.repositories.DefaultItemRepository;
import com.switchfully.eurderproject.services.dtos.CreateItemDto;
import com.switchfully.eurderproject.services.dtos.ItemDto;
import org.springframework.stereotype.Service;

@Service
public class DefaultItemService {
    private DefaultItemRepository itemRepository;
    private ItemConverter itemConverter;

    public DefaultItemService(DefaultItemRepository itemRepository, ItemConverter itemConverter) {
        this.itemRepository = itemRepository;
        this.itemConverter = itemConverter;
    }

    public ItemDto saveById(CreateItemDto createItemDto) {
        Item item = itemConverter.convertCreateItemDtoInItem(createItemDto);
        Item newItem = itemRepository.saveById(item);
        return itemConverter.convertItemInItemDto(newItem);
    }
}
