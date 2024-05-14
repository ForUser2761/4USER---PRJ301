/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Customers;

public class ShowCOn extends HttpServlet {

    CustomerDAO dao = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customers> list = dao.findAll();
        request.getSession().setAttribute("list", list);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        switch (action) {
            case "delete":
                delete(request, response);
                break;
            case "filterByName":
                filterByName(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get ve id
        String id = request.getParameter("id");
        //xoa o trong database
        dao.deleteByID(id);
        response.sendRedirect("show");
    }

    private void filterByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        List<Customers> list = dao.findByName(name);
        request.getSession().setAttribute("list", list);
        response.sendRedirect("show.jsp");
    }

}
