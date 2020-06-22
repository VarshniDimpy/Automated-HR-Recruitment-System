/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kartik
 */
public class HR_servlet extends HttpServlet {
    
    
    CreateVacancies c;
    String HR_name;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String n=request.getParameter("username");
        String p=request.getParameter("userpass");
        int flag=0;
        
        try{
                Class.forName("com.mysql.jdbc.Driver");  
                 Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/HR","root","");  
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from HR_details");  
                while(rs.next())  
                {
                    if (n.equals(rs.getString(1)) && p.equals(rs.getString(2)))
                    {
                        HR_name=rs.getString(1);
                        flag=1;
                        break;
                    }
                }
                
        }
        catch(Exception e)
        {
            
        }
        
        if (flag==1)
        {
            
            try (
                PrintWriter out = response.getWriter()) {
               
                c=new CreateVacancies();

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2> Welcome "+HR_name+"</h2>");
                out.println("<h3> Here are the available status of vacancies : </h3>");
                out.println("<br>");
                int number=c.get_number_of_vacancies();      
                String[] vacancies_names=c.get_vacancies_names();
                int[] vacancies_available=c.get_vacancies_available();
                out.println("<table>");
                out.println("<tr>");
                out.println("<th> Vacancy name </th>");
                out.println("<th>Available Vacancies</th>");
                
                for(int i=0;i<number;i++)
                {
                    out.println("<tr>");
                    out.println("<td>"+vacancies_names[i]+"</td>");
                    out.println("<td>"+vacancies_available[i]+"</td>");
                    out.println("</tr>");
                }
                out.println("</table");
                
                out.println("<br><br><a href='updation.html'>Clik here to update number of vacancies</a>");
                out.println("<br><br><a href='Show_Requirements'>Clik here to see the requirements</a>");
                out.println("<br><br><a href='Fetch_applicants'>Clik here for available applicants </a>");
                out.println("<br><br><a href='index.html'>Go to home</a>");
                out.println("</body>");
                out.println("</html>");
                             
            }
        }
        else
        {
            PrintWriter out=response.getWriter();
            out.println("sorry, incorrect information");
            
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
