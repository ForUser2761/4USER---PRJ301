<%-- 
    Document   : list
    Created on : Jan 15, 2024, 5:10:43 AM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <% ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("4user");%>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Student s : list) {

                %>
                <tr>
                    <td>
                        <%= s.getStt() %>
                    </td>
                    <td>
                        <%= s.getName() %>
                    </td>
                    <td>
                        <%= s.getAge() %>
                    </td>
                </tr>

                <%                    }
                %>

            </tbody>
        </table>

    </body>
</html>
