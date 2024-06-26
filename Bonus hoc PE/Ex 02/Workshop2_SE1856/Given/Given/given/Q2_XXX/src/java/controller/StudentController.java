package controller;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");

        List<Student> students = (List<Student>) session.getAttribute("students");
        if (students == null) {
            students = new ArrayList<>();
        }

        boolean codeExists = students.stream().anyMatch(student -> student.getCode().equals(code));

        if (codeExists) {
            request.setAttribute("error", "Code existed");
        } else {
            Student newStudent = new Student(code, name, dob, gender, major);
            students.add(newStudent);
            session.setAttribute("students", students);
            request.setAttribute("error", "");
        }

        request.getRequestDispatcher("q2.jsp").forward(request, response);
    }
}
