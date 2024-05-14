<%-- 
    Document   : mySum
    Created on : 6 Mar 2024, 10:48:42
    Author     : mtxt hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sum" method="post">
        Enter an integer n:<input type="text" name="number" value="${param.number}"><br>
        Result: <input type="text" value="${result}"><br>
      
        <input type="submit" value="SUM">  
        <p>${error}</p>
    </body>
</html>
