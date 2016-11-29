/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.OnlineUser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.net.ssl.HttpsURLConnection;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
/**
 *
 * @author rezaramadhan
 */
@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ArrayList<OnlineUser> on;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        on = new ArrayList<>();
  }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChatServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChatServlet at " + request.getContextPath() + "</h1>");
            for (OnlineUser u : on) {
                out.println("<p>"+ u +"<p>");
            }
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
//        processRequest(request, response);
        /*String s = request.getParameter("content");
        
        if (s!=null) {
            //response.getWriter().print("OK");
            //if (request.getParameter("type") == "token")
            //{*/
                //int idx = findUsername(request.getParameter("username"));
                int idx = findUsername("test");
                if (idx != -999)
                {
                    on.get(idx).setToken(request.getParameter("token"));
                }
                else
                {
                    OnlineUser info = new OnlineUser();
                    info.setUsername("test");
                    info.setToken("dwrC_XOVBVs:APA91bFSEbUj7UWNma96zZTw1rawt-0PYhynYO5807YNITkd9AjTik_E5pWDtEAxkaTULEkEVqOJTsAi8KIXU-1FBRPvcc-zZoSRMeaFfhTpN4n9sP_Cr9KIQe4Ni6qILBzImgyxoMZm");
                    on.add(info);
                }
            /*}
            else
            {
                try {
                    String sender = request.getParameter("to");
                    String msg = request.getParameter("msg");
                    String to = on.get(findUsername(sender)).getToken();
                    JsonObject payload = Json.createObjectBuilder()
                            .add("notification", Json.createObjectBuilder()
                                    .add("title",sender)
                                    .add("body",msg))
                            .add("to",to)
                            .build();
                    sendMessage(payload);
                } catch (Exception ex) {
                    Logger.getLogger(ChatServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            response.getWriter().print("NOT");
        }*/
    }
    
    private void sendMessage(JsonObject payload) throws Exception
    {
        String url = "https://fcm.googleapis.com/fcm/send";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-type", "application/json");
        con.setRequestProperty("Authorization", "key=AIzaSyDHolAWSGjSASlD4IQ5p4CnS9EPrZVQaUE");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(payload.toString());
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        //System.out.println("Post parameters : " + payload);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }
    
    private int findUsername(String username) {
        int i = 0;
        while (i < on.size()) {
            if (on.get(i).username.equals(username)) {
                return i;
            }
            i++;
        }
        
        return -999;
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
