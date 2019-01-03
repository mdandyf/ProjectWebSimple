package com.example.mitrais.ProjectWebSimple.service;

import com.example.mitrais.ProjectWebSimple.model.Product;

public interface ProductService extends BaseService<Product, String> {
    String getName(String name);
}
