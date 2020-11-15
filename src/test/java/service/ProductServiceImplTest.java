package service;

import model.Boots;
import model.Cloth;
import model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    @DisplayName("Should return positive when product's list is equal to the products retrieved by method")
    void getAllProductsTestPositiveCase() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        List<Product> allProducts = productService.getAllProducts();

        // then
        assertThat(productList, equalTo(allProducts));
    }

    @Test
    @DisplayName("Should return positive when product's list is NOT equal to the products retrieved by method")
    void getAllProductsTestNegativeCase() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = new ArrayList<>();
        productList.add(cloth);
        productList.add(boots);

        // when
        ProductService productService = new ProductServiceImpl(new ArrayList<>(productList));
        List<Product> allProducts = productService.getAllProducts();

        productList.add(new Boots(3L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true));

        // then
        assertNotEquals(productList.size(), allProducts.size());
    }

    @Test
    @DisplayName("Should return positive when number of products is equal to the passed value which are being compared with")
    void getAllProductsTestWithProducts() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        Integer numberOfProducts = productService.getNumberOfProducts();

        // then
        assertThat(numberOfProducts, is(2));
    }

    @Test
    @DisplayName("Should return positive when list of products is empty")
    void getAllProductsTestWithoutProducts() {
        // given
        ProductService productService = new ProductServiceImpl();

        // when
        Integer numberOfProducts = productService.getNumberOfProducts();

        // then
        assertThat(numberOfProducts, is(0));
    }

    @Test
    @DisplayName("Should return a specific product when product with the given name exist")
    void getProductByProductNameTestWhenProductExist() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        Product findGivenProduct = productService.getProductByProductName("BOOTS");

        // then
        assertThat(findGivenProduct, equalTo(boots));
    }

    @Test
    @DisplayName("Should return a null value in case of absence of existence a specified product")
    void getProductByProductNameTestWhenProductDoestExist() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        Product findGivenProduct = productService.getProductByProductName("Balmain Jeans");

        // then
        assertThat(findGivenProduct, nullValue());
    }

    @Test
    @DisplayName("Should return a true when product with the given name is available")
    void isProductInWarehouseTestWhenProductIsAvailable() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductInWarehouse("BOOTS");

        // then
        assertTrue(isAvailable);
    }

    @Test
    @DisplayName("Should return a false when product with the given name is not available")
    void isProductInWarehouseTestWhenProductIsNotAvailable() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductInWarehouse("Guess");

        // then
        assertFalse(isAvailable);
    }

    @Test
    @DisplayName("Should return a true when product with the given name is available")
    void isProductExistByNameTestWhenPositive() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductExistByName("T-SHIRT");

        // then
        assertTrue(isAvailable);
    }

    @Test
    @DisplayName("Should return a false when product with the given name is not available")
    void isProductExistByNameTestWhenNegative() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductExistByName("");

        // then
        assertFalse(isAvailable);
    }

    @Test
    @DisplayName("Should return a true when product with the given ID number is available")
    void isProductExistByIdTestWhenPositive() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductExistById(2L);

        // then
        assertTrue(isAvailable);
    }

    @Test
    @DisplayName("Should return a false when product with the given ID number is not available")
    void isProductExistByIdTestWhenNegative() {
        // given
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0, 0.3, "Black", 4, "XL", "COTTON");
        Product boots = new Boots(2L, "BOOTS", 35.0, 0.3, "Black", 4, 38, true);
        List<Product> productList = Arrays.asList(cloth, boots);

        // when
        ProductService productService = new ProductServiceImpl(productList);
        boolean isAvailable = productService.isProductExistById(10L);

        // then
        assertFalse(isAvailable);
    }

}