import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Boots;
import model.Cloth;
import model.Product;
import model.User;
import model.parser.ProductType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Boots boots = new Boots(1L, "High heels", 99.9, 0.5, "Red", 12, 35, true);

        Cloth cloth1 = new Cloth(1L, "T-shirt 1", 35.9, 0.3, "Black", 10, "XL", "Cotton");
        Cloth cloth2 = new Cloth(2L, "T-shirt 2", 35.9, 0.3, "Black", 10, "XL", "Cotton");
        Cloth cloth3 = new Cloth(3L, "T-shirt 3", 35.9, 0.3, "Black", 10, "XL", "Cotton");

        List<Product> productList = new ArrayList<>();
        productList.add(cloth1);
        productList.add(cloth2);
        productList.add(cloth3);

        ProductDao productClothDao = new ProductDaoImpl("cloths.txt", ProductType.CLOTH);
        productClothDao.saveProducts(productList);

        User user = new User(1L, "admin", "admin");
        UserDao userDao = new UserDaoImpl("users.txt");
        userDao.saveUser(user);
        System.out.println(userDao.getAllUsers());
    }
}
