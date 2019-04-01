package ru.trandefil.spring.service;

import ru.trandefil.spring.model.Product;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ProductService {

    @WebMethod
    public Product getProduct(@WebParam(name = "productId") int productId);

    @WebMethod
    public List<Product> getAllProducts();

}