<%-- 
    Author     : 4USER-FPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Code</td>
                        <td><input type="text" name="code" value="${code}" /></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="${name}" /></td>
                    </tr>
                    <tr>
                        <td>Carriages</td>
                        <td><input type="text" name="carr" value="${carr}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add" /></td>
                        <td>${error}</td>
                    </tr>
                </tbody>
            </table>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>cODE</th>
                    <th>Name</th>
                    <th>Carriage</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.code}</td>
                    <td>${o.name}</td>
                    <td>${o.carr}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
