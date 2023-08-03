<%-- 
    Document   : update-student-form
    Created on : Mar 8, 2023, 8:20:20 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>FooBar University</h2>
            </div>
        </div>
        <div id="container">
            <h1>update-student-form</h1>
            <hr>
            <form action="StudentControllerServlet" method="GET">
                <input type="hidden" name="command" value="UPDATE">
                <input type="hidden" name="studentId" value="${THE_STUDENT.id}">
                <table border="0">

                    <tbody>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="firstName" value="${THE_STUDENT.firstName}"></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="lastName" value="${THE_STUDENT.lastName}"></td>

                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" name="email" value="${THE_STUDENT.email}"></td>
                        </tr>

                        <tr>
                    <input type="submit" value="UPDATE" class="save" />
                    </tr>
                    </tbody>
                </table>


            </form>

        </div>
    </body>
</html>
