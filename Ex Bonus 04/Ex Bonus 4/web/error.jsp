<%-- 
    Document   : error
    Created on : Sep 28, 2022, 5:02:15 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <% 
            String error= (String)request.getAttribute("ERROR");
            if(error== null) error= "";
        %>
        Error: <h1><%= error %></h1>
    </body>
</html>
