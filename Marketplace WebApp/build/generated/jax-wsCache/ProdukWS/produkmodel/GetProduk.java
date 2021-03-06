
package produkmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProduk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProduk"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="namaProduk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="namaOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduk", propOrder = {
    "namaProduk",
    "namaOwner"
})
public class GetProduk {

    protected String namaProduk;
    protected String namaOwner;

    /**
     * Gets the value of the namaProduk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamaProduk() {
        return namaProduk;
    }

    /**
     * Sets the value of the namaProduk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamaProduk(String value) {
        this.namaProduk = value;
    }

    /**
     * Gets the value of the namaOwner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamaOwner() {
        return namaOwner;
    }

    /**
     * Sets the value of the namaOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamaOwner(String value) {
        this.namaOwner = value;
    }

}
