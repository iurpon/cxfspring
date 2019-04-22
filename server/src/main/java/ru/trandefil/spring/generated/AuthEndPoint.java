package ru.trandefil.spring.generated;

import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AuthEndPoint {

    @WebMethod
    Result login(@WebParam(name = "name") String name, @WebParam(name = "password") String password);

    @WebMethod
    UserDTO logged();

}
