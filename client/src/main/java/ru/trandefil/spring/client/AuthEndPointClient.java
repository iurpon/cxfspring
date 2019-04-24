package ru.trandefil.spring.client;

import ru.trandefil.spring.endpoint.AuthEndPointImplService;
import ru.trandefil.spring.endpoint.ProjectEndPointImplService;
import ru.trandefil.spring.endpoint.UserEndPointImplService;
import ru.trandefil.spring.generated.AuthEndPoint;
import ru.trandefil.spring.generated.ProjectEndPoint;
import ru.trandefil.spring.generated.UserEndPoint;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthEndPointClient {

    public static List<String> cookieValue;

    public static AuthEndPoint getAuthEndPoint() throws MalformedURLException {
        final AuthEndPoint result = new AuthEndPointImplService().getAuthEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static UserEndPoint getUserEndPoint() throws MalformedURLException {
        final UserEndPoint result = new UserEndPointImplService().getUserEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        if (cookieValue != null) {
            Map<String, List<String>> headers =
                    (Map<String, List<String>>) bindingProvider.getRequestContext()
                            .get(MessageContext.HTTP_REQUEST_HEADERS);
            if (headers == null) {
                headers = new HashMap<>();
                bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
            }
            headers.put("Cookie", cookieValue);
            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        }
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static ProjectEndPoint getProjectEndPoint() throws MalformedURLException {
        final ProjectEndPoint result = new ProjectEndPointImplService().getProjectEndPointImplPort();
        final BindingProvider bindingProvider = (BindingProvider) result;
        if (cookieValue != null) {
            Map<String, List<String>> headers =
                    (Map<String, List<String>>) bindingProvider.getRequestContext()
                            .get(MessageContext.HTTP_REQUEST_HEADERS);
            if (headers == null) {
                headers = new HashMap<>();
                bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
            }
            headers.put("Cookie", cookieValue);
            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        }
        bindingProvider.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void storeCookie(BindingProvider bindingProvider) {
        Map<String, List<String>> headers1 =
                (Map<String, List<String>>) bindingProvider.getRequestContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        Map<String, List<String>> headers =
                (Map<String, List<String>>) bindingProvider.getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        if (cookieValue == null) {
            cookieValue = headers.get("Set-Cookie");
            System.out.println(cookieValue);
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        AuthEndPoint authEndPoint = getAuthEndPoint();
        System.out.println(authEndPoint.login("root", "root").isSuccess());
        storeCookie((BindingProvider) authEndPoint);
        UserEndPoint userEndPoint = getUserEndPoint();
        userEndPoint.getAllUsers().forEach(System.out::println);
        ProjectEndPoint projectEndPoint = getProjectEndPoint();
        projectEndPoint.saveProject("rootPr1","rootPr1");
        projectEndPoint.getAllProjects().forEach(System.out::println);

    }
}
