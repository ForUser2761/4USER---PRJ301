<%-- 
    Document   : login
    Created on : 10/06/2023, 12:44:45 PM
    Author     : Truong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .login-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }

            .login-container h2 {
                margin-bottom: 20px;
            }

            .login-container label {
                display: block;
                text-align: left;
                margin-bottom: 5px;
            }

            .login-container input {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                padding-right: 0px;
            }

            .login-container button {
                width: 100%;
                padding: 10px;
                background-color: #007BFF;
                border: none;
                border-radius: 5px;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
            }

            .login-container button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <!--your code here-->
        <div class="login-container">
            <h2>Login</h2>
            <form action="MainController" method="POST">
                <input type="hidden" name="action" value="login"/>
                <label for="username">UserId</label>
                <input type="text" id="username" name="userId" required>

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <div style="color: red">${error}</div>
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>
