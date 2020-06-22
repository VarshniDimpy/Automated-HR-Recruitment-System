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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kartik
 */
public class Interview_applicant extends HttpServlet {

    public int take_interview(int app_id,HttpServletRequest request,HttpServletResponse response,PrintWriter out)
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/applications","root","");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from application_details_mle");
                
                while(rs.next())
                {
                    out.println(rs.getInt(1)+" "+rs.getString(11));
                    if(rs.getInt(1)==app_id && rs.getString(11).equals("Yes"))
                    {
                        out.println("hello!");
                        return 1;
                        
                    }
                }
       }
       catch(Exception e)
       {
           return 0;
           
       }
       return 0;
       
   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Interview_applicant</title>");            
            out.println("</head>");
            out.println("<body>");
            int id=Integer.parseInt(request.getParameter("id"));
            
            int flag = take_interview(id,request,response,out);
            if(flag==1)
            {
                out.println("<br><br><a href='Ml_interview.html'>Start</a>");
            }
            out.println("<br><br><a href='index.html'>Go to home</a>");
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
