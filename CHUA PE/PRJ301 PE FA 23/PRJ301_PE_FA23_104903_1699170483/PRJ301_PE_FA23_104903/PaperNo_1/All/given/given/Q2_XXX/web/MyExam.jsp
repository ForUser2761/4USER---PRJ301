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
            <table>
                <tbody>
                    <tr>
                        <td>Code: </td>
                        <td>
                            <input type="text" name="code" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td>
                            <input type="text" name="name" value="" />

                        </td>
                    </tr>
                    <tr>
                        <td>Number of carriages: </td>
                        <td>
                            <input type="text" name="carri" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="ADD"/>
                        </td>
                        <td>
                            ${error}
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        List of Train:
        <br/>
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Number of carriages</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="t">
                <tr>
                    <td>${t.code}</td>
                    <td>${t.name}</td>
                    <td>${t.carr}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>


    </body>
</html>
