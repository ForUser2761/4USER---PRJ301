/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            try {
                //get ve information
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                //check a + b > 0
                if (a > 0 && b > 0) {
                    out.println("<h1>" + timUocChungLonNhat(a, b) + "</h1>");

                } else {
                    out.println("<h1>You must input a > 0 and b > 0" + "</h1>");

                }
            } catch (Exception e) {
                out.println("<h1>You must input a > 0 and b > 0" + "</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    public static int timUocChungLonNhat(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
