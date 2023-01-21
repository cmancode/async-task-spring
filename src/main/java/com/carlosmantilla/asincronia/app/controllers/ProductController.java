package com.carlosmantilla.asincronia.app.controllers;

import com.carlosmantilla.asincronia.app.model.Product;
import com.carlosmantilla.asincronia.app.service.ProductAsyncService;
import com.carlosmantilla.asincronia.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductAsyncService productAsyncService;

    @GetMapping
    public List<Product> getProducts() {
        List<Product> products1 = null;
        List<Product> products2 = null;
        List<Product> products3 = null;
        List<Product> result = null;

        try {
            products1 = productService.getProducts();
            products2 = productService.getAllProducts();
            products3 = productService.getAllProducts2();

            result = Stream.of(products1, products2, products3)
                    .flatMap(Collection::stream).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @GetMapping("products-async")
    public List<Product> getProductsAsync() {
        CompletableFuture<List<Product>> products1 = null;
        CompletableFuture<List<Product>> products2 = null;
        CompletableFuture<List<Product>> products3 = null;
        List<Product> result = null;

        try {
            products1 = productAsyncService.getProducts();
            products2 = productAsyncService.getAllProducts();
            products3 = productAsyncService.getAllProducts2();

            CompletableFuture.allOf(products1, products2, products3).join();

            result = Stream.of(products1.get(), products2.get(), products2.get())
                    .flatMap(Collection::stream).toList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
