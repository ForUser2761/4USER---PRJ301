<%-- 
    Document   : SignUp
    Created on : May 16, 2024, 3:14:15 PM
    Author     : nnkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="signup" method="POST" class="form-signup">
            <h1>Sign Up</h1>
            Username    <input name="user" type="text" class="form-control" placeholder="Username" />
            <br><br>
            Password    <input name="pass" type="password" class="form-control" placeholder="Password" />
            <br><br>
            Re-Password <input name="repass" type="password" class="form-control" placeholder="Re-Password" />
            <br><br>
            <button type="submit"> Sign up</ button>
        </form>
    </body>
</html>
