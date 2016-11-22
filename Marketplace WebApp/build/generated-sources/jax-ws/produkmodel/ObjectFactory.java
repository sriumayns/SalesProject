
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

    private final static QName _AddLike_QNAME = new QName("http://ProdukModel/", "addLike");
    private final static QName _AddLikeResponse_QNAME = new QName("http://ProdukModel/", "addLikeResponse");
    private final static QName _DelLike_QNAME = new QName("http://ProdukModel/", "delLike");
    private final static QName _DelLikeResponse_QNAME = new QName("http://ProdukModel/", "delLikeResponse");
    private final static QName _Hello_QNAME = new QName("http://ProdukModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ProdukModel/", "helloResponse");
    private final static QName _IsLiked_QNAME = new QName("http://ProdukModel/", "isLiked");
    private final static QName _IsLikedResponse_QNAME = new QName("http://ProdukModel/", "isLikedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: produkmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddLike }
     * 
     */
    public AddLike createAddLike() {
        return new AddLike();
    }

    /**
     * Create an instance of {@link AddLikeResponse }
     * 
     */
    public AddLikeResponse createAddLikeResponse() {
        return new AddLikeResponse();
    }

    /**
     * Create an instance of {@link DelLike }
     * 
     */
    public DelLike createDelLike() {
        return new DelLike();
    }

    /**
     * Create an instance of {@link DelLikeResponse }
     * 
     */
    public DelLikeResponse createDelLikeResponse() {
        return new DelLikeResponse();
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
     * Create an instance of {@link IsLiked }
     * 
     */
    public IsLiked createIsLiked() {
        return new IsLiked();
    }

    /**
     * Create an instance of {@link IsLikedResponse }
     * 
     */
    public IsLikedResponse createIsLikedResponse() {
        return new IsLikedResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "addLike")
    public JAXBElement<AddLike> createAddLike(AddLike value) {
        return new JAXBElement<AddLike>(_AddLike_QNAME, AddLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "addLikeResponse")
    public JAXBElement<AddLikeResponse> createAddLikeResponse(AddLikeResponse value) {
        return new JAXBElement<AddLikeResponse>(_AddLikeResponse_QNAME, AddLikeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "delLike")
    public JAXBElement<DelLike> createDelLike(DelLike value) {
        return new JAXBElement<DelLike>(_DelLike_QNAME, DelLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "delLikeResponse")
    public JAXBElement<DelLikeResponse> createDelLikeResponse(DelLikeResponse value) {
        return new JAXBElement<DelLikeResponse>(_DelLikeResponse_QNAME, DelLikeResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link IsLiked }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "isLiked")
    public JAXBElement<IsLiked> createIsLiked(IsLiked value) {
        return new JAXBElement<IsLiked>(_IsLiked_QNAME, IsLiked.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsLikedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "isLikedResponse")
    public JAXBElement<IsLikedResponse> createIsLikedResponse(IsLikedResponse value) {
        return new JAXBElement<IsLikedResponse>(_IsLikedResponse_QNAME, IsLikedResponse.class, null, value);
    }

}
