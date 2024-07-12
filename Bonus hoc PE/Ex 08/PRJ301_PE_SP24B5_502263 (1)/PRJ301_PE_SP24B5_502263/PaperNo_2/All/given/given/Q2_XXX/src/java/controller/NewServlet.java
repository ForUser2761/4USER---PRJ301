/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Train;

public class NewServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        try {
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            int seat = Integer.parseInt(request.getParameter("seat"));
            int book = Integer.parseInt(request.getParameter("book"));
            
            Train train = new Train(code, name, seat, book);
            //sai
            if (book > seat ) {
                request.setAttribute("error", "can not >");
                request.getRequestDispatcher("MyExam.jsp").forward(request, response);
                return;
            }
            
            request.setAttribute("code", code);
            request.setAttribute("name", name);
            request.setAttribute("seat", seat);
            request.setAttribute("book", book);
            
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

}
