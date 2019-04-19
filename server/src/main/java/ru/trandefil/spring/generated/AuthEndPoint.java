package ru.trandefil.spring.generated;

import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.dto.Result;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AuthEndPoint {

    @WebMethod
    Result login(@WebParam(name = "name") String name, @WebParam(name = "password") String password);

    @WebMethod
    Result logout();

    @WebMethod
    UserDTO logged();

}
