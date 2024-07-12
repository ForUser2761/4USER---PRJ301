/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.dal.UserDAO;
import pe.model.tblUsers;

public class LoginController extends HttpServlet {
   
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
        //get ve cac thong tin 
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        
        tblUsers user = new UserDAO().findByUserIdAndPassword(userId,password);
        
        //TH1: ko tim thay
        if (user == null) {
            request.setAttribute("error", "Incorrect UserlD or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            //TH2: tim thay
        }else {
            request.getSession().setAttribute("user", user);
            //chuyen sang trang can thiet
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
    } 

}
