
package ru.trandefil.spring.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.trandefil.spring.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Logged_QNAME = new QName("http://generated.spring.trandefil.ru/", "logged");
    private final static QName _LoggedResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "loggedResponse");
    private final static QName _Login_QNAME = new QName("http://generated.spring.trandefil.ru/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "loginResponse");
    private final static QName _Logout_QNAME = new QName("http://generated.spring.trandefil.ru/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "logoutResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.spring.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Logged }
     * 
     */
    public Logged createLogged() {
        return new Logged();
    }

    /**
     * Create an instance of {@link LoggedResponse }
     * 
     */
    public LoggedResponse createLoggedResponse() {
        return new LoggedResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link LoggedUser }
     * 
     */
    public LoggedUser createLoggedUser() {
        return new LoggedUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logged }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "logged")
    public JAXBElement<Logged> createLogged(Logged value) {
        return new JAXBElement<Logged>(_Logged_QNAME, Logged.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoggedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "loggedResponse")
    public JAXBElement<LoggedResponse> createLoggedResponse(LoggedResponse value) {
        return new JAXBElement<LoggedResponse>(_LoggedResponse_QNAME, LoggedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

}
