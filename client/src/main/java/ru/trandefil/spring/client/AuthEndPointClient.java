package ru.trandefil.spring.client;

import ru.trandefil.spring.endpoint.AuthEndPointImplService;
import ru.trandefil.spring.endpoint.UserEndPointImplService;
import ru.trandefil.spring.generated.AuthEndPoint;
import ru.trandefil.spring.generated.Result;
import ru.trandefil.spring.generated.UserEndPoint;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.util.*;

public class AuthEndPointClient {

    public static AuthEndPoint getAuthEndPoint() throws MalformedURLException {
        final AuthEndPoint result = new AuthEndPointImplService().getAuthEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    public static UserEndPoint getUserEndPoint(BindingProvider previusProvider) throws MalformedURLException {
        final UserEndPoint result = new UserEndPointImplService().getUserEndPointImplPort();
        Map<String, List<String>> incoming =
                (Map<String, List<String>>) previusProvider.getRequestContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        final BindingProvider bindingProvider = (BindingProvider) result;
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,incoming);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void checkCookie(BindingProvider bindingProvider) {
        Map<String, List<String>> headers1 =
                (Map<String, List<String>>) bindingProvider.getRequestContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        System.out.println("request context : " + headers1);

        Map<String, List<String>> headers =
                (Map<String, List<String>>) bindingProvider.getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        System.out.println("respronse context : " + headers);
 /*         bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,headers);
      if (headers == null) {
            System.out.println("headers is null");
        } else {
            System.out.println(headers);
            List<String> cookieValue = headers.get("Set-Cookie");
            List<String> cookie = headers.get("Cookie");
            System.out.println("Set-Cookie check(): " + cookieValue);
            System.out.println("Cookie check(): " + cookie);
            if(cookie == null){
                cookie = cookieValue;

            }
            headers.put("Cookie", cookie);
            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,headers);
            bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        }

        System.out.println(headers);
        System.out.println(headers1);
        return ;*/
    }

    public static void main(String[] args) throws MalformedURLException {
        AuthEndPoint authEndPoint = getAuthEndPoint();
        System.out.println(authEndPoint.login("root","root").isSuccess());
        checkCookie((BindingProvider)authEndPoint);
        System.out.println(authEndPoint.logged().getName());
        checkCookie((BindingProvider)authEndPoint);
        System.out.println(authEndPoint.logged().getName());
        checkCookie((BindingProvider)authEndPoint);
        System.out.println(authEndPoint.logged().getName());


    }

}
