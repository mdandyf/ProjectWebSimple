package com.example.mitrais.ProjectWebSimple.controller;

import com.example.mitrais.ProjectWebSimple.model.Product;
import com.example.mitrais.ProjectWebSimple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>("Product is successfully created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.update(id, product);
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.delete(id);
        return new ResponseEntity<>("product is successfully deleted", HttpStatus.OK);
    }


}
