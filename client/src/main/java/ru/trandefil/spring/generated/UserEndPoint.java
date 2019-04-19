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
 * 2019-04-19T11:41:37.187+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://generated.spring.trandefil.ru/", name = "UserEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndPoint {

    @WebMethod
    @RequestWrapper(localName = "registry", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.Registry")
    @ResponseWrapper(localName = "registryResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.RegistryResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.Session registry(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebMethod
    @RequestWrapper(localName = "getAllUsers", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetAllUsers")
    @ResponseWrapper(localName = "getAllUsersResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetAllUsersResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.trandefil.spring.generated.UserDTO> getAllUsers(
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "getUserByName", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetUserByName")
    @ResponseWrapper(localName = "getUserByNameResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetUserByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.UserDTO getUserByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.UserDTO updateUser(
        @WebParam(name = "user", targetNamespace = "")
        ru.trandefil.spring.generated.UserDTO user,
        @WebParam(name = "pass", targetNamespace = "")
        java.lang.String pass,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "deleteUserByName", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteUserByName")
    @ResponseWrapper(localName = "deleteUserByNameResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteUserByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteUserByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "getSession", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetSession")
    @ResponseWrapper(localName = "getSessionResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.Session getSession(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebMethod
    @RequestWrapper(localName = "userLogout", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UserLogout")
    @ResponseWrapper(localName = "userLogoutResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UserLogoutResponse")
    public void userLogout(
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "saveUser", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.SaveUser")
    @ResponseWrapper(localName = "saveUserResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.SaveUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.UserDTO saveUser(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "pass", targetNamespace = "")
        java.lang.String pass,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role,
        @WebParam(name = "arg3", targetNamespace = "")
        ru.trandefil.spring.generated.Session arg3
    );
}
