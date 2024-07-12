/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BoatDAO;
import entity.Boats;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String departId = request.getParameter("departId");
        BoatDAO boatDAO = new BoatDAO();
        HttpSession session = request.getSession();
        List<Boats> listBoat = (List<Boats>) session.getAttribute("listBoat");
        if (departId == null) {
            if (listBoat == null) {
                listBoat = boatDAO.findAll();
            }
        } else {
            if (departId.equals("-1")) {
                listBoat = boatDAO.findAll();
            } else {
                listBoat = boatDAO.findById(departId);
            }
        }
        
        request.setAttribute("departId", departId);
        session.setAttribute("listBoat", listBoat);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Show</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Show at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
