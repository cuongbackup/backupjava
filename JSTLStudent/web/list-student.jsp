<%-- 
    Document   : student-list
    Created on : Mar 6, 2023, 9:24:27 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1 align = "center">list-student page</h1>
            </div>
        </div>
        <div id="container">
            <hr>
            <input type="submit" value="Add Student" onclick="window.location.href = 'add-student-form.jsp';
                           return false;"
                   class="add-student-button"
                   />
            <div id="content">
                <table border="1">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="tempStudent" items="${studentlist}">
                        <c:url var="tempLink" value="StudentControllerServlet">
                            <c:param name="command" value="LOAD"></c:param>
                            <c:param name="studentId" value="${tempStudent.id}"></c:param>

                        </c:url>
                        <c:url var="deleteLink" value="StudentControllerServlet">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="studentId" value="${tempStudent.id}"></c:param>

                        </c:url>

                        <tr>
                            <td> ${tempStudent.firstName}</td>
                            <td> ${tempStudent.lastName}</td>
                            <td> ${tempStudent.email}</td>
                            <td> <a href="${tempLink}">Update</a>
                                <a href="${deleteLink}" onclick="if (!(confirm('Sure?'))) return false">Delete</a>

                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
