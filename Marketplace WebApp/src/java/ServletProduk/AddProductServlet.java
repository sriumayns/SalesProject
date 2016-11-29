/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletProduk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import produkmodel.AddProdukWS_Service;

/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/addproduct"})
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/Marketplace_WebService/AddProdukWS.wsdl")
    private AddProdukWS_Service service;
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }  
    
    private String getFileExtension(final Part part) {
        String s = "";
        
        String filename = getFileName(part);
        
        String[] arr = filename.split("\\.(?=[^\\.]+$)");
        s = arr[1];
        return s;
    }
    
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
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String price = request.getParameter("price");
        String owner = request.getParameter("owner");
        PrintWriter o = response.getWriter();
        
        o.print(name + "<br>");
        o.print(desc + "<br>");
        o.print(price + "<br>");
        o.print(owner + "<br>");
//        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("photo");
        
        String fileext = getFileExtension(filePart);
        final String fileName = owner + "_" + name + "." + fileext;
        o.print(fileName + "<br>");
        String workingpath = System.getProperty("user.dir");
        o.print("uploadpath " + workingpath + "<br>");
 
        
        String respons = tambahProduk(name,desc,price,owner,fileext);
        o.print("Sukses? " +respons + "<br>");
        
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        String relativeWebPath = "/img";
        //o.print(getServletContext() + "<br>");
        
        o.print("<img src=\"img/" + fileName + "\" > <br>");
        String path = getServletContext().getRealPath(relativeWebPath);
//        String path = "/img";
//        String path = System.getProperty("com.mycompany.uploadPath") + relativeWebPath;
        o.print(path + "<br>");
        
        //o.print(File.separator + "<br>");
        String encoded = "";
        try {
            File f = new File(workingpath, fileName);
//            o.print(f.getAbsolutePath() + "<br>");
            out = new FileOutputStream(f);
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                //o.write(read + "<br>");
//                encoded += Base64.getEncoder().encodeToString(bytes);
                //o.write(base64 + "br");
            }
//            o.print(encoded + "<br>");
//            byte[] decodedByte = Base64.getDecoder().decode(encoded.getBytes());
//            o.print(Integer.toString(decodedByte.length) + "<br>");
//            out.write(decodedByte);
                
            o.print("<br>ok");
            if (respons.contains("OK")) {
                response.sendRedirect("http://localhost:8080/yourproducts.jsp");
            }
//            writer.println("New file " + fileName + " created at " + path);
//            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
//                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
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

    private String tambahProduk(java.lang.String name, java.lang.String desc, java.lang.String price, java.lang.String owner, java.lang.String fileExt) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        produkmodel.AddProdukWS port = service.getAddProdukWSPort();
        return port.tambahProduk(name, desc, price, owner, fileExt);
    }

}
