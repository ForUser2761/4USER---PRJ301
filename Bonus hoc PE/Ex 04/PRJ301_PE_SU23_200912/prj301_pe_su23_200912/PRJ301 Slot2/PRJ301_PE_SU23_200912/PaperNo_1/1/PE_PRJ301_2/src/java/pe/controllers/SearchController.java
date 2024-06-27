/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.dal.PaintingDAO;
import pe.model.tblPainting;

public class SearchController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        //tim ve list cac doi tuong dua tren ham cua DAO
        List<tblPainting> list = new PaintingDAO().findByProp("description", keyword);
        //set vao request
        request.setAttribute("list", list);
        //quay tro lai trang paintinglist.jsp
        request.getRequestDispatcher("paintingList.jsp").forward(request, response);
    }
   

}
