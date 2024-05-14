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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            response.setContentType("text/html;charset=UTF-8");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            // get ve gia tri n nguoi dung nhap
            try {
                int n = Integer.parseInt(request.getParameter("n"));
                // kiem tra xem n co < 2
                if (n < 2) {
                    //true => show error
                    out.println("<h1>You input wrong</h1>");
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
                    out.println("<h1>" + count + "</h1>");

                }
            } catch (NumberFormatException e) {
                out.println("<h1>You input wrong</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
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

}
