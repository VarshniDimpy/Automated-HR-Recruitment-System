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
public class HR_modify extends HttpServlet {

    CreateVacancies c;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HR_modify</title>");            
            out.println("</head>");
            out.println("<body>");
            String m=request.getParameter("ML");
            String s=request.getParameter("SE");
            String j=request.getParameter("JD");
            String f=request.getParameter("FSD");
            
            int a=Integer.parseInt(m);
            int b=Integer.parseInt(s);
            int c_=Integer.parseInt(s);
            int d=Integer.parseInt(s);
            
            c=new CreateVacancies();
            
            if(c.update_vacancies("Machine Learning Engineer", a))
            {
                out.println("<h4>updated for ML!</h4>");
            }
            if(c.update_vacancies("Software Engineer",b))
            {
                out.println("<h4>updated for SE!</h4>");
            }
            if(c.update_vacancies("Java Developer", c_))
            {
                out.println("<h4>updated for JD!</h4>");
            }
            if(c.update_vacancies("Full Stack Developer", d))
            {
                out.println("<h4>updated for FSD!</h4>");
            }
            out.println("<br><br><a href='HR_login.html'>Go home</a>");
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
