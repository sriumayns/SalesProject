/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Mayu
 */
public class YourProductController {
    public static String[] displayProduct (String namaOwner) {
        
        String soapResult = getProduk(namaOwner);
        String[] rows = soapResult.split("===");
        
//        result = "<p>"+rows.length+"</p>";
        return rows;
    }

    private static String displayOneProduct(String[] columns) {
        String result = "";
        
        StringBuilder s = new StringBuilder();
        
        return result;
    }
    
    private static String getProduk(java.lang.String namaOwner) {
        produkmodel.YourProductWS_Service service = new produkmodel.YourProductWS_Service();
        produkmodel.YourProductWS port = service.getYourProductWSPort();
        return port.getYourProduct(namaOwner);
    }
    
}
