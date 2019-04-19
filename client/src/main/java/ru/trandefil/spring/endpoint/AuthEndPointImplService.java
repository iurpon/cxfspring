package ru.trandefil.spring.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.trandefil.spring.generated.AuthEndPoint;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-19T11:10:28.236+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "AuthEndPointImplService", 
                  wsdlLocation = "http://localhost:8080/services/authEndPoint?wsdl",
                  targetNamespace = "http://endpoint.spring.trandefil.ru/") 
public class AuthEndPointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.spring.trandefil.ru/", "AuthEndPointImplService");
    public final static QName AuthEndPointImplPort = new QName("http://endpoint.spring.trandefil.ru/", "AuthEndPointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/authEndPoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AuthEndPointImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/services/authEndPoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AuthEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AuthEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthEndPointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AuthEndPointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AuthEndPointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AuthEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns AuthEndPoint
     */
    @WebEndpoint(name = "AuthEndPointImplPort")
    public AuthEndPoint getAuthEndPointImplPort() {
        return super.getPort(AuthEndPointImplPort, AuthEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthEndPoint
     */
    @WebEndpoint(name = "AuthEndPointImplPort")
    public AuthEndPoint getAuthEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(AuthEndPointImplPort, AuthEndPoint.class, features);
    }

}
