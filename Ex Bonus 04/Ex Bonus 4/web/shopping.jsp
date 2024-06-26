<%@page import="java.util.List"%>
<%@page import="sample.product.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CART</title>
    </head>
    <body>
        <%
            String searchCart = request.getParameter("searchCart");
            if (searchCart == null) {
                searchCart = "";
            }
        %>
        <h1>Welcome to product Store</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController" method="POST">
            <!--Search<input type="text" name="searchCart" value="<%= searchCart%>"/>-->
            <!--<input type="submit" name="action" value="SearchCart"/>-->
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            List<BookDTO> productList = (List<BookDTO>) request.getAttribute("Product_List");
            if (productList != null && !productList.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th> 
                    <th>Product name</th> 
                    <th>Price</th>
                    <th>Brand</th> 
                    <th>Add to cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (BookDTO product : productList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++ %></td>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getBrand() %></td>
                    <td>
                        <input type="hidden" name="id" value="<%= product.getId() %>">
                        <input type="hidden" name="name" value="<%= product.getName() %>">
                        <input type="hidden" name="price" value="<%= product.getPrice() %>">
                        <input type="hidden" name="brand" value="<%= product.getBrand()%>">
                        <input type="hidden" name="searchCart" value="<%= searchCart %>">
                        <input type="submit" name="action" value="Add">
                    </td>

                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <%= message %>
    </body>
</html>
