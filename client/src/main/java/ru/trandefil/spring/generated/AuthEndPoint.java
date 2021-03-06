package ru.trandefil.spring.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-24T11:58:49.683+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://generated.spring.trandefil.ru/", name = "AuthEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface AuthEndPoint {

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.LoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.Result login(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebMethod
    @RequestWrapper(localName = "logged", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.Logged")
    @ResponseWrapper(localName = "loggedResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.LoggedResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.UserDTO logged();
}
