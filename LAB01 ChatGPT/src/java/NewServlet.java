/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();

        // Retrieve form data using request.getParameter() method
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String[] languages = request.getParameterValues("language"); // This is for checkboxes
        String courseDuration = request.getParameter("courseDuration");
        String additionalInfo = request.getParameter("additionalInfo");

        // Here you can process the data as needed, and for example, save it to a database
        // For demonstration, let's print the data received from the form
        out.println("<html><body>");
        out.println("<h2>Received Form Data</h2>");
        out.println("<p>Full Name: " + fullName + "</p>");
        out.println("<p>Phone Number: " + phone + "</p>");
        out.println("<p>Gender: " + gender + "</p>");
        out.println("<p>Languages Chosen: ");
        if (languages != null) {
            for (String language : languages) {
                out.print(language + " ");
            }
        }
        out.println("</p>");
        out.println("<p>Course Duration: " + courseDuration + "</p>");
        out.println("<p>Additional Info: " + additionalInfo + "</p>");
        out.println("</body></html>");
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
