package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.Item;
import com.switchfully.eurderproject.services.DefaultItemService;
import com.switchfully.eurderproject.services.ItemConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultItemRepositoryTest {
    private DefaultItemRepository itemRepository;
    private Item item1;

    @BeforeEach
    void setUp() {
        itemRepository = new DefaultItemRepository();
        item1 = new Item("Computer", "No description", 1542.4, 3);
    }

    @Nested
    @DisplayName("Create Item")
    class CreateItem {
        @Test
        @DisplayName("Create Item")
        void givenAnItem_whenSaveById_thenSaveAndReturnTheId() {
            assertThat(itemRepository.saveById(item1)).isEqualTo(item1);
            assertThat(itemRepository.getItems().size()).isEqualTo(1);
        }
    }
}