<%-- 
    Document   : result
    Created on : Jan 11, 2023, 9:02:10 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    <body>
        <h1>Calculator Result</h1>
    <c:choose>
        <c:when test="${RS==1}">
            <c:out value ="Is a triangle"></c:out>
            <c:out value ="Parameter: <%=request.getAttribute("RS1")%>"></c:out>
            <c:out value ="Area: <%=request.getAttribute("RS2")%>"></c:out>
        </c:when>
        <c:otherwise>
            <c:out value ="Is not a triangle"></c:out>
        </c:otherwise>
    </c:choose>
    <form action="TriangleController" method="GET">
        <input type="submit" value="Continue"/>
    </form>
</body>
</html>
