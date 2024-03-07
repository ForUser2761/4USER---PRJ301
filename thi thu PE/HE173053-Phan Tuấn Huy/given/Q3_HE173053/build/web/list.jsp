<%-- 
    Document   : list
    Created on : 6 Mar 2024, 11:26:57
    Author     : mtxt hp
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
        <form id="subjectForm" action="show" method="GET">
            List of Subject:
            <select name="subject" onchange="this.form.submit()">
                <option value="all" <c:if test="${empty param.subject}">selected</c:if>>All Subject</option>
                <c:forEach items="${listSj}" var="i">
                    <option value="${i.subid}" <c:if test="${param.subject eq i.subid}">selected</c:if>>${i.name}</option>
                </c:forEach>
            </select><br>
        </form>
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Subject</th>
                <th>Select</th>
            </tr>
            <c:forEach items="${requestScope.listSt}" var="s">
                <tr>
                    <th>${s.stid}</th>
                    <th>${s.name}</th>
                    <th>${s.dob}</th>
                    <th>
                        ${s.gender == 0 ? 'Female' : s.gender == 1 ? 'Male' : ''}
                    </th>
                    <th>${s.subject}</th>
                    <th><a href="show?id=${s.stid}">Select</a></th>
                </tr>
            </c:forEach>
        </table>
        <c:set var="i" value="${requestScope.s}"/>
        Detail Information
        <form>
            Code:<input type="text" name="stid" value="${s.stid}"/>
            Name<input type="text" name="name" value="${s.name}"/>
            Date of birth<input type="date" name="dob" value="${s.dob}"/>
            Subject<input type="text" name="sbid" value="${s.subject}"/>
            <input type="radio" name="gender" value="male" ${s.gender == '1' ? 'checked' : ''}/> Male
            <input type="radio" name="gender" value="female" ${s.gender == '0' ? 'checked' : ''}/> Female
        </form>

    </body>
</html>
