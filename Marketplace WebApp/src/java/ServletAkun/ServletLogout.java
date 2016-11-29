/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAkun;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mayu
 */
@WebServlet(name = "ServletLogout", urlPatterns = {"/ServletLogout"})
public class ServletLogout extends HttpServlet {

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
            
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//             for (Cookie cookie : cookies) {
//               if (cookie.getName().equals("cookieName")) {
//                 //do something
//                 //value can be retrieved using #cookie.getValue()
//                }
//              }
//            }
//            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletLogout</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletLogout at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Username : " + cookies[1].getValue() + "</h1>");
//            out.println("<h1>Token : " + cookies[2].getValue() + "</h1>");
//            
            Cookie username = new Cookie("username", null); // Not necessary, but saves bandwidth.
            username.setPath("http://localhost:8080/Marketplace_IdentityService/ServletLogout");
            username.setHttpOnly(true);
            username.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
            response.addCookie(username);
            
            
            Cookie token = new Cookie("token", null); // Not necessary, but saves bandwidth.
            token.setPath("http://localhost:8080/Marketplace_IdentityService/ServletLogout");
            token.setHttpOnly(true);
            token.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
            response.addCookie(token);
            
            Cookie [] cookies = request.getCookies();
            out.println("<h1>Username : " + cookies[1].getValue() + "</h1>");
            //out.println("<h1>Token : " + cookies[2].getValue() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
            
            response.sendRedirect("http://localhost:8082/Marketplace_IdentityService/ServletLogout?username="+cookies[1].getValue());
            //response.sendRedirect("http://localhost:8080/login.jsp");
            
            
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

}
