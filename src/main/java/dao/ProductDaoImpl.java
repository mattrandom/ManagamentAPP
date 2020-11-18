package dao;

import model.Product;
import model.parser.ProductParser;
import model.parser.ProductType;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    private final String fileName;
    private final ProductType productType;

    public ProductDaoImpl(String fileName, ProductType productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : products) {
                fileWriter.write(product + System.lineSeparator());
            }
        }
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        boolean isFound = products.removeIf(product -> product.getId().equals(productId));
        if (isFound) {
            saveProducts(products);
        }
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        boolean isFound = products.removeIf(product -> product.getProductName().equals(productName));
        if (isFound) {
            saveProducts(products);
        }
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readData;
            while ((readData = reader.readLine()) != null) {
                Product product = ProductParser.parseProduct(readData, productType);
                if (product != null) {
                    products.add(product);
                }
            }
        }
        return products;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        Optional<Product> findProductById = products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();

        return findProductById.orElse(null);
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        Optional<Product> findProductByName = products.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findFirst();

        return findProductByName.orElse(null);
    }
}
