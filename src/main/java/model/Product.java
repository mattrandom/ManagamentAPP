package model;

public abstract class Product {
    public static final String PRODUCT_SEPARATOR = " - ";

    private Long id;
    private String productName;
    private Double price;
    private Double weight;
    private String color;
    private Integer productCount;

    public Product(Long id, String productName, Double price, Double weight, String color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR + price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }
}
