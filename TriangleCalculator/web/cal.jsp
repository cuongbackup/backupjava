<%-- 
    Document   : Cal
    Created on : Jan 11, 2023, 7:29:15 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Triangle Calculator</title>
    </head>
    <body>
        <h1>My Triangle Calculator</h1>
        <form action="TriangleController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Side 1: </td>
                        <td><input type="text" name="side1" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Side 2: </td>
                        <td><input type="text" name="side2" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Side 3: </td>
                        <td><input type="text" name="side3" value="" size="20" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>
            <input type="submit" value="Validation" name="action" size="10"/>
        </form>
    </body>
</html>
