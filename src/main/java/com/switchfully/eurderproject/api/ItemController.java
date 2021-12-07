package com.switchfully.eurderproject.api;

import com.switchfully.eurderproject.services.DefaultItemService;
import com.switchfully.eurderproject.services.dtos.CreateItemDto;
import com.switchfully.eurderproject.services.dtos.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private DefaultItemService itemService;

    public ItemController(DefaultItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createNewItem(@RequestBody CreateItemDto createItemDto) {
        ItemDto item = itemService.saveById(createItemDto);
        return item;
    }
}
