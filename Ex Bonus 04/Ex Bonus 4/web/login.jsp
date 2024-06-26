<%-- 
    Document   : login
    Created on : Sep 28, 2022, 5:09:16 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID"/></br>
            Password<input type="password" name="password"/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset"  value="Reset"/>
            
        </form>
        <% 
            String error= (String)request.getAttribute("message");
            if(error== null) error= "";
        %>
         <h1><%= error %></h1>
    </body>
</html>
