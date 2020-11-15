package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Integer getNumberOfProducts();

    Product getProductByProductName(String productName);

    boolean isProductInWarehouse(String productName);

    boolean isProductExistByName(String productName);

    boolean isProductExistById(Long productId);
}
