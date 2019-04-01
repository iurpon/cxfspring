package ru.trandefil.spring.service.impl;


import java.util.List;

import javax.jws.WebService;

import ru.trandefil.spring.mock.ProductServiceMockDaoImpl;
import ru.trandefil.spring.model.Product;
import ru.trandefil.spring.service.ProductService;

//mention endpoint interface and serviceName
@WebService(endpointInterface = "ru.trandefil.spring.service.ProductService", serviceName = "productService")
public class ProductServiceImpl implements ProductService {

    private ProductServiceMockDaoImpl productServiceMockImpl;

    public void setProductServiceMockImpl(ProductServiceMockDaoImpl productServiceMockImpl) {
        this.productServiceMockImpl = productServiceMockImpl;
    }

    @Override
    public Product getProduct(int productId) {
        return productServiceMockImpl.getProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productServiceMockImpl.getAllProducts();
    }

}