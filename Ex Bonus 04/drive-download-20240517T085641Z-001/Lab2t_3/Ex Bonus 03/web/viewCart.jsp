<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>

    <body>
        <h2>Your Shopping Cart</h2>
        <table border="1">
            <tr>
                <th>SKU</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${sessionScope.cart.cart}" var="entry">
                <tr>
                    <td>${entry.value.SKU}</td>
                    <td>${entry.value.name}</td>
                    <td>${entry.value.description}</td>
                    <td>${entry.value.price}</td>
                    <td>
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="sku" value="${entry.value.SKU}">
                            <input type="number" name="quantity" value="${entry.value.quantity}" min="1">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="sku" value="${entry.value.SKU}">
                            <input type="submit" value="Remove">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h3>Total Price: ${sessionScope.cart.totalPrice}</h3>
        <br>
        <a href="product">Continue Shopping</a>
    </body>

</html>
