/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author rezaramadhan
 */
public class ProdukController {
    
    public static String[] displayProduct (String namaProduk, String namaOwner) {
        
        String soapResult = getProduk(namaProduk, namaOwner);
        String[] rows = soapResult.split("===");
        
//        result = "<p>"+rows.length+"</p>";
        return rows;
    }

    public static String[] getProductbyID(String id) {
        String[] result = getProductByID(id).split("!!!");
        
        return result;
    }
    
    private static String getProduk(java.lang.String namaProduk, java.lang.String namaOwner) {
        produkmodel.ProdukWS_Service service = new produkmodel.ProdukWS_Service();
        produkmodel.ProdukWS port = service.getProdukWSPort();
        return port.getProduk(namaProduk, namaOwner);
    }

    private static String getProductByID(java.lang.String id) {
        produkmodel.EditProductWS_Service service = new produkmodel.EditProductWS_Service();
        produkmodel.EditProductWS port = service.getEditProductWSPort();
        return port.getProductByID(id);
    }

    public static String updateProduk(java.lang.String id, java.lang.String name, java.lang.String desc, java.lang.String price) {
        produkmodel.EditProductWS_Service service = new produkmodel.EditProductWS_Service();
        produkmodel.EditProductWS port = service.getEditProductWSPort();
        return port.updateProduk(id, name, desc, price);
    }

    public static String isLiked(java.lang.String idProduct, java.lang.String username) {
        produkmodel.LikeWS_Service service = new produkmodel.LikeWS_Service();
        produkmodel.LikeWS port = service.getLikeWSPort();
        return port.isLiked(idProduct, username);
    }
}
