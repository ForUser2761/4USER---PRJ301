<%-- 
    Author     : 4USER-FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="new" method="post">
            <h1>Train Information</h1>
            <table>
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code" value="" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                <tr>
                    <td>Number</td>
                    <td><input type="text" name="seat" value="" /></td>
                </tr>
                <tr>
                    <td>Booked</td>
                    <td><input type="text" name="book" value="" /></td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <button type="submit">Book</button>
                    </td>
                </tr>
            </table>
            ${error}
            ${code}
            ${name}
            ${seat}
            ${book}
            ${seat == book ? "Full" : "Not full"}
        </form>
    </body>
</html>
