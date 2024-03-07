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

public class CountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get ve gia tri n nguoi dung nhap
        String raw = request.getParameter("n");
        try {
            int n = Integer.parseInt(raw);
            // kiem tra xem n co < 2
            if (!kiemTraSoChan(n) || n <= 1) {
                //true => show error
                request.setAttribute("number", raw);
                request.setAttribute("error", "Wrong");
                //false => tinh ra count tu 1 - n-1
            } else {
                //lap tu 1 - n-1
                int count = 0;
                for (int i = 1; i < n; i++) {
                    //kiem tra xem so i co phai la so nguyen to ko
                    //true => + 1 vao count
                    if (kiemTraSoNguyenTo(i)) {
                        count++;
                    }
                }
                request.setAttribute("number", raw);
                request.setAttribute("result", count);

            }
        } catch (NumberFormatException e) {
            request.setAttribute("number", raw);
            request.setAttribute("error", "Wrong");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public static boolean kiemTraSoChan(int number) {
        return number % 2 == 0;
    }

    public static boolean kiemTraSoNguyenTo(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Number is divisible by another number, so not prime
            }
        }
        return true; // Number is prime
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CountServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CountServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
