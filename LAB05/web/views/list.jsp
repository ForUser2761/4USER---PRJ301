<%-- 
    Document   : list
    Created on : Jan 15, 2024, 6:09:52 AM
    Author     : ADMIN
--%>

<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("4user");%>
    </head>
    <body>
        <h1 style="text-align: center">List Product</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Provider</th>
                    <th>Unit Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Product pro : list) {

                %>
                <tr>
                    <td>
                        <%= pro.getId()%>
                    </td>
                    <td>                        
                        <%= pro.getName()%>
                    </td>
                    <td>                        
                        <%= pro.getProvider()%>
                    </td>
                    <td>                        
                        <%= pro.getPrice()%>
                    </td>
                    <td colspan="2">
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
