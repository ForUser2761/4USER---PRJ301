<%-- 
    Author     : 4USER-FPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>List of Students</title>
    </head>
    <body>

        <form action="list?action=searchBySBID" method="POST" id="listOfSubject">
            List of Subjects
            <select name="subjectId" onload="return this.closest('form').submit();" onchange="return this.closest('form').submit()">
                <c:forEach items="${listSBJ}" var="obj">
                    <option value="${obj.getSubjectID()}" ${subjectId == obj.getSubjectID() ? 'selected' : ''}>
                        ${obj.getSubjectName()}</option>
                    </c:forEach>
            </select>
        </form>
        <br/>
        <br/>
        <br/>
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Subject</th>
                <th>Select</th>
            </tr>
            <c:forEach items="${listStudent}" var="s">
                <tr>
                    <td name="id">${s.getStudentID()}</td>
                    <td name="name">${s.getStudentName()}</td>
                    <td name="date">${s.getBirthDate()}</td>
                    <td name="gender">${s.isGender() == true ? 'Male' : 'Female'}</td>
                    <td name="subject">
                        <c:forEach items="${listSBJ}" var="obj">
                            <c:if test="${obj.getSubjectID() == s.getSubjectID()}">
                                ${obj.getSubjectName()}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="#" onclick="selectItem(this)">Select</a>
                        <form action="list?action=delete&id=${s.getStudentID()}&sbId=${s.getSubjectID()}" method="POST">
                            <a href="#" onclick="return this.closest('form').submit()">Delete</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3>Detail information:</h3>
        <form id="details-form">
            <label for="code">Code:</label><br>
            <input type="text" id="code" name="code"><br>
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <label for="dob">Date of birth:</label><br>
            <input type="date" id="dob" name="dob"><br>
            <label>Gender:</label><br>
            <input type="radio" id="male" name="gender" value="male">
            <label for="male">Male</label><br>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Female</label><br>
            <label for="subject">Subject:</label><br>
            <select name="subject" >
                <c:forEach items="${listSBJ}" var="obj">
                    <option value="${obj.getSubjectID()}" >
                        ${obj.getSubjectName()}
                    </option>
                </c:forEach>
            </select>

        </form>

        <script>
            function selectItem(element) {
                let tr = element.closest('tr');
                let id = tr.querySelector('td[name=id]').innerText.trim();
                let name = tr.querySelector('td[name=name]').innerText.trim();
                let date = tr.querySelector('td[name=date]').innerText.trim();
                let gender = tr.querySelector('td[name=gender]').innerText.trim();
                let subject = tr.querySelector('td[name=subject]').innerText.trim();

                //let form
                let form = document.querySelector('#details-form');
                form.querySelector('input[name=code]').value = id;
                form.querySelector('input[name=name]').value = name;
                form.querySelector('input[name=dob]').value = date;
                if (gender === 'Male') {
                    form.querySelector('input[name=gender][value=male]').checked = true;
                } else {
                    form.querySelector('input[name=gender][value=female]').checked = true;
                }
                form.querySelector('select[name=subject]')
                        .querySelectorAll('option').forEach(option => {
                        if(option.innerText.trim() === subject) {
                            option.selected = true;
                        }
                });
            }
        </script>
    </body>
</html>

