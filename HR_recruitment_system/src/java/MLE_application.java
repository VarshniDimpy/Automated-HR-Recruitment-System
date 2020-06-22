/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kartik
 */
public class MLE_application extends HttpServlet {

    MLE_application_details m;
    public boolean is_app_id(int id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/applicant","root","");  
            Statement stmt=con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from applicant_details");
            while(rs.next())
            {
                if (rs.getInt(1)==id)
                {
                    return true;
                }
            }
            return false;
            
          }
        catch(Exception e)
        {
            
        }
        return false;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> MLE_application</title>");            
            out.println("</head>");
            out.println("<body>");
            m= new MLE_application_details();
            int id=Integer.parseInt(request.getParameter("id"));
            if(is_app_id(id))
            {
            m.setApp_id(id);
            m.setFirst_Name(request.getParameter("firstname"));
            m.setLast_Name(request.getParameter("lastname"));
            m.setEmail(request.getParameter("emailaddr"));
            m.setGender(request.getParameter("gender"));
            m.setGraduation(request.getParameter("grad"));
            m.setPercentage(request.getParameter("per"));
            m.setResearch_experience(request.getParameter("re"));
            m.setTotal_experience(request.getParameter("te"));
            m.update_all_details();
            out.println("<h3>Your details are recorded!</h3>");
            out.println("<br><br><a href='Applicant_login.html'>Go to login page</a>");
            }
            else
            {
            out.println("<h3>Sorry, you have typed the wrong applicant id</h3>");   
            out.println("</body>");
            out.println("</html>");
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

}
