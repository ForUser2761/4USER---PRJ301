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

public class CalculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Lấy giá trị từ form
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            String[] operations = request.getParameterValues("operation");

            // Tính toán kết quả
            for (String operation : operations) {
                switch (operation) {
                    case "ADD":
                        out.println("<p>Result of ADD: " + (a + b) + "</p>");
                        break;
                    case "Subtract":
                        out.println("<p>Result of Subtract: " + (a - b) + "</p>");
                        break;
                    case "Multiply":
                        out.println("<p>Result of Multiply: " + (a * b) + "</p>");
                        break;
                    case "Divide":
                        if (b != 0) {
                            out.println("<p>Result of Divide: " + (a / b) + "</p>");
                        } else {
                            out.println("<p>Cannot divide by zero</p>");
                        }
                        break;
                    case "UCLN":
                        out.println("<p>Result of UCLN: " + gcd((int) a, (int) b) + "</p>");
                        break;
                    case "BCNN":
                        out.println("<p>Result of BCNN: " + lcm((int) a, (int) b) + "</p>");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            out.println("<p>Please enter valid numbers</p>");
        } finally {
            out.close();
        }
    }

    // Hàm tính UCLN (Ước Chung Lớn Nhất)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Hàm tính BCNN (Bội Chung Nhỏ Nhất)
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
