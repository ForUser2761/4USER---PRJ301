/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalServlet extends HttpServlet {

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
            String firstNum = request.getParameter("first");
            String secondNum = request.getParameter("second");
            String operator = request.getParameter("operator");

            double num1 = 0, num2 = 0, result = 0;
            boolean isNumeric = firstNum.matches("-?\\d+(\\.\\d+)?") && secondNum.matches("-?\\d+(\\.\\d+)?");

            if (isNumeric) {
                num1 = Double.parseDouble(firstNum);
                num2 = Double.parseDouble(secondNum);

                switch (operator) {
                    case "add":
                        result = num1 + num2;
                        break;
                    case "subtract":
                        result = num1 - num2;
                        break;
                    case "multiply":
                        result = num1 * num2;
                        break;
                    case "divide":
                        if (num2 == 0) {
                            out.println("Error: Cannot divide by zero.");
                            return;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        out.println("Error: Invalid operator.");
                        return;
                }
                out.println("<html><body>");
                out.println("<h2>Calculation Result:</h2>");
                out.println("<p>" + num1 + " " + operator + " " + num2 + " = " + result + "</p>");
                out.println("</body></html>");
            } else {
                out.println("Error: Please enter valid numbers.");
            }
        } finally {
            out.close();
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
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
