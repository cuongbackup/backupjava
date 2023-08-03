<%-- 
    Document   : getProperties
    Created on : Feb 13, 2023, 10:19:44 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Properties JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="user" class="entity.User" scope="application"></jsp:useBean>
        First Name: <jsp:getProperty property="firstName" name="user"></jsp:getProperty>
        <br/>
        <br/>
        Last Name: <jsp:getProperty property="lastName" name="user"></jsp:getProperty>
    </body>
</html>
