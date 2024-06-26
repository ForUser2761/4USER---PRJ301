<%-- 
    Document   : admin
    Created on : Sep 28, 2022, 5:10:03 PM
    Author     : hd
--%>

<%@page import="sample.product.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null ) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        Welcome: <h1><%= loginUser.getFullName()%></h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController">
            Search<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>
          
        </form>
        <%
             List<BookDTO>ProductList = (List) request.getAttribute("Product_List");
            if (ProductList!= null) {
                if (ProductList.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th> 
                    <th>Product name</th> 
                    <th>Price</th>
                    <th>brand</th> 
                    <th>Action</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (BookDTO i : ProductList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td><%= i.getId() %></td>
                    <td><input type="text" name="name" value="<%= i.getName()%>"></td>
                     <td><input type="text" name="brand" value="<%= i.getBrand()%>"></td>
                    <td><input type="text" min="0" max="9999" name="price" value="<%= i.getPrice()%>"></td               
                    <td> 
                        <input type="hidden" name="id" value="<%= i.getId()%>">
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search %>"/>
                      
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <%
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
    %>
    <%= message%>

    
    

    <%
            }
        }
    %>
</body>
</html>
