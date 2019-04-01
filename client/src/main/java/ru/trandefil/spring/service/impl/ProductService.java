package ru.trandefil.spring.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-01T15:27:06.628+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "productService", 
                  wsdlLocation = "http://localhost:8080/server/services/productService?wsdl",
                  targetNamespace = "http://impl.service.spring.trandefil.ru/") 
public class ProductService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.service.spring.trandefil.ru/", "productService");
    public final static QName ProductServiceImplPort = new QName("http://impl.service.spring.trandefil.ru/", "ProductServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/server/services/productService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProductService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/server/services/productService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProductService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProductService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns ProductService
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ru.trandefil.spring.service.ProductService getProductServiceImplPort() {
        return super.getPort(ProductServiceImplPort, ru.trandefil.spring.service.ProductService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductService
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ru.trandefil.spring.service.ProductService getProductServiceImplPort(WebServiceFeature... features) {
        return super.getPort(ProductServiceImplPort, ru.trandefil.spring.service.ProductService.class, features);
    }

}
