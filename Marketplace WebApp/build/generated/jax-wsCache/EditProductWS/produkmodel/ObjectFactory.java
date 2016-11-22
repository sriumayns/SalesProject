
package produkmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the produkmodel package. 
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

    private final static QName _GetProductByID_QNAME = new QName("http://ProdukModel/", "getProductByID");
    private final static QName _GetProductByIDResponse_QNAME = new QName("http://ProdukModel/", "getProductByIDResponse");
    private final static QName _Hello_QNAME = new QName("http://ProdukModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ProdukModel/", "helloResponse");
    private final static QName _UpdateProduk_QNAME = new QName("http://ProdukModel/", "updateProduk");
    private final static QName _UpdateProdukResponse_QNAME = new QName("http://ProdukModel/", "updateProdukResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: produkmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductByID }
     * 
     */
    public GetProductByID createGetProductByID() {
        return new GetProductByID();
    }

    /**
     * Create an instance of {@link GetProductByIDResponse }
     * 
     */
    public GetProductByIDResponse createGetProductByIDResponse() {
        return new GetProductByIDResponse();
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
     * Create an instance of {@link UpdateProduk }
     * 
     */
    public UpdateProduk createUpdateProduk() {
        return new UpdateProduk();
    }

    /**
     * Create an instance of {@link UpdateProdukResponse }
     * 
     */
    public UpdateProdukResponse createUpdateProdukResponse() {
        return new UpdateProdukResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getProductByID")
    public JAXBElement<GetProductByID> createGetProductByID(GetProductByID value) {
        return new JAXBElement<GetProductByID>(_GetProductByID_QNAME, GetProductByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getProductByIDResponse")
    public JAXBElement<GetProductByIDResponse> createGetProductByIDResponse(GetProductByIDResponse value) {
        return new JAXBElement<GetProductByIDResponse>(_GetProductByIDResponse_QNAME, GetProductByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProduk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "updateProduk")
    public JAXBElement<UpdateProduk> createUpdateProduk(UpdateProduk value) {
        return new JAXBElement<UpdateProduk>(_UpdateProduk_QNAME, UpdateProduk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProdukResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "updateProdukResponse")
    public JAXBElement<UpdateProdukResponse> createUpdateProdukResponse(UpdateProdukResponse value) {
        return new JAXBElement<UpdateProdukResponse>(_UpdateProdukResponse_QNAME, UpdateProdukResponse.class, null, value);
    }

}
