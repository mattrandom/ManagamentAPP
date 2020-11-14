import model.Boots;
import model.Cloth;
import model.User;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "admin", "secretpass");
        Boots boots = new Boots(1L, "High heels", 99.9, 0.5, "Red", 12, 35, true);
        Cloth cloth = new Cloth(1L, "T-shirt", 35.9, 0.3, "Black", 10, "XL", "Cotton");

        System.out.println(user);
        System.out.println(boots);
        System.out.println(cloth);
    }
}
