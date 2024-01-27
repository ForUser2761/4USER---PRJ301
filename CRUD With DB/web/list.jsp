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
                    <td name="id">${p.id}</td>
                    <td name="name">${p.name}</td>
                    <td name="price">${p.price}</td>
                    <td name="quantity">${p.quantity}</td>
                    <td>
                        <a href="#" onclick="editProduct(this)">Edit</a>
                        <form action="product?action=delete" style="display:inline" method="POST">
                            <input type="hidden" name="id" value="${p.id}"/>
                            <a href="#" onclick="return this.closest('form').submit()">Delete</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form action="product?action=insert" id="formAddEdit"  method="POST" style="display: none">
            <h1>Form</h1>
            <input type="hidden" name="id" value="0"/>
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

        function editProduct(e) {
            // display form
            displayForm();
            // get data
            let tr = e.closest('tr');
            let id = tr.querySelector('td[name="id"]').innerHTML;
            let name = tr.querySelector('td[name="name"]').innerHTML;
            let quantity = tr.querySelector('td[name="quantity"]').innerHTML;
            let price = tr.querySelector('td[name="price"]').innerHTML;

            // set data
            let form = document.querySelector("#formAddEdit");
            form.querySelector('input[name="name"]').value = name;
            form.querySelector('input[name="quantity"]').value = quantity;
            form.querySelector('input[name="price"]').value = price;
            form.querySelector('input[name="id"]').value = id;

            //set action
            form.action = "product?action=update";
        }
        
        function displayForm() {
            let form = document.querySelector("#formAddEdit");
            if (form.style.display === 'none') {
                form.style.display = 'block';
            } else {
                form.style.display = 'none';
            }
        }
    </script>
</html>