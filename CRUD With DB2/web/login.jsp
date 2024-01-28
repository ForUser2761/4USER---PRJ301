<%-- 
    Document   : login
    Created on : Jan 25, 2024, 6:54:35 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username <input type="text" name="username"/>
            <br/>
            Password <input type="password" name="password"/>
            <br/><!-- comment -->
            <div style="color:red">${error}</div>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
