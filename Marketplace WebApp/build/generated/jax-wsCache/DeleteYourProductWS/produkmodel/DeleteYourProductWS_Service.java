
package produkmodel;

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
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DeleteYourProductWS", targetNamespace = "http://ProdukModel/", wsdlLocation = "http://localhost:8081/Marketplace_WebService/DeleteYourProductWS?wsdl")
public class DeleteYourProductWS_Service
    extends Service
{

    private final static URL DELETEYOURPRODUCTWS_WSDL_LOCATION;
    private final static WebServiceException DELETEYOURPRODUCTWS_EXCEPTION;
    private final static QName DELETEYOURPRODUCTWS_QNAME = new QName("http://ProdukModel/", "DeleteYourProductWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/Marketplace_WebService/DeleteYourProductWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DELETEYOURPRODUCTWS_WSDL_LOCATION = url;
        DELETEYOURPRODUCTWS_EXCEPTION = e;
    }

    public DeleteYourProductWS_Service() {
        super(__getWsdlLocation(), DELETEYOURPRODUCTWS_QNAME);
    }

    public DeleteYourProductWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), DELETEYOURPRODUCTWS_QNAME, features);
    }

    public DeleteYourProductWS_Service(URL wsdlLocation) {
        super(wsdlLocation, DELETEYOURPRODUCTWS_QNAME);
    }

    public DeleteYourProductWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DELETEYOURPRODUCTWS_QNAME, features);
    }

    public DeleteYourProductWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeleteYourProductWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DeleteYourProductWS
     */
    @WebEndpoint(name = "DeleteYourProductWSPort")
    public DeleteYourProductWS getDeleteYourProductWSPort() {
        return super.getPort(new QName("http://ProdukModel/", "DeleteYourProductWSPort"), DeleteYourProductWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DeleteYourProductWS
     */
    @WebEndpoint(name = "DeleteYourProductWSPort")
    public DeleteYourProductWS getDeleteYourProductWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ProdukModel/", "DeleteYourProductWSPort"), DeleteYourProductWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DELETEYOURPRODUCTWS_EXCEPTION!= null) {
            throw DELETEYOURPRODUCTWS_EXCEPTION;
        }
        return DELETEYOURPRODUCTWS_WSDL_LOCATION;
    }

}
