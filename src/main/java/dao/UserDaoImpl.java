package dao;

import model.User;
import model.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.createNewFile(fileName);
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> allUsers = getAllUsers();
        allUsers.add(user);
        saveUsers(allUsers);
    }

    @Override
    public void saveUsers(List<User> users) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users) {
                fileWriter.write(user + System.lineSeparator());
            }
        }
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> allUsers = getAllUsers();
        boolean isFound = allUsers.removeIf(user -> user.getLogin().equals(login));
        if (isFound) {
            saveUsers(allUsers);
        }
    }

    @Override
    public void removeUserById(Long id) throws IOException {
        List<User> allUsers = getAllUsers();
        boolean isFound = allUsers.removeIf(user -> user.getId().equals(id));
        if (isFound) {
            saveUsers(allUsers);
        }
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readData;
            while ((readData = reader.readLine()) != null) {
                User user = UserParser.parseUser(readData);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> allUsers = getAllUsers();
        Optional<User> findUserByLogin = allUsers.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();

        return findUserByLogin.orElse(null);
    }

    @Override
    public User getUserById(Long id) throws IOException {
        List<User> allUsers = getAllUsers();
        Optional<User> findUserById = allUsers.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        return findUserById.orElse(null);
    }
}
