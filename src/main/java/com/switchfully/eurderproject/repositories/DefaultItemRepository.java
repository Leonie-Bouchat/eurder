package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.Item;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Getter
public class DefaultItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Item saveById(Item item) {
        entityManager.persist(item);
        return item;
    }
}
