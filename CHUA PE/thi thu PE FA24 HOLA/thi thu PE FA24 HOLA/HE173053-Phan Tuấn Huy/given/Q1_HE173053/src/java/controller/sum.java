/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mtxt hp
 */
public class sum extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sum</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sum at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String a_raw = request.getParameter("number");
    try {
        int a = Integer.parseInt(a_raw);
        if (a <= 1) {
            response.getWriter().println("You input wrong");
        } else {
            int result = sum(a - 1);
            response.getWriter().println("Sum of prime numbers from 1 to " + (a - 1) + " is: " + result);
        }
    } catch (Exception e) {
        response.getWriter().println("You input wrong");
    }
    }
    public int sum(int a) {
    int sum = 0;
    for (int i = 1; i <= a; i++) {
        if (prime(i)) {
            sum += i;
        }
    }
    return sum;
}

public boolean prime(int a) {
    if (a < 2) {
        return false;
    }
    for (int i = 2; i <= Math.sqrt(a); i++) {
        if (a % i == 0) {
            return false;
        }
    }
    return true;
}  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
