package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Integer getNumberOfProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        Optional<Product> findProductByName = products.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findFirst();

        return findProductByName.orElse(null);
    }

    @Override
    public boolean isProductInWarehouse(String productName) {
        return products.stream()
                .anyMatch(product -> isProductExistByName(productName) && product.getProductCount() > 0);
    }

    @Override
    public boolean isProductExistByName(String productName) {
        return products.stream()
                .anyMatch(product -> product.getProductName().equals(productName));
    }

    @Override
    public boolean isProductExistById(Long productId) {
        return products.stream()
                .anyMatch(product -> product.getId().equals(productId));
    }
}
