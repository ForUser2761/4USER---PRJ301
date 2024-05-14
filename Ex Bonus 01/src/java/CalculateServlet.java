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
         // Lấy dữ liệu từ form
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");
        String operator = request.getParameter("operator");

        double result = 0.0;
        boolean validInput = true;
        String errorMessage = null;

        try {
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            // Xử lý phép toán
            switch (operator) {
                case "add":
                    result = number1 + number2;
                    break;
                case "subtract":
                    result = number1 - number2;
                    break;
                case "multiply":
                    result = number1 * number2;
                    break;
                case "divide":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        validInput = false;
                        errorMessage = "Cannot divide by zero.";
                    }
                    break;
                default:
                    validInput = false;
                    errorMessage = "Invalid operator.";
                    break;
            }
        } catch (NumberFormatException e) {
            validInput = false;
            errorMessage = "Invalid number format.";
        }

        // Trả kết quả về cho người dùng
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (validInput) {
            out.println("<h2>Result: " + result + "</h2>");
        } else {
            out.println("<h2>Error: " + errorMessage + "</h2>");
        }
        out.println("<a href='index.html'>Back to Calculator</a>");
        out.println("</body></html>");
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
            out.println("<h1>Servlet CalculateServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

}
