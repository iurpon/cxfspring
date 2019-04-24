package ru.trandefil.spring.generated;

import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint {

    @WebMethod
    boolean deleteUserByName(@WebParam(name = "name") String name);

    @WebMethod
    UserDTO updateUser(
            @WebParam(name = "user") UserDTO user,
            @WebParam(name = "pass") String pass);

    @WebMethod
    UserDTO saveUser(@WebParam(name = "name") String name,
                     @WebParam(name = "pass") String pass,
                     @WebParam(name = "role") String role);

    @WebMethod
    UserDTO getUserByName(@WebParam(name = "name") String name);

    @WebMethod
    List<UserDTO> getAllUsers();

    @WebMethod
    void userLogout();

    @WebMethod
    Session getSession(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

    @WebMethod
    Session registry(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

    @WebMethod
    Result logout();


}
