/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kartik
 */
public class Apply_Vacancies extends HttpServlet  {

    Requirements req;
    CreateVacancies cv;
    String [] names ;
    int [] available;
   
    
    public void show_requirements(Requirements req,HttpServletResponse response,int avail) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String [] r=req.requirements_per_vacancy();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Show_Requirements</title>");  
        out.println("</head>");
        out.println("<body>");
        out.print("<h3 style='color:gray;'> Requirements for "+req.get_name()+" Post :");
        for(int i=0;i<r.length;i++)
        {
            out.println("<h5>"+r[i]+"</h5>");
        }
        out.println("<h4> Note : Only "+avail+" seats are available, Hurry APPLY NOW</h4>");
        
        out.println("</body>");
        out.println("</html>");
        
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Apply_Vacancies</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Apply here</title>");  
            out.println("</head>");
            out.println("<body>");
            req=new Machine_Learning_Engineer();
            String[] r=req.common_requirements();
            cv=new CreateVacancies();
            cv.initialize_status();
            names=cv.get_vacancies_names();
            available=cv.get_vacancies_available();
           
            out.print("<h3 style='color:gray;'> Common Eligibily Criteria ");
            for(int i=0;i<r.length;i++)
            {
                out.println("<h5>"+r[i]+"</h5>");
            }
            out.println("<hr size="+30+" noshade>");
            
            show_requirements(req, response,available[0]);
            out.println("<br><a href='MLE.html'>Apply here</a>");
            out.println("<hr size="+30+" noshade>"); 
        
            req=new Software_Engineer();
            show_requirements(req, response,available[1]);
            out.println("<br><a href='SE.html'>Apply here</a>");
            out.println("<hr size="+30+" noshade>"); 
        
            req=new Java_Developer();
            show_requirements(req, response,available[2]);
            out.println("<br><a href='JD.html'>Apply here</a>");
            out.println("<hr size="+30+" noshade>"); 
        
            req=new Full_Stack_developer();
            show_requirements(req, response,available[3]);
            out.println("<br><a href='FSD.html'>Apply here</a>");
            out.println("<hr size="+30+" noshade>"); 
        
            out.println("<br><a href='Applicant_login.html'>Go home</a>");
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
