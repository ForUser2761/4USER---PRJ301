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
                    <th>Id</th>
                    <th>Name</th>
                    <th>Credit</th>
                    <th>Instructor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="obj">
                <tr>
                    <td>${obj.getCourseID()}</td>
                    <td>${obj.getCourseName()}</td>
                    <td>${obj.getCreditHours()}</td>
                    <td>
                        <c:forEach items="${listInstructor}" var="o">
                            <c:if test="${o.getInstructorID() == obj.getManageByInstructorID()}">
                                ${o.getFirstName()} ${o.getLastName()}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
