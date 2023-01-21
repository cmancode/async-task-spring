package com.carlosmantilla.asincronia.app.service;

import com.carlosmantilla.asincronia.app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() throws Exception {
        List<Product> producs = new ArrayList<>();
        Thread.sleep(1000);
        producs = Arrays.asList(new Product(1L,"PAPAYA"), new Product(2L,"MANGO"),
                new Product(3L,"MELÓN"), new Product(4L,"PAPA"));

        return producs;
    }

    public List<Product> getAllProducts() throws Exception {
        List<Product> producs = new ArrayList<>();
        Thread.sleep(3000);
        producs = Arrays.asList(new Product(5L,"SANDÍA"), new Product(6L,"PIÑA"),
                new Product(7L,"BANANO"), new Product(8L,"YUCA"));

        return producs;
    }

    public List<Product> getAllProducts2() throws Exception {
        List<Product> producs = new ArrayList<>();
        Thread.sleep(2000);
        producs = Arrays.asList(new Product(9L,"PERA"), new Product(10L,"COCO"),
                new Product(11L,"FRESA"), new Product(12L,"MELOCOTÓN"));

        return producs;
    }

}
