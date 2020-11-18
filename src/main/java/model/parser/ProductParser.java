package model.parser;

import model.Boots;
import model.Cloth;
import model.Product;

public class ProductParser {

    public static Product parseProduct(String data, ProductType productType) {
        switch (productType) {
            case CLOTH:
                return convertToCloth(data);
            case BOOTS:
                return convertToBoots(data);
            default:
                return null;
        }
    }

    private static Cloth convertToCloth(String data) {
        String[] productInfo = data.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        Double price = Double.parseDouble(productInfo[2]);
        Double weight = Double.parseDouble(productInfo[3]);
        String color = productInfo[4];
        Integer productCount = Integer.parseInt(productInfo[5]);
        String size = productInfo[6];
        String material = productInfo[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Boots convertToBoots(String data) {
        String[] productInfo = data.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        Double price = Double.parseDouble(productInfo[2]);
        Double weight = Double.parseDouble(productInfo[3]);
        String color = productInfo[4];
        Integer productCount = Integer.parseInt(productInfo[5]);
        Integer size = Integer.parseInt(productInfo[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInfo[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }
}
