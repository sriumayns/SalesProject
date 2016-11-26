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
@WebServlet(name = "ServletCookie", urlPatterns = {"/ServletCookie"})
public class ServletCookie extends HttpServlet {
    private int expireAfter = 10;
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
        
        //GET IP ADDR
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
        
        //GET User-agent
        String userAgent = request.getHeader("User-Agent");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCookie at " + request.getContextPath() + "</h1>");
            out.println("<h1>Uname " + request.getParameter("uname") + "</h1>");
            out.println("<h1>TOKEN " + request.getParameter("token") + "</h1>");
            out.println("<h1>IPADDR " + ipAddress + "</h1>");
            out.println("<h1>useragent " + userAgent + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            // Create cookies for first and last names.      
            Cookie username = new Cookie("username",
                            request.getParameter("username"));
            Cookie token = new Cookie("token",
                            request.getParameter("token"));
            Cookie ip = new Cookie("ip",
                            ipAddress);
            Cookie user_agent = new Cookie("user",
                            userAgent);
            
            // Set expiry date 
            username.setMaxAge(60*expireAfter); 
            token.setMaxAge(60*expireAfter); 
            ip.setMaxAge(60*expireAfter); 
            user_agent.setMaxAge(60*expireAfter); 

            // Add both the cookies in the response header.
            response.addCookie(username);
            response.addCookie(token);
            response.addCookie(ip);
            response.addCookie(user_agent);

            // Set response content type
            response.setContentType("text/html");

            response.sendRedirect("http://localhost:8080/Marketplace_WebApp/catalog.jsp");
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
