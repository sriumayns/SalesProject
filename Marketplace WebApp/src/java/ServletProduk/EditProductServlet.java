/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletProduk;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import produkmodel.EditProductWS_Service;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "EditProductServlet", urlPatterns = {"/editproduct"})
@MultipartConfig
public class EditProductServlet extends HttpServlet {

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/Marketplace_WebService/EditProductWS.wsdl")
//    private EditProductWS_Service service;

   
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
            
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String desc = request.getParameter("desc");
            String price = request.getParameter("price");
            String status = Controller.ProdukController.updateProduk(id,name,desc,price);
            if (status.contains("OK")) {
                response.sendRedirect("http://localhost:8080/yourproducts.jsp");
            }
            out.println(status + "<br>");
            out.println("<br> name " +name);
            out.println("<br> id " +id);
            out.println("<br> desc " +desc);
            out.println("<br> price " +price);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
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

//    private String updateProduk(java.lang.String id, java.lang.String name, java.lang.String desc, java.lang.String price) {
//        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
//        // If the calling of port operations may lead to race condition some synchronization is required.
//        produkmodel.EditProductWS port = service.getEditProductWSPort();
//        return port.updateProduk(id, name, desc, price);
//    }


}
