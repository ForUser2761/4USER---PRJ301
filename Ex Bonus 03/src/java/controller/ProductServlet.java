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

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] array = request.getParameterValues("combo");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            for (String string : array) {
                out.println("<h1>" + string + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<h1>Product Selection</h1>");
            out.println("<form method='POST' action='product'>");
            out.println("<table>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='Servlet & JSP'> Servlet & JSP "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='Struts & JSF'> Struts & JSF "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='EJB'> EJB "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='XMJ'> XMJ "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='Servlet'> Servlet "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='JSF'> JSF "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='JSP'> JSP "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='checkbox'name='combo' value='Struts'> Struts "
                    + "</td></tr>");
            out.println("<tr><td> "
                    + "<input type='submit' value='choose' > "
                    + "</td></tr>");
            out.println("</table>");
            out.println("</form>");
        }
    }

}
