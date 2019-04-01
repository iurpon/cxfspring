package ru.trandefil.spring.client;

import ru.trandefil.spring.service.Product;
import ru.trandefil.spring.service.ProductService;

import java.util.List;

public class ProductClient {

    public static void main(String[] args) {
        try {

            ProductService productService = new ProductService().getProductServiceImplPort();
            Product product = productService.getProduct(101);
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductCatg());
            List<Product> list = productService.getAllProducts();
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
