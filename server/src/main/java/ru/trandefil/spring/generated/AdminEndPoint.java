package ru.trandefil.spring.generated;


import ru.trandefil.spring.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AdminEndPoint {

    @WebMethod
    void saveJson(@WebParam(name = "session") Session session);

    @WebMethod
    void loadJson(@WebParam(name = "session") Session session);

    @WebMethod
    void clearJson(@WebParam(name = "session") Session session);

}