
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

    private final static QName _GetProduk_QNAME = new QName("http://ProdukModel/", "getProduk");
    private final static QName _GetProdukResponse_QNAME = new QName("http://ProdukModel/", "getProdukResponse");
    private final static QName _GetYourProduct_QNAME = new QName("http://ProdukModel/", "getYourProduct");
    private final static QName _GetYourProductResponse_QNAME = new QName("http://ProdukModel/", "getYourProductResponse");
    private final static QName _Hello_QNAME = new QName("http://ProdukModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ProdukModel/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: produkmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProduk }
     * 
     */
    public GetProduk createGetProduk() {
        return new GetProduk();
    }

    /**
     * Create an instance of {@link GetProdukResponse }
     * 
     */
    public GetProdukResponse createGetProdukResponse() {
        return new GetProdukResponse();
    }

    /**
     * Create an instance of {@link GetYourProduct }
     * 
     */
    public GetYourProduct createGetYourProduct() {
        return new GetYourProduct();
    }

    /**
     * Create an instance of {@link GetYourProductResponse }
     * 
     */
    public GetYourProductResponse createGetYourProductResponse() {
        return new GetYourProductResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getProduk")
    public JAXBElement<GetProduk> createGetProduk(GetProduk value) {
        return new JAXBElement<GetProduk>(_GetProduk_QNAME, GetProduk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProdukResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getProdukResponse")
    public JAXBElement<GetProdukResponse> createGetProdukResponse(GetProdukResponse value) {
        return new JAXBElement<GetProdukResponse>(_GetProdukResponse_QNAME, GetProdukResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYourProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getYourProduct")
    public JAXBElement<GetYourProduct> createGetYourProduct(GetYourProduct value) {
        return new JAXBElement<GetYourProduct>(_GetYourProduct_QNAME, GetYourProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYourProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "getYourProductResponse")
    public JAXBElement<GetYourProductResponse> createGetYourProductResponse(GetYourProductResponse value) {
        return new JAXBElement<GetYourProductResponse>(_GetYourProductResponse_QNAME, GetYourProductResponse.class, null, value);
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

}
