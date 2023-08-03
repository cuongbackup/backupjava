<%-- 
    Document   : result
    Created on : Jan 6, 2023, 11:48:48 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Calculator Result</h1>
        <%=request.getAttribute("RS")%><HR>
        <form action="CalController" method="GET">
            <input type="submit" value="Continue"/>
        </form>
    </body>
</html>
