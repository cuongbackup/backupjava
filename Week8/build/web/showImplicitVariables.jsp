<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>JSP Page</title>
    </head>
    <%
        application.setAttribute("appAttribute", "foo");
        pageContext.setAttribute("pageAttribute", "bar");
        session.setAttribute("sessionAttribute", "sand");
        request.setAttribute("requestAttribute", "castle");
    %>
    <body>
        <h4>Show the implicit variable</h4>
        <hr>
        Remote Address: ${pageContext.request.remoteAddr}<br />
        Request URL: ${pageContext.request.requestURL}<br />

        Session ID: ${pageContext.request.session.id}<br />
        Application Scope: ${applicationScope["appAttribute"]}<br />
        Page Scope: ${pageScope["pageAttribute"]}<br />
        Session Scope: ${sessionScope["sessionAttribute"]}<br />
        Request Scope: ${requestScope["requestAttribute"]}<br />
        User Parameter: ${param["user"]}<br />
        Accept Header: ${header["Accept"]}<br />
        Session ID Cookie Value: ${cookie["JSESSIONID"].value}<br />
    </body>
    <a href="../index.html">Back</a>
</html>