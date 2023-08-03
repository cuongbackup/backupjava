<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.
              css" integrity="sha384-
              zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn
              " crossorigin="anonymous">
    </head>

    <body>
        <%
            session.setAttribute("user", "admin");
            Cookie ck = new Cookie("name", "TranLQ");
            response.addCookie(ck);
        %>
        <div class="container">
            <h3>Home Page</h3>

            <hr>
            <form action="process.jsp">
                Enter Name:<input type="text" name="name" /><br/><br/>
                <input type="submit" value="go"/>
            </form>
            <a href="../index.html">Back</a>
        </div>

    </body>
</html>