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
public class Store_result extends HttpServlet {

    
    public void result(PrintWriter out,int app_id,HttpServletRequest request,String [] results)
    {
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/applications","root","");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from application_details_mle");
                
                while(rs.next())  
                {
                    if(app_id==rs.getInt(1))
                    {
                        String answers[]=new String[]{request.getParameter("q1"),request.getParameter("q2"),request.getParameter("q3"),request.getParameter("q4"),request.getParameter("q5")};
                        int count=0;
                        for (int i=0;i<results.length ;i++)
                        {
                            if (results[i].equals(answers[i]))
                            {
                                count=count+1;
                            }
                        }
                        
                        count=count*5;
                        
                        String sql="UPDATE application_details_mle SET Interview_result="+count+" where app_id="+app_id;
                        stmt.executeUpdate(sql);
                        out.println("Thanks for taking interview!");
                    }
                }
                
                
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
            String[] results=new String[]{"a","b","b","a","a"};
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Store_result</title>");            
            out.println("</head>");
            out.println("<body>");
            int app_id=Integer.parseInt(request.getParameter("id"));
            result(out,app_id,request,results);
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
