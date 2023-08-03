<%-- 
    Document   : login-form
    Created on : Jan 7, 2023, 9:56:04 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="process.jsp" method="GET">
            First Name: <input type="text" name="firstName" placeholder="First Name">
            <br>
            Last Name: <input type="text" name="lastName" placeholder="Last Name">
            <br>
            <hr/>
            <input type="submit" value="Press me">
        </form>
    </body>
</html>
