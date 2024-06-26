<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>

    <body>
        <table border="1">
            <tr>
                <th>SKU</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td>${p.SKU}</td>
                    <td>${p.name}</td>
                    <td>${p.description}</td>
                    <td>${p.price}</td>
                    <td>
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="sku" value="${p.SKU}">
                            <input type="hidden" name="name" value="${p.name}">
                            <input type="hidden" name="description" value="${p.description}">
                            <input type="hidden" name="price" value="${p.price}">
                            <input type="submit" value="Add to cart"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br> 
        <br>
        <a href="login.jsp"> Back to login</a>
        <br>
        <br>
        <a href="viewCart.jsp">Click here to show your cart</a>
        <br> 
        <br> 
        ket qua: ${price}
    </body>

</html>
