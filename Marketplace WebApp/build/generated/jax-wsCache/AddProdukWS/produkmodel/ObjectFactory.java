
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

    private final static QName _TambahProduk_QNAME = new QName("http://ProdukModel/", "tambahProduk");
    private final static QName _TambahProdukResponse_QNAME = new QName("http://ProdukModel/", "tambahProdukResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: produkmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TambahProduk }
     * 
     */
    public TambahProduk createTambahProduk() {
        return new TambahProduk();
    }

    /**
     * Create an instance of {@link TambahProdukResponse }
     * 
     */
    public TambahProdukResponse createTambahProdukResponse() {
        return new TambahProdukResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TambahProduk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "tambahProduk")
    public JAXBElement<TambahProduk> createTambahProduk(TambahProduk value) {
        return new JAXBElement<TambahProduk>(_TambahProduk_QNAME, TambahProduk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TambahProdukResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ProdukModel/", name = "tambahProdukResponse")
    public JAXBElement<TambahProdukResponse> createTambahProdukResponse(TambahProdukResponse value) {
        return new JAXBElement<TambahProdukResponse>(_TambahProdukResponse_QNAME, TambahProdukResponse.class, null, value);
    }

}
