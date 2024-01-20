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

        <form action="student?action=insert" method="post" id="form">
            <h1 style="text-align: center">INSERT</h1>
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
                        <input type="radio" name="gender" value="female" checked/> Female
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
        <div style="text-align: center; margin-bottom: 20px;">
            <form action="student?action=search" method="POST">
                <input type="text" name="keyword" placeholder="Search for students...">
                <input type="submit" value="Search">
            </form>
        </div>
        <table class="student-list" border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>Gender</th>
                <th>AGE</th>
                <th>HOBBIES</th>
                <th>Action</th>
            </tr>
            <!-- Add rows here with student data -->
            <!-- Example row: -->
            <c:forEach items="${list}" var="fu">
                <tr>
                    <td name="id"> ${fu.id}</td>
                    <td name="name">${fu.name}</td>
                    <td name="gender">${fu.gender eq true ? 'male' : 'female'}</td>
                    <td name="age">${fu.age}</td>
                    <td name="hobbies">
                        <c:forEach items="${fu.hobbies}" var="hob" >
                            ${hob} 
                        </c:forEach>
                    </td>
                    <td >
                        <a href="#" onclick="update(this)">Edit</a>
                        <form action="student?action=delete" method="POST" >
                            <input type="hidden" name="id" value="${fu.id}"/>
                            <a href="#" onclick="submitFunction(this)">Delete</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <!-- Repeat for more students -->
        </table>

        <script>
            function update(e) {
                let form = document.querySelector("#form");
                //+ đổi lại title h1 trong form thành update
                form.querySelector("h1").innerText = "UPDATE";
                //+ chuyển form với thuộc tính aciton => student?action = update
                form.action = "student?action=update";

                //lấy dữ liệu ở record mà người dùng bấm
                let tr = e.closest('tr');
                let idRecord = tr.querySelector("td[name='id']").textContent;
                let nameRecord = tr.querySelector("td[name='name']").textContent;
                let genderRecord = tr.querySelector("td[name='gender']").textContent;
                let ageRecord = tr.querySelector("td[name='age']").textContent;
                let hobbbies = tr.querySelector("td[name='hobbies']").textContent.trim().split(' ');
                let filteredHobbies = hobbbies.filter(function (hobb) {
                    return hobb.trim() != '';
                });

                //đắp dữ liệu lên form
                form.querySelector("input[name='id']").value = idRecord;
                form.querySelector("input[name='name']").value = nameRecord;
                form.querySelector("input[name='age']").value = ageRecord;
                let hobbiesInput = form.querySelectorAll("input[name='hobbies']");

                // Đặt trạng thái checked cho nút radio gender
                if (genderRecord.trim().toLowerCase() === "male") {
                    form.querySelector("input[name='gender'][value='male']").checked = true;
                } else if (genderRecord.trim().toLowerCase() === "female") {
                    form.querySelector("input[name='gender'][value='female']").checked = true;
                }

                // Xóa trạng thái checked hiện tại của các hộp kiểm hobbies
                form.querySelectorAll("input[name='hobbies']").forEach(checkbox => {
                    checkbox.checked = false;
                });

//                filteredHobbies.forEach(function (hobb) {
//                    hobbiesInput.forEach(function (input) {
//                        if (input.value === hobb) {
//                            input.checked = true;
//                        }
//                    });
//                });
                filteredHobbies.forEach(function (hobby) {
                    let checkbox = form.querySelector("input[name='hobbies'][value='" + hobby + "']");
                    if (checkbox) {
                        checkbox.checked = true;
                    }
                });


            }
            
            function submitFunction(e) {
                let form = e.closest('form');
                form.submit();
            }
        </script>

    </body>
</html>

