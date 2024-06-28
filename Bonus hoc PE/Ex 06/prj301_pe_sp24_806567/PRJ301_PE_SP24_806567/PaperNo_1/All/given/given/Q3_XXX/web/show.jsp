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
        <table border="1">
            <thead>
                <tr>
                    <th>List of Coaches</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listC}" var="c">
                    <tr>
                        <td><a href="details?id=${c.getCoachID()}">${c.getCoachID()}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="action">
            <table>
                <tr>
                    <td>Code</td>
                    <td>
                        <input type="text" name="" value="${coaches.getCoachID()}"/>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="" value="${coaches.getCoachName()}"/></td>
                </tr>
                <tr>
                    <td>Pos</td>
                    <td><input type="text" name="" value="${coaches.getPosition()}"/></td>
                    <td><input type="submit" value="Delete"/></td>
                </tr>
                <tr>
                    <td>Sal</td>
                    <td><input type="text" name="" value="${coaches.getSalary()}"/></td>
                </tr>
                <tr>
                    <td>Team</td>
                    <td>
                        <c:forEach items="${listT}" var="o">
                            <c:if test="${coaches.getTeamID() == o.getTeamID()}">
                                <input type="text" name="" value="${o.getTeamName()}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
