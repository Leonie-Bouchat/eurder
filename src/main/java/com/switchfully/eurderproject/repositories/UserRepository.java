package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.User;

public interface UserRepository {
    User saveById(User user);
}
