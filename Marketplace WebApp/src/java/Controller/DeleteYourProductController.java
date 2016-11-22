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
public class DeleteYourProductController {
    public static String deleteYourProduct(int idProduct) {
        produkmodel.DeleteYourProductWS_Service service = new produkmodel.DeleteYourProductWS_Service();
        produkmodel.DeleteYourProductWS port = service.getDeleteYourProductWSPort();
        return port.deleteProduct(idProduct);
    }
    
}
