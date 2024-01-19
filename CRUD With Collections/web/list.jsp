<%-- 
    Document   : list
    Created on : Jan 19, 2024, 8:40:55 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Simple Form</title>
        <style>
            table {
                border-collapse: collapse;
                width: 50%;
                margin: 20px auto;
            }
            td, th {
                padding: 10px;
                text-align: left;
            }
            .label {
                font-weight: bold;
            }
            .checkbox-group {
                display: flex;
                align-items: center;
            }
            .checkbox-group label {
                margin-right: 10px;
                margin-left: 5px;
            }
            input[type="text"], input[type="submit"] {
                padding: 5px;
                margin: 5px 0;
            }
            input[type="submit"] {
                cursor: pointer;
            }

            table {
                border-collapse: collapse;
                width: 100%; /* Changed to full width for the second table */
                margin: 20px auto;
            }
            td, th {
                padding: 10px;
                text-align: left;
            }
            .label {
                font-weight: bold;
            }
            .checkbox-group {
                display: flex;
                align-items: center;
            }
            .checkbox-group label {
                margin-right: 10px;
                margin-left: 5px;
            }
            input[type="text"], input[type="submit"] {
                padding: 5px;
                margin: 5px 0;
            }
            input[type="submit"] {
                cursor: pointer;
            }
            /* Additional styles for the new table */
            .student-list {
                margin-top: 50px; /* Added space between the forms */
            }
            .student-list th {
                background-color: #f0f0f0; /* Light grey background for the header */
                border: 1px solid #ddd; /* Light border for the cells */
            }
            .student-list td {
                border: 1px solid #ddd;
            }
        </style>
    </head>
    <body>

        <form action="student?action=insert" method="post">
            <table border="1">
                <tr>
                    <td class="label">Id</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td class="label">Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td class="label">Gender</td>
                    <td>
                        <input type="radio" name="gender" value="male"> Male
                        <input type="radio" name="gender" value="female"/> Female
                    </td>
                </tr>
                <tr>
                    <td class="label">Age</td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td class="label">Hobbies</td>
                    <td>
                        <div class="checkbox-group">
                            <input type="checkbox" id="football" name="hobbies" value="football">
                            <label for="football">Football</label>

                            <input type="checkbox" id="cooking" name="hobbies" value="cooking">
                            <label for="cooking">Cooking</label>

                            <input type="checkbox" id="programming" name="hobbies" value="programming">
                            <label for="programming">Programming</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>

        <!-- New table for the list of students -->
        <h2>List of Students</h2> <!-- Title for the student list -->
        <table class="student-list" border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>Gender</th>
                <th>AGE</th>
                <th>HOBBIES</th>
            </tr>
            <!-- Add rows here with student data -->
            <!-- Example row: -->
            <c:forEach items="${list}" var="fu">
                <tr>
                    <td> ${fu.id}</td>
                    <td>${fu.name}</td>
                    <td>${fu.gender eq true ? 'male' : 'female'}</td>
                    <td>${fu.age}</td>
                    <td>
                        <c:forEach items="${fu.hobbies}" var="hob" >
                            ${hob} 
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            <!-- Repeat for more students -->
        </table>

    </body>
</html>

