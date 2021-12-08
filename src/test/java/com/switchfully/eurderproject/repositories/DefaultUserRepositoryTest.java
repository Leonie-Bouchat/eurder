package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.exceptions.ListOfUsersIsEmptyException;
import com.switchfully.eurderproject.security.Role;
import com.switchfully.eurderproject.services.DefaultUserService;
import com.switchfully.eurderproject.services.UserConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Nested
    @DisplayName("Get user by id")
    class GetUserByID {
        @Test
        @DisplayName("Get user by id")
        void whenGetUserById_thenReturnTheUser() {
            userRepository.saveById(user1);
            assertThat(userRepository.getUserById(user1.getId()).getId()).isEqualTo(user1.getId());
        }

        @Test
        @DisplayName("When id is null")
        void givenGetUserById_WhenIdIsNull_ThenThrowsIllegalArgumentException() {
            userRepository.saveById(user1);
            assertThatThrownBy(() -> userRepository.getUserById(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("The id can't be null");
        }

        @Test
        @DisplayName("When list of users is null")
        void givenGetUserByI_whenListOfUsersIsNull_ThenThrowsListOfUsersIsEmptyException() {
            assertThatThrownBy(() -> userRepository.getUserById("anId"))
                    .isInstanceOf(ListOfUsersIsEmptyException.class)
                    .hasMessage("The repository is empty");
        }
    }



}