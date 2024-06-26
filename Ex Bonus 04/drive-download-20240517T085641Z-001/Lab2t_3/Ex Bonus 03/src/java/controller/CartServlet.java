/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDTO;
import model.Product;

public class CartServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");

        if (cart == null) {
            cart = new CartDTO();
        }

        if ("add".equals(action)) {
            String sku = request.getParameter("sku");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            Product product = new Product(sku, name, price, description, 1);
            cart.add(product);
        } else if ("update".equals(action)) {
            String sku = request.getParameter("sku");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Product product = cart.getCart().get(sku);
            if (product != null) {
                product.setQuantity(quantity);
                cart.change(sku, product);
            }
        } else if ("remove".equals(action)) {
            String sku = request.getParameter("sku");
            cart.remove(sku);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("viewCart.jsp"); // Redirect back to the cart view page
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

}
