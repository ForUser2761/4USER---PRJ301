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
import java.util.ArrayList;
import java.util.List;

public class NewServlet extends HttpServlet {

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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");
        out.println("</head>");
        out.println("<body>");
        try {

            //get ve data
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));

            if (a <= 0 || b <= 0) {
                out.println("<h1>You must input an integer > 0</h1>");
            } else {
                
                out.println("<h1>" + findNLCMs(a,b,3).toString() + "</h1>");
                
            }


        } catch (Exception e) {
            out.println("<h1>You must input texts</h1>");
        }
        out.println("</body>");
        out.println("</html>");
    }
    
        /**
     * tìm ước chung lớn nhất của 2 số
     *
     * @param a
     * @param b
     * @return
     */
    public static int timUocChungLonNhat(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Tìm bội số chung nhỏ nhất của 2 số
     * @param a
     * @param b
     * @return 
     */
    public static int timBoiSoChungNhoNhat(int a, int b) {
        return Math.abs(a * b) / timUocChungLonNhat(a, b);
    }
    
    /**
     * tìm ra n số là bội chung nhỏ nhât của 2 số num1 và num2
     * @param num1
     * @param num2
     * @param n
     * @return 
     */
    public static List<Integer> findNLCMs(int num1, int num2, int n) {
        int lcm = timBoiSoChungNhoNhat(num1, num2);
        List<Integer> lcmList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lcmList.add(lcm * i);
        }
        return lcmList;
    }

}
