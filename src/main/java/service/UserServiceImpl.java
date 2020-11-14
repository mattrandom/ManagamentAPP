package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }
}