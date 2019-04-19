package ru.trandefil.spring.client;

import ru.trandefil.spring.generated.AuthEndPoint;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class AuthEndPointClient {

    public static AuthEndPoint getInstance(String path) throws MalformedURLException {
            final URL url = new URL(path);
            final String lp = "SomeAuthEndPointService";
            final String ns = "http://tipaborziak.ru";
            final QName qName = new QName(ns,lp);
            final AuthEndPoint result = Service.create(url,qName).getPort(AuthEndPoint.class);
            final BindingProvider bindingProvider = (BindingProvider) result;
            bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);
            return result;
    }

    public static void main(String[] args) throws MalformedURLException {
        final AuthEndPoint authEndPoint = getInstance("http://localhost:8080/services/authEndPoint?wsdl");
        authEndPoint.login("root","root");
//        authEndPoint.logged().
    }
}
