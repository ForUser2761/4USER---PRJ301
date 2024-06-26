/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Student> students = studentDAO.getAllStudents();
        HttpSession session = request.getSession();
        session.setAttribute("students", students);
        if ("show".equals(action)) {
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else if ("detail".equals(action)) {
            String studentId = request.getParameter("id");
            Student student = studentDAO.getStudentById(studentId);
            if (student != null) {
                request.setAttribute("student", student);
//                List<Student> sameStudents = studentDAO.getStudentsByMajor(student.getMajor());
//                request.setAttribute("sameStudents", sameStudents);
                request.getRequestDispatcher("show.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Student not found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if ("filterByMajor".equals(action)) {
            String major = request.getParameter("major");
            students = studentDAO.getStudentsByMajor(major);
            request.setAttribute("sameStudents", students);
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
