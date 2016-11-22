
package akunmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the akunmodel package. 
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

    private final static QName _Hello_QNAME = new QName("http://AkunModel/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://AkunModel/", "helloResponse");
    private final static QName _IsValid_QNAME = new QName("http://AkunModel/", "isValid");
    private final static QName _IsValidResponse_QNAME = new QName("http://AkunModel/", "isValidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: akunmodel
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link IsValid }
     * 
     */
    public IsValid createIsValid() {
        return new IsValid();
    }

    /**
     * Create an instance of {@link IsValidResponse }
     * 
     */
    public IsValidResponse createIsValidResponse() {
        return new IsValidResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AkunModel/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AkunModel/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AkunModel/", name = "isValid")
    public JAXBElement<IsValid> createIsValid(IsValid value) {
        return new JAXBElement<IsValid>(_IsValid_QNAME, IsValid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AkunModel/", name = "isValidResponse")
    public JAXBElement<IsValidResponse> createIsValidResponse(IsValidResponse value) {
        return new JAXBElement<IsValidResponse>(_IsValidResponse_QNAME, IsValidResponse.class, null, value);
    }

}
