<%-- 
    Document   : viewCart
    Created on : Oct 15, 2022, 4:36:03 PM
    Author     : hd
--%>

<%@page import="sample.product.BookDTO"%>
<%@page import="sample.product.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Product inside the cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Brand</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (BookDTO p : cart.getCart().values()) {
                        total += p.getPrice()*p.getQuantity();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td> 
                        <input type="text" name="id" value="<%= p.getId()%>" readonly=""/>
                    </td>
                    <td><%= p.getName()%></td>
                    <td><%= p.getBrand()%></td>
                    <td><%= p.getPrice()%>$</td>
                    <td>
                        <input min="1" type="number" name="quantity" value="<%= p.getQuantity()%>" />
                    </td>
                    <td><%= p.getPrice() * p.getQuantity()%></td>

                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Update" onclick="this.value = 'UpdateProduct'">
                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <h1>Total:<%= total%> $  </h1>      
    <%
        }
    %>
    </br>
    <a href="shopping.jsp">Add more</a>
</body>
</html>
