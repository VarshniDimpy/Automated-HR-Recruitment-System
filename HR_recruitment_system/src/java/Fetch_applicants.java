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
public class Fetch_applicants extends HttpServlet {

    
    MLE_application_details mle;
    public void show_details_mle(PrintWriter out)
    {
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/applications","root","");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from application_details_mle");
                out.println("App_ID"+" | "+"First Name"+" | "+"Last Name"+" | "+"Email ID"+" | "+"Gender"+" | "+"Graduation"+" | "+"Percentage"+" | "+"Research Experience"+" | "+"Total Experience"+" | "+"Status"+" | "+"Interview Assigned"+" | "+"Interview Taken"+" | "+"Interview Result");
                out.println("<br>");
                while(rs.next())  
                {
                    out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12)+"  "+rs.getInt(13));
                    out.println("<br>");
                    
                }
                out.println("<br><br><a href='recruit.html'>Clik here to recruit</a>");
                
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            mle= new MLE_application_details();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Fetch_applicants</title>");            
            out.println("</head>");
            out.println("<body>");
            show_details_mle(out);
            
            out.println("<br><br><a href='HR_login.html'>Go to home</a>");
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
