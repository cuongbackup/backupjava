<%-- 
    Document   : index
    Created on : Mar 6, 2023, 10:29:26 AM
    Author     : Administrator
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="name" value="test name"></c:set>
        <c:out value="Name is: ${name}"></c:out>
    </body>
</html>
