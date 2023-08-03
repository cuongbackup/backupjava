<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>Scope Demonstration</title>
    </head>
    <%
        pageContext.setAttribute("a", "page");
        request.setAttribute("a", "request");
        session.setAttribute("a", "session");
        application.setAttribute("a", "application");
        request.setAttribute("b", "request");
        session.setAttribute("b", "session");
        application.setAttribute("b", "application");
        session.setAttribute("c", "session");//Accessing Collections with the Stream API ❘ 167

        application.setAttribute("c", "application");
        application.setAttribute("d", "application");
    %>
    <body>
        <h3>Showing the information
            <hr>
            a = ${a}<br />
            b = ${b}<br />
            c = ${c}<br />
            d = ${d}<br />
        </h3>
        <a href="../index.html">Back</a>
    </body>
</html>