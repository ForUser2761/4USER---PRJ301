/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        //get ve list o tren session
        List<Train> list = (List<Train>) session.getAttribute("list");
        try {
            //lay ve du lieu nguoi dung nhap
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String carr = request.getParameter("carr");
            //kiem tra validate
            if (code.isBlank() || name.isBlank() || carr.isBlank()) {
                request.setAttribute("error", "You must input all text");
                request.setAttribute("code", code);
                request.setAttribute("name", name);
                request.setAttribute("carr", carr);
            }else {
                //moi lan dau chay chua he co list tren session
                if (list == null) {
                    list = new ArrayList<>();
                }
                //them vao trong llist
                Train train = new Train(code, name, carr);
                list.add(train);
                
            }
            //set vao trong session
            session.setAttribute("list", list);
            //back lai trang myexam.jsp
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
