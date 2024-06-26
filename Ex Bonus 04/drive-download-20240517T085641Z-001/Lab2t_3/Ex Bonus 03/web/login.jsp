<%-- 
    Document   : login
    Created on : May 16, 2024, 1:25:44 PM
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
        <h1>-----Login form-----</h1>
        <table>
            <form action="login" method="POST">

                <tr>
                    <td>Username</td>
                    <td> <input type="text" name="username"/> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/> </td>
                </tr>
                
                <tr>
                    <td><input type="submit" name="Submit" /> </td>
                    <td> <input type="reset" name="Reset"/></td>
                </tr>              
            </form>
        </table>
                    <div style="color:red" > ${error}</div>
                <a href="SignUp.jsp">Click here to create new account</a>
                </br>
                <a href="product"> Click here to buy</a>
    </body>
</html>
