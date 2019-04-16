package ru.trandefil.spring.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.trandefil.spring.generated.UserEndPoint;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-16T13:35:44.344+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "UserEndPointImplService", 
                  wsdlLocation = "http://localhost:8080/services/userEndPoint?wsdl",
                  targetNamespace = "http://endpoint.spring.trandefil.ru/") 
public class UserEndPointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.spring.trandefil.ru/", "UserEndPointImplService");
    public final static QName UserEndPointImplPort = new QName("http://endpoint.spring.trandefil.ru/", "UserEndPointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/userEndPoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserEndPointImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/services/userEndPoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserEndPointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserEndPointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserEndPointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns UserEndPoint
     */
    @WebEndpoint(name = "UserEndPointImplPort")
    public UserEndPoint getUserEndPointImplPort() {
        return super.getPort(UserEndPointImplPort, UserEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserEndPoint
     */
    @WebEndpoint(name = "UserEndPointImplPort")
    public UserEndPoint getUserEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(UserEndPointImplPort, UserEndPoint.class, features);
    }

}
