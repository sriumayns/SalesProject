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
public class ConfirmPurchaseController {
    
    // Getter untuk info produk
    public static String getProductInfo(String id)
    {
        return getPurchaseProduct(id);
    }

    private static String getPurchaseProduct(java.lang.String id) {
        transactionmodel.ConfirmPurchaseWS_Service service = new transactionmodel.ConfirmPurchaseWS_Service();
        transactionmodel.ConfirmPurchaseWS port = service.getConfirmPurchaseWSPort();
        return port.getPurchaseProduct(id);
    }
    
}
