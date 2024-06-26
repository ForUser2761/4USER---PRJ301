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
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>DOB</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listInstructor}" var="obj">
                    <tr>
                        <td>${obj.getInstructorID()}</td>
                        <td>${obj.getFirstName()} ${obj.getLastName()}</td>
                        <td>${obj.getEmail()}</td>
                        <td>${obj.getPhone()}</td>
                        <td>${obj.getGender()}</td>
                        <td>
                            <fmt:formatDate pattern="dd/MM/yyyy" value="${obj.getBirthDate()}"></fmt:formatDate>
                            </td>
                            <td>
                                <a href="details?id=${obj.getInstructorID()}">View Course</a>
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
