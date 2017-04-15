
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WService", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/SOAP_SERVER/WService?wsdl")
public class WService
    extends Service
{

    private final static URL WSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSERVICE_EXCEPTION;
    private final static QName WSERVICE_QNAME = new QName("http://ws/", "WService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/SOAP_SERVER/WService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSERVICE_WSDL_LOCATION = url;
        WSERVICE_EXCEPTION = e;
    }

    public WService() {
        super(__getWsdlLocation(), WSERVICE_QNAME);
    }

    public WService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSERVICE_QNAME, features);
    }

    public WService(URL wsdlLocation) {
        super(wsdlLocation, WSERVICE_QNAME);
    }

    public WService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSERVICE_QNAME, features);
    }

    public WService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WrestleService
     */
    @WebEndpoint(name = "WrestleServicePort")
    public WrestleService getWrestleServicePort() {
        return super.getPort(new QName("http://ws/", "WrestleServicePort"), WrestleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WrestleService
     */
    @WebEndpoint(name = "WrestleServicePort")
    public WrestleService getWrestleServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "WrestleServicePort"), WrestleService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSERVICE_EXCEPTION!= null) {
            throw WSERVICE_EXCEPTION;
        }
        return WSERVICE_WSDL_LOCATION;
    }

}
