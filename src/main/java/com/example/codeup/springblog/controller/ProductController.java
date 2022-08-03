package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    // dependency injection
    private ProductRepository productDao;

    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }

    // get all records with JPA
    @GetMapping("/products")
    public String showAllProducts(Model vModel) {
        List<Product> productList = productDao.findAll();
        // pass products to view
        vModel.addAttribute("products", productList);
        return "/products/index";
    }

    // create a record with JPA
    @GetMapping("/products/create/test")
    public String createProducts() {
        Product product = new Product ("Pug", 20000);
        productDao.save(product);
        return "redirect:/products/index";
    }

    // delete a record with JPA
    @GetMapping("/products/delete/test")
    public String deleteProducts() {
        productDao.deleteById(1L);
        return "redirect:/products";
    }

    // getting a specific record with JPA
    @GetMapping("/products/test/{id}")
    public String getProduct(@PathVariable long id) {
        System.out.println(productDao.findById(id).get());
        return "redirect:/products";
    }
}
