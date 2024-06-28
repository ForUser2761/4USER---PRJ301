<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: auto">
            <form style="margin: auto" action="list" method="POST">
                <table>
                    <tr>
                        <td colspan="2" style="text-align: center">Your text</td>
                    </tr>
                    <tr>
                        <td>Code:</td>
                        <td><input type="text" name="code" value="${code}"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="${name}"></td>
                    </tr>
                    <tr>
                        <td>Position:</td>
                        <td>
                            <select name="position">
                                <option value="Striker">Striker</option>
                                <option value="Goalkeeper">Goalkeeper</option>
                                <option value="Defender">Defender</option>
                                <option value="Midfielder">Midfielder</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Salary:</td>
                        <td><input type="text" name="salary" value="${salary}"></td>
                    </tr>
                    <tr> 
                        <td style="text-align: center" colspan="2"><input type="submit" value="CREATE" name="create"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red"><i>${error}</i></td>
                    </tr>
                    <tr>
                    </tr>
                </table>
                Your text
                <table border="1">
                    <tr>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Position</td>
                        <td>Salary</td>
                    </tr>
                    <c:forEach items="${listP}" var="o">
                        <tr>
                            <td>${o.code}</td>
                            <td>${o.name}</td>
                            <td>${o.position}</td>
                            <td>${o.salary}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>
