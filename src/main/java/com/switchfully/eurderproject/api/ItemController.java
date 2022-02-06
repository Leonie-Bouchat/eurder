package com.switchfully.eurderproject.api;

import com.switchfully.eurderproject.services.DefaultItemService;
import com.switchfully.eurderproject.services.dtos.CreateItemDto;
import com.switchfully.eurderproject.services.dtos.ItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private DefaultItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(DefaultItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createNewItem(@RequestBody CreateItemDto createItemDto) {
        ItemDto item = itemService.saveById(createItemDto);
        logger.info("New item added");
        return item;
    }
}
