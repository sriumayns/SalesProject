
package produkmodel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProdukWS", targetNamespace = "http://ProdukModel/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProdukWS {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://ProdukModel/", className = "produkmodel.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://ProdukModel/", className = "produkmodel.HelloResponse")
    @Action(input = "http://ProdukModel/ProdukWS/helloRequest", output = "http://ProdukModel/ProdukWS/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param namaProduk
     * @param namaOwner
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProduk", targetNamespace = "http://ProdukModel/", className = "produkmodel.GetProduk")
    @ResponseWrapper(localName = "getProdukResponse", targetNamespace = "http://ProdukModel/", className = "produkmodel.GetProdukResponse")
    @Action(input = "http://ProdukModel/ProdukWS/getProdukRequest", output = "http://ProdukModel/ProdukWS/getProdukResponse")
    public String getProduk(
        @WebParam(name = "namaProduk", targetNamespace = "")
        String namaProduk,
        @WebParam(name = "namaOwner", targetNamespace = "")
        String namaOwner);

}
