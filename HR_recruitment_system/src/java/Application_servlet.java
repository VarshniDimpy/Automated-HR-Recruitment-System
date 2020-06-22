/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Application_servlet extends HttpServlet {
    
    int id;
    {
        id=-1;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Application_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try
       {
         Class.forName("com.mysql.jdbc.Driver");  
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/applicant","root",""); 
         Statement stmt=con.createStatement();
         String name=request.getParameter("username");
         String pass=request.getParameter("userpass");
         
         
            int flag=0;
            
            ResultSet rs=stmt.executeQuery("select * from applicant_details");
            while(rs.next())
            {
                if (name.equals(rs.getString(2)) && pass.equals(rs.getString(3)))
                    {
                        flag=1;
                        id=rs.getInt(1);
                        break;
                    }
            }
            if (flag==1)
            {
                out.println("<h3> Welcome "+name+" !</h3>");
                out.println("<h3> Your applicant Id is "+id+"</h3>");
                out.println("<h4> Note : Remember your applicant id for future proceedings!</h4>");
                out.println("<br><br><a href='Apply_Vacancies?appid="+id+"'>Clik here to apply for vacancies</a>");
                out.println("<br><br><a href='interview_login.html'>Clik here to give interview </a>");
                out.println("<br><br><a href='Results_.html'>Clik here to see results</a>");
                out.println("<br><br><a href='index.html'>Go to home</a>");
                
            }
            else
            {
                out.println("<h3>Incorrect Information! Please try again</h3>");
                RequestDispatcher rd=request.getRequestDispatcher("applicant_login.html");  
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
