package ru.trandefil.spring.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import ru.trandefil.spring.generated.TaskEndPoint;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-22T15:30:06.208+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "TaskEndPointImplService", 
                  wsdlLocation = "http://localhost:8080/services/taskEndPoint?wsdl",
                  targetNamespace = "http://endpoint.spring.trandefil.ru/") 
public class TaskEndPointImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.spring.trandefil.ru/", "TaskEndPointImplService");
    public final static QName TaskEndPointImplPort = new QName("http://endpoint.spring.trandefil.ru/", "TaskEndPointImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/taskEndPoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TaskEndPointImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/services/taskEndPoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TaskEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskEndPointImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TaskEndPointImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TaskEndPointImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TaskEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns TaskEndPoint
     */
    @WebEndpoint(name = "TaskEndPointImplPort")
    public TaskEndPoint getTaskEndPointImplPort() {
        return super.getPort(TaskEndPointImplPort, TaskEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TaskEndPoint
     */
    @WebEndpoint(name = "TaskEndPointImplPort")
    public TaskEndPoint getTaskEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(TaskEndPointImplPort, TaskEndPoint.class, features);
    }

}
