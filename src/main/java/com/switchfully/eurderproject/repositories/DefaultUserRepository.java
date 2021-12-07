package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

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
}
