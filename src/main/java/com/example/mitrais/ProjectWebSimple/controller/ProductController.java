package com.example.mitrais.ProjectWebSimple.controller;

import com.example.mitrais.ProjectWebSimple.dao.ProductRepository;
import com.example.mitrais.ProjectWebSimple.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
    private static Map<String, Product> productRepo = new HashMap<>();

    @Autowired
    public ProductController() {
        ProductRepository pr = new ProductRepository();
        for(int i = 0; i < pr.getLength();i++) {
            productRepo.put(pr.getProduct(i).getId(), pr.getProduct(i));
        }
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is successfully created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        return new ResponseEntity<>("product is successfully deleted", HttpStatus.OK);
    }


}
