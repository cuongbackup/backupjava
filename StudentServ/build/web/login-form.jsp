<%-- 
    Document   : login-form
    Created on : Jan 4, 2023, 9:31:35 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <%
            String err = request.getParameter("err");
            if ("1".equals(err)) {
                out.print("<h4 style=\"color: red;\">Login Fail</h4>");
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
    <tbody>
    <form action="StudentServlet" method="GET">
        First Name: <input type="text" name="firstName" placeholder="First Name">
        <br/><br/>
        Last Name: <input type="text" name="lastName" placeholder="Last Name">
        <br/><br/>
        <input type="submit" value="Submit">
    </form>
</tbody>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
