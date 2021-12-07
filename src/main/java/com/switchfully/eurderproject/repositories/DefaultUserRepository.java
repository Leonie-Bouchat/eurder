package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultUserRepository implements UserRepository {

    private final ConcurrentHashMap<String, User> users;

    public DefaultUserRepository() {
        users = new ConcurrentHashMap<>();
    }

    @Override
    public User saveById(User user) {
        users.put(user.getId(), user);
        return user;
    }
}
