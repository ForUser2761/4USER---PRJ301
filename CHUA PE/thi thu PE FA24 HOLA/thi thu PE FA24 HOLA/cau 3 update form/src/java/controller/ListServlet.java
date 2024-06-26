/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Students;
import model.Subjects;

public class ListServlet extends HttpServlet {

    SubjectDAO sbjDAO = new SubjectDAO();
    StudentDAO stDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get ve tat ca cac subject
        List<Subjects> listSBJ = sbjDAO.findAll();
        //get ve tat ca cac student by sbj at first
        List<Students> listStudent = new ArrayList<>();
        if (!listSBJ.isEmpty()) {
            listStudent = stDAO.findBySBID(listSBJ.get(0).getSubjectID());
        }
        //set vao trong session
        HttpSession session = request.getSession();
        session.setAttribute("listSBJ", listSBJ);
        session.setAttribute("listStudent", listStudent);
        //chuyen sang trang index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        switch (action) {
            case "searchBySBID":
                //get ve id cua subject
                String subjectId = request.getParameter("subjectId");
                //tim kiem cac student by subject id
                List<Students> listStudent = stDAO.findBySBID(subjectId);
                //set list vao trong session
                session.setAttribute("listStudent", listStudent);
                // chuyen sang trang index.jsp
                request.setAttribute("subjectId", subjectId);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "delete":
                String id = request.getParameter("id");
                String sbId = request.getParameter("sbId");
                stDAO.deleteById(id);
                List<Students> listStudent2 = stDAO.findBySBID(sbId);
                session.setAttribute("listStudent", listStudent2);
                // chuyen sang trang index.jsp
                request.setAttribute("subjectId", sbId);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("show");
        }
    }

}
