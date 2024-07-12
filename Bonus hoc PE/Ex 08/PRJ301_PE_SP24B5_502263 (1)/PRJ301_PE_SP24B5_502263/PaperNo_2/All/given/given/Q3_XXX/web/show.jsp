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
        <form action="show" method="GET">
            Choose <select name="departId" onchange="return this.closest('form').submit()">
                <option value="-1" ${departId eq "-1" ? "selected" : ""}>All option</option>
                <option value="1" ${departId eq "1" ? "selected" : ""}>1 option</option>
                <option value="2" ${departId eq "2" ? "selected" : ""}>2 option</option>
                <option value="3" ${departId eq "3" ? "selected" : ""}>3 option</option>
            </select>
        </form>

        <table>
            <c:forEach items="${listBoat}" var="obj">
                <tr>
                    <td>${obj.getBoatID()}</td>
                    <td>${obj.getBoatName()}</td>
                    <td>${obj.getSeat()}</td>
                    <td>${obj.getBooked()}</td>
                    <td>${obj.getDepartPlaceID()}</td>
                    <td>${obj.getTicketID()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
