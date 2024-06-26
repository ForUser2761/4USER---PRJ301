<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
    <style>
        .error {
            color: red;
        }
        .avatar {
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }
    </style>
</head>
<body>
    <h2>INFORMATION OF STUDENT</h2>
    <form action="StudentController" method="post">
        Code: <input type="text" name="code" required/><br/>
        Name: <input type="text" name="name" required/><br/>
        Date Of Birth: <input type="date" name="dob" required/><br/>
        Gender:
        <input type="radio" name="gender" value="Male" required/> Male
        <input type="radio" name="gender" value="Female" required/> Female<br/>
        Major:
        <select name="major" required>
            <option value="Software Engineering">Software Engineering</option>
            <option value="Business Administration">Business Administration</option>
            <option value="Information Assurance">Information Assurance</option>
            <option value="Multimedia Communications">Multimedia Communications</option>
        </select><br/>
        <input type="submit" value="Add Student"/>
        <span class="error">${error}</span>
    </form>

    <h2>List of FPT Students:</h2>
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Major</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.code}</td>
                <td>${student.name}</td>
                <td>${student.dob}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.gender == 'Male'}">
                            <img src="avt/male-icon.png" alt="Male Avatar" class="avatar"/>
                        </c:when>
                        <c:when test="${student.gender == 'Female'}">
                            <img src="avt/female-icon.png" alt="Female Avatar" class="avatar"/>
                        </c:when>
                    </c:choose>
                </td>
                <td>${student.major}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
