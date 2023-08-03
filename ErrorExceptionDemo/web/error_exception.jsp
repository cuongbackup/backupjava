<%-- 
    Document   : error_exception
    Created on : Feb 15, 2023, 7:59:56 AM
    Author     : Administrator
--%>
<%@ page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sorry an exception has occured</h1>
        <p>Exception is:</p>
        <%=exception%>
    </body>
</html>
