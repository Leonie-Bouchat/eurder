package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Getter
public class DefaultUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User saveById(User user) {
//        if (users.contains(user.getUserName())) {
//            throw new AlreadyExistsException("The userName already exists");
//        }
//        users.put(user.getId(), user);
//        return user;
        entityManager.persist(user);
        return user;
    }

    public User getUserById(String id) {
        assertThatArgumentIsNotNull(id);
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    private void assertThatArgumentIsNotNull(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id can't be null");
        }
    }
}
