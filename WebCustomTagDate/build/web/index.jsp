<%-- 
    Document   : index
    Created on : 11/07/2021, 7:02:52 AM
    Author     : Ly Quynh Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="d" uri="/WEB-INF/tlds/displaydate.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <h1>Tag Custom Demo</h1>
        <hr>
        <h2>
            <p>The current date is <d:currentDate /> </p>
            <d:ifWeekday >
                <p>Live support available at 1-800-555-2222</p>
            </d:ifWeekday>
        </h2>

    </body>
</html>
