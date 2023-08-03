<%-- 
    Document   : subpage01
    Created on : Feb 15, 2023, 8:12:54 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo of include jsp</title>
    </head>
    <body>
        <jsp:include page = "my-header.jsp"></jsp:include>
        <section align="center">
            
            This is the dynamic content of subpage-01
            
        </section>
        <jsp:include page = "my-footer.jsp"></jsp:include>
    </body>
</html>
