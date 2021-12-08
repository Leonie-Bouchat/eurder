package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.exceptions.ListOfUsersIsEmptyException;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Getter
public class DefaultUserRepository {

    private final ConcurrentHashMap<String, User> users;

    public DefaultUserRepository() {
        users = new ConcurrentHashMap<>();
    }

    public User saveById(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUserById(String id) {
        assertThatArgumentIsNotNull(id);
        assertThatListOfUserIsNotEmpty();
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    private void assertThatListOfUserIsNotEmpty() {
        if (users.isEmpty()) {
            throw new ListOfUsersIsEmptyException("The repository is empty");
        }
    }

    private void assertThatArgumentIsNotNull(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id can't be null");
        }
    }
}
