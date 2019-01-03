package com.example.mitrais.ProjectWebSimple.dao;

import com.example.mitrais.ProjectWebSimple.model.Product;

public class ProductRepository {
    private Product[] products = {new Product("1", "Honey"),
                                  new Product("2", "Orange"),
                                  new Product("3", "Apple"),
                                  new Product("4", "Pineapple")};

    public Product getProduct(int id) {
        return products[id];
    }

    public int getLength() {
        return products.length;
    }
}
