package ru.trandefil.spring.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-01T14:21:36.204+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://service.spring.trandefil.ru/", name = "ProductService")
@XmlSeeAlso({ObjectFactory.class})
public interface ProductService {

    @WebMethod
    @RequestWrapper(localName = "getAllProducts", targetNamespace = "http://service.spring.trandefil.ru/", className = "ru.trandefil.spring.service.GetAllProducts")
    @ResponseWrapper(localName = "getAllProductsResponse", targetNamespace = "http://service.spring.trandefil.ru/", className = "ru.trandefil.spring.service.GetAllProductsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.trandefil.spring.service.Product> getAllProducts();

    @WebMethod
    @RequestWrapper(localName = "getProduct", targetNamespace = "http://service.spring.trandefil.ru/", className = "ru.trandefil.spring.service.GetProduct")
    @ResponseWrapper(localName = "getProductResponse", targetNamespace = "http://service.spring.trandefil.ru/", className = "ru.trandefil.spring.service.GetProductResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.service.Product getProduct(
        @WebParam(name = "productId", targetNamespace = "")
        int productId
    );
}
