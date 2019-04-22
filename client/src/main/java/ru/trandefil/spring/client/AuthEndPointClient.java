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

    public static AuthEndPoint getAuthEndPoint(String path) throws MalformedURLException {
/*        final URL url = new URL(path);
        final String lp = "AuthEndPointImplService";
        final String ns = "http://endpoint.spring.trandefil.ru/";
        final QName qName = new QName(ns, lp);
        final AuthEndPoint result = Service.create(url, qName).getPort(AuthEndPoint.class);*/
        final AuthEndPoint result = new AuthEndPointImplService().getAuthEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    public static UserEndPoint getUserEndPoint(String path) throws MalformedURLException {
/*        final URL url = new URL(path);
        final String lp = "UserEndPointImplService";
        final String ns = "http://endpoint.spring.trandefil.ru/";
        final QName qName = new QName(ns, lp);
        final UserEndPoint result = Service.create(url, qName).getPort(UserEndPoint.class);*/
        final UserEndPoint result = new UserEndPointImplService().getUserEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void checkCookie(BindingProvider bindingProvider) {
        Map<String, List<String>> headers =
                (Map<String, List<String>>) bindingProvider.getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        if (headers != null) {
            List<String> cookieValue = headers.get("Set-Cookie");
            System.out.println("Set-Cookie check(): " + cookieValue);
//            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,headers);
            bindingProvider.getRequestContext().put(
                    MessageContext.HTTP_REQUEST_HEADERS,
                    Collections.singletonMap("Cookie", cookieValue));
        } else System.out.println("headers is null");

    }

    public static void anothercode(BindingProvider bindingProvider){
        Map<String, List> reqHeaders = (Map<String, List>) ((BindingProvider) portType).getRequestContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        reqHeaders = new HashMap<String, List>();
        List list = new ArrayList();
        list.add(sessionCookie);
        reqHeaders.put("Cookie", list);
        ((BindingProvider) portType).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, reqHeaders);
    }

    @SuppressWarnings("unchecked")
    public static void exchange(BindingProvider bindingProvider1, BindingProvider bindingProvider2) {
        Map<String, List<String>> headers =
                (Map<String, List<String>>) bindingProvider1.getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        List<String> cookieValue = headers.get("Set-Cookie");
        System.out.println("Set-Cookie exchange(): " + cookieValue);

        Map<String, List<String>> headers2 =
                (Map<String, List<String>>) bindingProvider2.getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        if(headers2 == null){
            headers2 = new HashMap<>();
        }
        headers2.put("Cookie", cookieValue);
        bindingProvider2.getRequestContext().put(
                MessageContext.HTTP_RESPONSE_HEADERS,
                headers2
        );
    }

    public static void main(String[] args) throws MalformedURLException {

/*        UserEndPoint userEndPoint = new UserEndPointImplService().getUserEndPointImplPort();
        Session session = userEndPoint.getSession("root", "root");
        if (session != null) {
            List<UserDTO> allUsers = userEndPoint.getAllUsers(session);
            allUsers.forEach(System.out::println);    }*/
        AuthEndPoint authEndPoint = getAuthEndPoint("http://localhost:8080/services/authEndPoint?wsdl");
        checkCookie((BindingProvider) authEndPoint);
        Result res = authEndPoint.login("root", "root");
        System.out.println(res.isSuccess());
        checkCookie((BindingProvider) authEndPoint);
//        exchange((BindingProvider) authEndPoint,(BindingProvider) authEndPoint);
/*        authEndPoint = (AuthEndPoint)checkCookie((BindingProvider) authEndPoint);
        exchange((BindingProvider) authEndPoint,(BindingProvider) authEndPoint);
        authEndPoint = (AuthEndPoint)checkCookie((BindingProvider) authEndPoint);
        exchange((BindingProvider) authEndPoint,(BindingProvider) authEndPoint);
        authEndPoint = (AuthEndPoint)checkCookie((BindingProvider) authEndPoint);
        exchange((BindingProvider) authEndPoint,(BindingProvider) authEndPoint);
        authEndPoint = (AuthEndPoint)checkCookie((BindingProvider) authEndPoint);*/
        System.out.println(authEndPoint.logged().getName());
        checkCookie((BindingProvider) authEndPoint);
        System.out.println(authEndPoint.logged().getName());
        final UserEndPoint userEndPoint = getUserEndPoint("bla");
        exchange((BindingProvider)authEndPoint,(BindingProvider)userEndPoint);
        checkCookie((BindingProvider)userEndPoint);
        System.out.println("from user end point : " + userEndPoint.logged().getName());

    }

}
