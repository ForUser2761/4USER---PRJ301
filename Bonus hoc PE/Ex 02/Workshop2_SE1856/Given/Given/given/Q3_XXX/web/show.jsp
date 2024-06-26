<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Show Students</title>
        <style>
            table,form,div {
                display: inline-block;
            }
        </style>
    </head>
    <body>
        <div>
            <h2>LIST OF ID STUDENTS</h2>
            <table border="1" style="display: inline-block">
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>
                            <a href="show?action=detail&id=${student.id}">${student.id}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <h2>INFORMATION OF STUDENT</h2>
            <table border="1">
                <form action="show" method="get">
                    <input type="hidden" name="action" value="filterByMajor"/>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" value="${student.id}" readonly/></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="${student.name}" readonly/></td>
                    </tr>
                    <tr>
                        <td>DATE OF BIRTH:</td>
                        <td><input type="text" name="dob" value="${student.dob}" readonly/></td>
                        <td>
                            <input type="submit" value="CHOOSE"/>
                        </td>
                    </tr>
                    <tr>
                        <td>GENDER:</td>
                        <td><input type="text" name="gender" value="${student.gender}" readonly/></td>
                    </tr>
                    <tr>
                        <td>MAJOR:</td>
                        <td><input type="text" name="major" value="${student.major}" readonly/></td>
                    </tr>
            </table>
        </form>
    </div>

    <div style="display:block">      
        <h2>STUDENTS WITH THE SAME MAJOR</h2>      
        <table border="1">         
            <tr>               
                <th>ID</th>            
                <th>Name</th>               
                <th>Date of Birth</th>                
                <th>Gender</th>               
                <th>Major</th>          
            </tr>          
            <c:forEach var="sameStudent" items="${sameStudents}">        
                <tr>                     
                    <td>${sameStudent.id}</td>      
                    <td>${sameStudent.name}</td>       
                    <td>${sameStudent.dob}</td>      
                    <td>${sameStudent.gender}</td>    
                    <td>${sameStudent.major}</td>       
                </tr>         
            </c:forEach>  
        </table>     
    </div>
</body>
</html>
