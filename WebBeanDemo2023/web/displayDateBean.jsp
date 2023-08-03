<%-- 
    Document   : displayDateBean
    Created on : Feb 13, 2023, 10:10:53 AM
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
        <jsp:useBean id="date" class="java.util.Date"/>
        <p>The date/time is <%= date %>
    </body>
</html>
