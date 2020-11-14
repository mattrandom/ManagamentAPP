package service;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class UserServiceImplTest {
    private List<User> userList;
    private UserService userService;

    @BeforeEach
    void dataInitializing() {
        User user1 = new User(1L, "first", "secretpass1");
        User user2 = new User(2L, "second", "secretpass2");
        User user3 = new User(3L, "third", "secretpass3");

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userService = new UserServiceImpl(userList);
    }

    @AfterEach
    void dataDestruction() {
        userList.clear();
    }

    @Test
    @DisplayName("User's list size should be equal to the number of added users")
    void getAllUsersTest() {
        // given & when
        List<User> allUsers = userService.getAllUsers();

        // then
        assertThat(allUsers, hasSize(3));
    }

    @Test
    @DisplayName("Users should be added to the list when we call addUser's method and pass each user's object")
    void addUserTest() {
        // given
        User user4 = new User(4L, "random", "random");

        // when
        userService.addUser(user4);

        // then
        assertThat(userService.getAllUsers().get(3), equalTo(user4));
    }

    @Test
    @DisplayName("User should be removed from the list after indicating its ID number")
    void removeUserTest() {
        // given & when
        userService.removeUser(2L);

        // then
        assertThat(userService.getAllUsers().size(), equalTo(2));
    }
}