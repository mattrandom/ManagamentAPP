package model.parser;

import model.User;

public class UserParser {

    public static User parseUser(String data) {
        String[] userInfo = data.split(User.USER_SEPARATOR);

        Long id = Long.parseLong(userInfo[0]);
        String login = userInfo[1];
        String password = userInfo[2];

        return new User(id, login, password);
    }
}
