<%-- 
    Document   : cal
    Created on : Jan 6, 2023, 11:48:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <h1>My Calculator</h1>
        <form action="CalController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Number 1: </td>
                        <td><input type="text" name="num1" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Number 2: </td>
                        <td><input type="text" name="num2" value="" size="20" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>
            <input type="submit" value="+" name="action" size="10"/>
            <input type="submit" value="-" name="action" size="10"/>
            <input type="submit" value="*" name="action" size="10"/>
            <input type="submit" value="/" name="action" size="10"/>
        </form>
    </body>
</html>
