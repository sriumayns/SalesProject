/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProdukModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rezaramadhan
 */
@XmlRootElement(name="DetailProduk")
public class DetailProduk {

    @XmlElement(name="productName", required = true)
    private String productName;
    @XmlElement(name="dayAdded", required = true)    
    private String dayAdded;
    @XmlElement(name="dateAdded", required = true)
    private String dateAdded;
    @XmlElement(name="timeAdded", required = true)
    private String timeAdded;
    @XmlElement(name="desc", required = true)    
    private String desc;
    @XmlElement(name="imgPath", required = true)
    private String imgPath;
    @XmlElement(name="nLikes", required = true)
    private int nLikes;
    @XmlElement(name="nPurchases", required = true)
    private int nPurchases;
    @XmlElement(name="price", required = true)
    private int price;
    
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDayAdded() {
        return this.dayAdded;
    }
    public void setDayAdded(String dayAdded) {
        this.dayAdded = dayAdded;
    }
    public String getDateAdded() {
        return this.dateAdded;
    }
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
    public String getTimeAdded() {
        return this.timeAdded;
    }
    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getnLikes() {
        return this.nLikes;
    }
    public void setnLikes(int nLikes) {
        this.nLikes = nLikes;
    }
    public int getnPurchases() {
        return this.nPurchases;
    }
    public void setnPurchases(int nPurchases) {
        this.nPurchases = nPurchases;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public DetailProduk(String productName, String dayAdded, String dateAdded, String timeAdded, String desc, String imgPath, int nLikes, int nPurchases, int price) {
        this.productName = productName;
        this.dayAdded = dayAdded;
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.desc = desc;
        this.imgPath = imgPath;
        this.nLikes = nLikes;
        this.nPurchases = nPurchases;
        this.price = price;
    }
    
    public DetailProduk(int i) {
        this.productName = "nama" + i;
        this.dayAdded = "hari" + i;
        this.dateAdded = "tanggal" + i;
        this.timeAdded = "waktu" + i;
        this.desc = "iniadalahdeskripsiproduk" + i;
        this.nLikes = i;
        this.nPurchases = i*2;
        this.price = i*10000;
        this.imgPath = "img/a.png";
    }
    
}
