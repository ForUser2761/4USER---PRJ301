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

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Player> listP = (List<Player>) session.getAttribute("listP");
        //kiem tra tren session co list player chua, chua thi tao list moi
        if (listP == null) {
            listP = new ArrayList<>();
        }

        try {
            //get ve thong tin
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            int salary = Integer.parseInt(request.getParameter("salary"));

            if (salary <= 0) {
                request.setAttribute("code", code);
                request.setAttribute("name", name);
                request.setAttribute("position", position);
                request.setAttribute("salary", salary);
                throw new NumberFormatException();
            }

            for (Player player : listP) {
                if (player.getCode().equalsIgnoreCase(code)) {
                    request.setAttribute("code", code);
                    request.setAttribute("name", name);
                    request.setAttribute("position", position);
                    request.setAttribute("salary", salary);
                    throw new IllegalArgumentException();
                }
            }

            //tao doi tuong player
            Player player = new Player(code, name, position, salary);
            //them vao trong list
            listP.add(player);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "You must input an integer > 0 for salary");
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Code Existed");
        }
        session.setAttribute("listP", listP);
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

}
