
package transactionmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addPurchase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addPurchase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="penerima_barang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="alamat_penerima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postal_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phone_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="credit_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="verification_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="jml_barang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addPurchase", propOrder = {
    "username",
    "idProduct",
    "penerimaBarang",
    "alamatPenerima",
    "postalCode",
    "phoneNum",
    "creditNum",
    "verificationNum",
    "jmlBarang",
    "owner",
    "productname",
    "price",
    "photo"
})
public class AddPurchase {

    protected String username;
    @XmlElement(name = "id_product")
    protected String idProduct;
    @XmlElement(name = "penerima_barang")
    protected String penerimaBarang;
    @XmlElement(name = "alamat_penerima")
    protected String alamatPenerima;
    @XmlElement(name = "postal_code")
    protected String postalCode;
    @XmlElement(name = "phone_num")
    protected String phoneNum;
    @XmlElement(name = "credit_num")
    protected String creditNum;
    @XmlElement(name = "verification_num")
    protected String verificationNum;
    @XmlElement(name = "jml_barang")
    protected String jmlBarang;
    protected String owner;
    protected String productname;
    protected String price;
    protected String photo;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the idProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProduct() {
        return idProduct;
    }

    /**
     * Sets the value of the idProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProduct(String value) {
        this.idProduct = value;
    }

    /**
     * Gets the value of the penerimaBarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenerimaBarang() {
        return penerimaBarang;
    }

    /**
     * Sets the value of the penerimaBarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenerimaBarang(String value) {
        this.penerimaBarang = value;
    }

    /**
     * Gets the value of the alamatPenerima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    /**
     * Sets the value of the alamatPenerima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlamatPenerima(String value) {
        this.alamatPenerima = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the phoneNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the value of the phoneNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNum(String value) {
        this.phoneNum = value;
    }

    /**
     * Gets the value of the creditNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditNum() {
        return creditNum;
    }

    /**
     * Sets the value of the creditNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditNum(String value) {
        this.creditNum = value;
    }

    /**
     * Gets the value of the verificationNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationNum() {
        return verificationNum;
    }

    /**
     * Sets the value of the verificationNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationNum(String value) {
        this.verificationNum = value;
    }

    /**
     * Gets the value of the jmlBarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJmlBarang() {
        return jmlBarang;
    }

    /**
     * Sets the value of the jmlBarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJmlBarang(String value) {
        this.jmlBarang = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the productname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductname() {
        return productname;
    }

    /**
     * Sets the value of the productname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductname(String value) {
        this.productname = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

}
