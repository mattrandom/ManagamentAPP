import model.Boots;
import model.Cloth;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "admin", "secretpass");
        Boots boots = new Boots(1L, "High heels", 99.9, 0.5, "Red", 12, 35, true);
        Cloth cloth = new Cloth(1L, "T-shirt", 35.9, 0.3, "Black", 10, "XL", "Cotton");

        System.out.println(user);
        System.out.println(boots);
        System.out.println(cloth);

        User user2 = new User(2L, "admin2", "secretpass2");
        User user3 = new User(3L, "admin3", "secretpass3");

        UserService userService = new UserServiceImpl();
        userService.addUser(user);
        userService.addUser(user2);
        userService.addUser(user3);

        System.out.println(userService.getAllUsers());
        userService.removeUser(user2.getId());
        System.out.println(userService.getAllUsers());
    }
}
