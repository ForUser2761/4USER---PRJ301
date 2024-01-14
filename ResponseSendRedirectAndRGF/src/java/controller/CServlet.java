package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get so luong nguoi dung muon
        int total = Integer.parseInt(request.getParameter("number"));
        Random random = new Random();
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            //STT
            int stt = i + 1;
            //Name ( Nguyeenx van + STT ) 
            String name = "Nguyen Van " + stt;
            // Tuoi ( random 1- 10)
            int age = random.nextInt(11);
            Student student = new Student(stt, name, age);
            list.add(student);
        }
        
        //set list vao trong request
        request.setAttribute("4user", list);
        //chuyen sang trang khac
        request.getRequestDispatcher("d").forward(request, response);
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
