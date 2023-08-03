<%-- 
    Document   : student-form
    Created on : Mar 6, 2023, 9:10:59 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/add-student-style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>add-student-form</h1>
        <form action="StudentControllerServlet" method="GET">
            <input type="hidden" name="command" value="ADD" />

            <table border="0">
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td> <input type="text" name="firstName" value="" /></td>
                    </tr>

                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label> </td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <p>
            <a href="StudentControllerServlet"> Back to the List</a>
        </p>
    </body>
</html>
