/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.*;

/**
 *
 * @author Kartik
 */
public class Application_register extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            
       try
       {
         Class.forName("com.mysql.jdbc.Driver");  
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/applicant","root",""); 
         Statement stmt=con.createStatement();
         String name=request.getParameter("username");
         String pass1=request.getParameter("userpass1");
         String pass2=request.getParameter("userpass2");
         out.println ("<h3>Hi ! "+name+"</h3>");
         if(pass1.equals(pass2))
         {
         out.println("<h4>passwords match!</h4>");
         PreparedStatement st = con .prepareStatement("insert into applicant_details values(?,?,?)"); 
            ResultSet rs=stmt.executeQuery("select * from applicant_details");
            int value=0;
            while(rs.next())
            {
                value++;
            }
            st.setInt(1,value); 
            st.setString(2, name);
            st.setString(3,pass1); 
            int k=st.executeUpdate(); 
            st.close(); 
         if(k>0)
         {
             out.println("<h4>your data is recorded, you can login now!</h4");
             RequestDispatcher rd=request.getRequestDispatcher("Applicant_login.html");  
             rd.include(request, response); 
         }
         }
         else
         {
             out.println("<h4>sorry, your passwords don't match!</h4>");
             RequestDispatcher rd=request.getRequestDispatcher("new_register.html");  
             rd.include(request, response);  
         }
         
         
        }
        catch(Exception e)
        {
            System.out.println(e);
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
