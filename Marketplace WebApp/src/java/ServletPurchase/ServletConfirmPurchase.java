/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPurchase;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import transactionmodel.ConfirmPurchaseWS_Service;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ServletConfirmPurchase", urlPatterns = {"/ServletConfirmPurchase"})
public class ServletConfirmPurchase extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/Marketplace_WebService/ConfirmPurchaseWS.wsdl")
    private ConfirmPurchaseWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConfirmPurchase</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConfirmPurchase at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //Mengambil cookie
            Cookie cookie = null;
            Cookie[] cookies = null;
            // Get an array of Cookies associated with this domain
            cookies = request.getCookies();
            if( cookies != null ){
                for (int i = 0; i < cookies.length; i++){
                   cookie = cookies[i];
                }
            }else{
            }
            
            //Mengambil parameter purchase
            
            //String username = "2";
            String username = cookies[1].getValue();
            String productid = request.getParameter("id_product");         
            String penerima = request.getParameter("fullname");
            String alamat = request.getParameter("address");
            String kodepos = request.getParameter("postalcode");
            String telp = request.getParameter("phonenumber");
            String creditnum = request.getParameter("creditnumber");
            String validnum = request.getParameter("creditverify");
            String jumlah = request.getParameter("quantity");
            String productinfo = Controller.ConfirmPurchaseController.getProductInfo(productid);
            String[] element = productinfo.split("!");
            String owner = element[0];
            String productname = element[1];
            String price = element[2];
            String photo = element[3];
            
//            out.println(username);
//            out.println(penerima);
//            out.println(alamat);
//            out.println(kodepos);
//            out.println(telp);
//            out.println(creditnum);
//            out.println(validnum);
//            out.println(jumlah);
//            out.println(owner);
//            out.println(productname);
//            out.println(price);
//            out.println(photo);
            
            // Memanggil web service untuk input purchase ke database
            String check = addPurchase(username, productid, penerima, alamat, kodepos, telp, creditnum, validnum, jumlah, owner, productname, price, photo);
            out.print(check);
            if (check.contains("OK")) {
                response.sendRedirect("http://localhost:8080/Marketplace_WebApp/purchased.jsp");
                response.setStatus(307); //this makes the redirection keep your requesting method as is.
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    // Fungsi dari web service
    private String addPurchase(java.lang.String username, java.lang.String idProduct, java.lang.String penerimaBarang, java.lang.String alamatPenerima, java.lang.String postalCode, java.lang.String phoneNum, java.lang.String creditNum, java.lang.String verificationNum, java.lang.String jmlBarang, java.lang.String owner, java.lang.String productname, java.lang.String price, java.lang.String photo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        transactionmodel.ConfirmPurchaseWS port = service.getConfirmPurchaseWSPort();
        return port.addPurchase(username, idProduct, penerimaBarang, alamatPenerima, postalCode, phoneNum, creditNum, verificationNum, jmlBarang, owner, productname, price, photo);
    }

}
