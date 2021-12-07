package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.security.Role;
import com.switchfully.eurderproject.services.DefaultUserService;
import com.switchfully.eurderproject.services.UserConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultUserRepositoryTest {
    private DefaultUserRepository userRepository;
    private DefaultUserService userService;
    private UserConverter userConverter;
    private Address address1;
    private User user1;

    @BeforeEach
    void setUp() {
        userRepository = new DefaultUserRepository();
        userConverter = new UserConverter();
        userService = new DefaultUserService(userRepository, userConverter);
        address1 = new Address.Builder().withStreetName("Rue de la Station").withStreetNumber(28).withPostalCode(5000).withCity("Namur").build();
        user1 = new User.Builder("Léonie", "Bouchat", address1, Role.CUSTOMER).build();
    }

    @Nested
    @DisplayName("Create User")
    class CreateUser {
        @Test
        @DisplayName("Create new User with all informations")
        void whenCreateNewUser_thenCreateAndReturnNewUserWithInformations() {
            assertThat(userRepository.saveById(user1)).isEqualTo(user1);
            assertThat(userRepository.getUsers().size()).isEqualTo(1);
        }
    }

}