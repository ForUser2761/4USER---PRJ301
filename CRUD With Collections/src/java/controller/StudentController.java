/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
    ManageStudent manage = new ManageStudent();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "insert":
                insert(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                throw new AssertionError();
        }
        //chuyen ve lai trang home controller
        response.sendRedirect("home");
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        //get ra thong tin
        String id = request.getParameter("id");
        String name =request.getParameter("name");
        boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
        int age = Integer.parseInt(request.getParameter("age"));
        String[] hobbies_raw = request.getParameterValues("hobbies");
        List<String> listHobbies = new ArrayList<>(Arrays.asList(hobbies_raw));
        
        
        //tao doi tuong Student
        Student student = new Student(id, name, age, gender, listHobbies);
        
        //them vao ben trong list 
        manage.add(student);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id").trim();
        String name =request.getParameter("name").trim();
        boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
        int age = Integer.parseInt(request.getParameter("age").trim());
        String[] hobbies_raw = request.getParameterValues("hobbies");
        List<String> listHobbies = new ArrayList<>(Arrays.asList(hobbies_raw));
        
        //tao doi tuong Student
        Student student = new Student(id, name, age, gender, listHobbies);
        manage.update(student);
    }

}
