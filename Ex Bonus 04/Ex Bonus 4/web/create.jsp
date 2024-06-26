<%@page import="sample.product.ProductError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product Page</title>
        
    </head>
    <body>
        <%
            ProductError productError = (ProductError)request.getAttribute("PRODUCT_ERROR");
            if(productError == null){
                productError = new ProductError();
            }
        %>
        <h1>Input product information</h1>
        <form action="MainController" method="POST">
            Product ID<input type="text" name="id" required=""/>
            <%= productError.getId() %></br>

            
            Product Name<input type="text" name="name" required=""/>
            <%= productError.getName()%></br>
            Price<input type="number" step="0.01" name="price" required=""/></br>
            </br>
            Description<input type="text" name="description" required=""/>
            </br>
            Size<input type="text" name="size" required=""/>
            </br>
            For sale? <input type="checkbox" name="status" value="true">
            </br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset"  value="Reset"/>
            <a href="admin.jsp">Back</a>
        </form>
    </body>
</html>
