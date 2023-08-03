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
    <tbody>
    <form action="LoginController" method ="POST">
        Username: <input type="text" name="username" value="" size="10">
        <br>
        Password: <input type="text" name="password" value="" size="10">   
        <br>
        </tbody>
        <input type="submit" value="Login">
    </form>
</body>
</html>
