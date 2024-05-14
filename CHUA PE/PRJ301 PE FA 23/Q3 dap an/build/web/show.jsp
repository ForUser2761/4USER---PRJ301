<%-- 
    Author     : 4USER-FPT
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table border="0">
            <tbody>
                <tr>
            <form action="show?action=filterByName" method="POST">
                <td>Customer name:</td>
                <td><input type="text" name="name" value="" /></td>
                <td><input type="submit" value="Filter by name" /></td>
            </form>
        </tr>
        <tr>
        <form action="show?action=filterByYear" method="POST">
            <td>DOB</td>
            <td><input type="text" name="dob" value="" /></td>
            <td><input type="submit" value="Filter by year" /></td>
        </form>
    </tr>
</tbody>
</table>


<table border="1">
    <thead>
        <tr>
            <th>Ciode</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Gender</th>
            <th>Address</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="o">
            <tr>
                <td>${o.getCustomerID()}</td>
                <td>${o.getCustomerName()}</td>
                <td>
                    <fmt:formatDate value="${o.getBirthDate()}" pattern="yyyy-MM-dd" />
                </td>
                <td>${o.isGender() == true ? 'Male' : 'Female'}</td>
                <td>${o.getAddress()}</td>
                <td>
                    <form action="show?action=delete&id=${o.getCustomerID()}" method="POST">
                        <a href="#" onclick="return this.closest('form').submit();">Delete</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
