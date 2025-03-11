package com.example.ss11_mvc.service;

import com.example.ss11_mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final List<Product> products = new ArrayList<Product>();
    static {
        products.add(new Product(1, "iPhone 16 Pro Max", 1199.99, 50));
        products.add(new Product(2, "Samsung Galaxy S25 Ultra", 1299.99, 45));
        products.add(new Product(3, "Google Pixel 9 Pro", 999.99, 30));
        products.add(new Product(4, "OnePlus 13", 799.99, 60));
        products.add(new Product(5, "Xiaomi 14", 699.99, 75));
        products.add(new Product(6, "Samsung Galaxy Z Flip 6", 1099.99, 25));
        products.add(new Product(7, "Vivo X100 Pro", 899.99, 40));
        products.add(new Product(8, "Oppo Find X7 Ultra", 949.99, 35));
        products.add(new Product(9, "Nothing Phone 2", 599.99, 80));
        products.add(new Product(10, "Motorola Edge 50 Pro", 649.99, 55));
    }
    public static List<Product> getProducts() {
        return products;
    }
}
