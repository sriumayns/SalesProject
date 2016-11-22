
package transactionmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the transactionmodel package. 
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

    private final static QName _GetPurchase_QNAME = new QName("http://TransactionModel/", "getPurchase");
    private final static QName _GetPurchaseResponse_QNAME = new QName("http://TransactionModel/", "getPurchaseResponse");
    private final static QName _GetSales_QNAME = new QName("http://TransactionModel/", "getSales");
    private final static QName _GetSalesResponse_QNAME = new QName("http://TransactionModel/", "getSalesResponse");
    private final static QName _Hello_QNAME = new QName("http://TransactionModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://TransactionModel/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: transactionmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPurchase }
     * 
     */
    public GetPurchase createGetPurchase() {
        return new GetPurchase();
    }

    /**
     * Create an instance of {@link GetPurchaseResponse }
     * 
     */
    public GetPurchaseResponse createGetPurchaseResponse() {
        return new GetPurchaseResponse();
    }

    /**
     * Create an instance of {@link GetSales }
     * 
     */
    public GetSales createGetSales() {
        return new GetSales();
    }

    /**
     * Create an instance of {@link GetSalesResponse }
     * 
     */
    public GetSalesResponse createGetSalesResponse() {
        return new GetSalesResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getPurchase")
    public JAXBElement<GetPurchase> createGetPurchase(GetPurchase value) {
        return new JAXBElement<GetPurchase>(_GetPurchase_QNAME, GetPurchase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getPurchaseResponse")
    public JAXBElement<GetPurchaseResponse> createGetPurchaseResponse(GetPurchaseResponse value) {
        return new JAXBElement<GetPurchaseResponse>(_GetPurchaseResponse_QNAME, GetPurchaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getSales")
    public JAXBElement<GetSales> createGetSales(GetSales value) {
        return new JAXBElement<GetSales>(_GetSales_QNAME, GetSales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getSalesResponse")
    public JAXBElement<GetSalesResponse> createGetSalesResponse(GetSalesResponse value) {
        return new JAXBElement<GetSalesResponse>(_GetSalesResponse_QNAME, GetSalesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
