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

public class SumServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet SumServlet</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            int n = Integer.parseInt(request.getParameter("n"));
            if (n <= 5) {
                out.println("<h1>Must greater than > 5</h1>");
                return;
            }

            String op = request.getParameter("op");
            int sum = 0;
            if (op.equals("odd")) {
                for (int i = 0; i < n; i++) {
                    if (kiemTraSoLe(i)) {
                        sum += i;
                    }
                }
            } else if (op.equals("even")) {
                for (int i = 0; i <= n; i++) {
                    if (kiemTraSoChan(i)) {
                        sum += i;
                    }
                }
            }

            out.println("<h1>"+ sum +"</h1>");

        } catch (NumberFormatException e) {
            out.println("<h1>Must greater than > 5</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Hàm này sử dụng để kiểm tra xem 1 số có phải số lẻ hay không
     *
     * @param number
     * @return
     */
    public static boolean kiemTraSoLe(int number) {
        return number % 2 != 0;
    }

    /**
     * Hàm này sử dụng để kiểm tra xem 1 số có phải là số chẵn không
     *
     * @param number
     * @return
     */
    public static boolean kiemTraSoChan(int number) {
        return number % 2 == 0;
    }

}
