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

public class FiboServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
            String n = request.getParameter("n");
            if (n == null || n.isEmpty() || !isInteger(n) || Integer.parseInt(n) <= 1) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Fibonacci Calculator</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>You input wrong</h1>");
                out.println("</body>");
                out.println("</html>");
            } else {
                int num = Integer.parseInt(n);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Fibonacci Calculator</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Fibonacci Sequence for " + num + ":</h1>");
                out.println("<p>" + getFibonacciSequence(num) + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String getFibonacciSequence(int n) {
        if (n <= 0) {
            return "";
        }
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(fib[i]);
            if (i < n - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
