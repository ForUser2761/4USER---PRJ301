/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Product;

public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        HttpSession session = request.getSession();
        List<Product> listProduct = (List<Product>) session.getAttribute("listProduct");
        //kiem tra xem co list product o trong session hay ko 
        //TH1: ko he co list product torng session
        if (listProduct == null) {
            //get du lieu san pham len 
            listProduct = dao.findAll();
        }
        //set du lieu vao trong request
        session.setAttribute("listProduct", listProduct);
        //chuyen sang trang list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null
                ? "" : request.getParameter("action");
        List<Product> listProduct;
        switch (action) {
            case "search":
                listProduct = searchProduct(request, response);
                break;
            case "insert":
                listProduct = insert(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getSession().setAttribute("listProduct", listProduct);
        response.sendRedirect("product");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) {
        //get ve keyword nguoi dung nhap
        String keyword = request.getParameter("keyword");
        //dua vao keyword do, tim trong DB co product nao chua tu khoa ma 
        //nguoi udng nhpa ko => List<Product>
        ProductDAO dao = new ProductDAO();
        List<Product> listProduct = dao.findByName(keyword);
        //tra ve list
        return listProduct;
    }

    private List<Product> insert(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO dao = new ProductDAO();
        //get ve data
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        //insert vaot rong DB
        dao.insert(product);
        //get ve toan bo data moi
        return dao.findAll();
    }

}
