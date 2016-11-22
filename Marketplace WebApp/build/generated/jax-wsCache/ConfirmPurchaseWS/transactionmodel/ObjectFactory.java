
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

    private final static QName _AddPurchase_QNAME = new QName("http://TransactionModel/", "addPurchase");
    private final static QName _AddPurchaseResponse_QNAME = new QName("http://TransactionModel/", "addPurchaseResponse");
    private final static QName _GetPurchaseProduct_QNAME = new QName("http://TransactionModel/", "getPurchaseProduct");
    private final static QName _GetPurchaseProductResponse_QNAME = new QName("http://TransactionModel/", "getPurchaseProductResponse");
    private final static QName _Hello_QNAME = new QName("http://TransactionModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://TransactionModel/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: transactionmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPurchase }
     * 
     */
    public AddPurchase createAddPurchase() {
        return new AddPurchase();
    }

    /**
     * Create an instance of {@link AddPurchaseResponse }
     * 
     */
    public AddPurchaseResponse createAddPurchaseResponse() {
        return new AddPurchaseResponse();
    }

    /**
     * Create an instance of {@link GetPurchaseProduct }
     * 
     */
    public GetPurchaseProduct createGetPurchaseProduct() {
        return new GetPurchaseProduct();
    }

    /**
     * Create an instance of {@link GetPurchaseProductResponse }
     * 
     */
    public GetPurchaseProductResponse createGetPurchaseProductResponse() {
        return new GetPurchaseProductResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPurchase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "addPurchase")
    public JAXBElement<AddPurchase> createAddPurchase(AddPurchase value) {
        return new JAXBElement<AddPurchase>(_AddPurchase_QNAME, AddPurchase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPurchaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "addPurchaseResponse")
    public JAXBElement<AddPurchaseResponse> createAddPurchaseResponse(AddPurchaseResponse value) {
        return new JAXBElement<AddPurchaseResponse>(_AddPurchaseResponse_QNAME, AddPurchaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchaseProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getPurchaseProduct")
    public JAXBElement<GetPurchaseProduct> createGetPurchaseProduct(GetPurchaseProduct value) {
        return new JAXBElement<GetPurchaseProduct>(_GetPurchaseProduct_QNAME, GetPurchaseProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchaseProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionModel/", name = "getPurchaseProductResponse")
    public JAXBElement<GetPurchaseProductResponse> createGetPurchaseProductResponse(GetPurchaseProductResponse value) {
        return new JAXBElement<GetPurchaseProductResponse>(_GetPurchaseProductResponse_QNAME, GetPurchaseProductResponse.class, null, value);
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
