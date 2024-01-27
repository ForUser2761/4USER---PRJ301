<%-- Document : list Created on : Jan 25, 2024, 7:20:24 AM Author : ADMIN --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <form action="product?action=search" method="POST">
            <input type="text" name="keyword" placeholder="Nhap vao name cua san pham"/>
            <input type="submit" value="Search"/>
        </form>
        
        <br/>
        <button onclick="addProduct()">Add</button>
        <br/>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="product?action=insert" id="formAddEdit"  method="POST" style="display: none">
            <h1>Form</h1>
            Name <input type="text" name="name"/>
            <br/>
            Quantity <input type="number" name="quantity"/>
            <br/>
            Price <input type="text" name="price"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
    
    <script>
        function addProduct() {
            displayForm();
            
            
        }
        
        function displayForm() {
            let form = document.querySelector("#formAddEdit");
            if(form.style.display === 'none') {
                form.style.display = 'block';
            }else {
                form.style.display = 'none';
            }
        }
    </script>
</html>