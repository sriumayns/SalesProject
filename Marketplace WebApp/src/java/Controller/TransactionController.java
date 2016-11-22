/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author LENOVO
 */
public class TransactionController {
    public static String[] displayPurchase (String username) {
        
        String soapResult = getPurchase(username);
        String[] rows = soapResult.split("===");
        
//        result = "<p>"+rows.length+"</p>";
        return rows;
    }
    
    public static String[] displaySales (String username) {
        
        String soapResult = getSales(username);
        String[] rows = soapResult.split("===");
        
//        result = "<p>"+rows.length+"</p>";
        return rows;
    }

//    private static String displayOneProduct(String[] columns) {
//        String result = "";
//        
//        StringBuilder s = new StringBuilder();
//        
//        return result;
//    }
    private static String getPurchase(java.lang.String username) {
        transactionmodel.TransactionWS_Service service = new transactionmodel.TransactionWS_Service();
        transactionmodel.TransactionWS port = service.getTransactionWSPort();
        return port.getPurchase(username);
    }

    private static String getSales(java.lang.String namaOwner) {
        transactionmodel.TransactionWS_Service service = new transactionmodel.TransactionWS_Service();
        transactionmodel.TransactionWS port = service.getTransactionWSPort();
        return port.getSales(namaOwner);
    }
    
    
}
