package com.example.mitrais.ProjectWebSimple.service;

import com.example.mitrais.ProjectWebSimple.dao.ProductRepository;
import com.example.mitrais.ProjectWebSimple.exception.ProductNotFoundException;
import com.example.mitrais.ProjectWebSimple.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();

    @Autowired
    public ProductServiceImpl() {
        ProductRepository pr = new ProductRepository();
        for(int i = 0; i < pr.getLength();i++) {
            productRepo.put(pr.getProduct(i).getId(), pr.getProduct(i));
        }
    }

    @Override
    public void create(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void update(String id, Product product) {
        if(!productRepo.containsKey(id)) {throw new ProductNotFoundException();}
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public void delete(String id) {
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getAll() {
        return productRepo.values();
    }

    @Override
    public Product get(String id) {
        return productRepo.get(id);
    }

    @Override
    public String getName(String name) {
        return "";
    }
}
