
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Contacts</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Group</th>
                <th>Phone Number</th>
                <th>Operations</th>
            </tr>
            <tbody>
                <c:forEach var="tempContact" items="${contactlist}">
                    <c:url var="tempLink" value="ContactControllerServlet">
                        <c:param name="command" value="LOAD"></c:param>
                        <c:param name="contactId" value="${tempContact.id}"></c:param>

                    </c:url>
                    <c:url var="deleteLink" value="ContactControllerServlet">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="contactId" value="${tempContact.id}"></c:param>

                    </c:url>

                    <tr>
                        <td> ${tempContact.id}</td>
                        <td> ${tempContact.firstName}</td>
                        <td> ${tempContact.lastName}</td>
                        <td> ${tempContact.groupName}</td>
                        <td> ${tempContact.phoneNumber}</td>
                        <td> <a href="${tempLink}">Edit</a>
                        <a href="${deleteLink}" onclick="if (!(confirm('Sure?')))
                            return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button onclick="window.location.href='AddContact.jsp'">Add Contact</button>
        <button onclick="window.location.href='GroupControllerServlet'">List Group</button>
    </body>
</html>
