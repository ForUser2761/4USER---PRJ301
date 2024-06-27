<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title><style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                width: 80%;
                max-width: 800px;
            }

            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            header h1 {
                margin: 0;
            }

            .logout-button {
                background-color: #ff4d4d;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            .logout-button:hover {
                background-color: #e60000;
            }

            main {
                margin-bottom: 20px;
            }

            .search-form {
                display: flex;
                flex-direction: column;
            }

            .search-form label {
                margin-bottom: 5px;
                font-weight: bold;
            }

            .search-form input[type="text"],
            .search-form button {
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .search-form button {
                background-color: #007BFF;
                color: white;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .search-form button:hover {
                background-color: #0056b3;
            }

            .results-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .results-table th,
            .results-table td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            .results-table th {
                background-color: #f2f2f2;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Welcome ${user.fullName}</h1>
                <a href="MainController?action=logout" class="logout-button">Log Out</a>
            </header>
            <main>
                <h2>Search</h2>
                <form action="MainController?action=search" method="post" class="search-form">
                    <label for="description">Description</label>
                    <input type="text" id="keyword" name="keyword">
                    <button type="submit">Search</button>
                </form>
            </main>
            <section>
                <h2>Search Results</h2>
                <table class="results-table">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>name</th>
                            <th>price</th>
                            <th>size</th>
                            <th>description</th>
                            <th>status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="obj" varStatus="count">
                        <%-- Code to display search results will go here --%>
                        <tr>
                            <td>${count.index + 1}</td>
                            <td>${obj.id}</td>
                            <td>${obj.name}</td>
                            <td>${obj.price}</td>
                            <td>${obj.size}</td>
                            <td>${obj.description}</td>
                            <td>${obj.status}</td>
                            <td>
                                <a href="delete?id=${obj.id}">Delete</a>
                            </td>
                            
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
    </body>
</html>
