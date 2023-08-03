
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Group</h1>

        <input type="submit" value="Add Group" onclick="window.location.href = 'AddGroup.jsp';
                return false;"/>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Group Name</th>
                <th>Description</th>
            </tr>
            <tbody>
                <c:forEach var="tempGroup" items="${grouplist}">
                    <c:url var="tempLink" value="GroupControllerServlet">
                        <c:param name="command" value="LOAD"></c:param>
                        <c:param name="groupId" value="${tempGroup.id}"></c:param>

                    </c:url>
                    <c:url var="deleteLink" value="GroupControllerServlet">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="groupId" value="${tempGroup.id}"></c:param>

                    </c:url>

                    <tr>
                        <td> ${tempGroup.id}</td>
                        <td> ${tempGroup.groupName}</td>
                        <td> ${tempGroup.description}</td>
                </c:forEach>
            </tbody>
        </table>
    </body>
    <button onclick="window.location.href='AddGroup.jsp'">Add Group</button>    
    <button onclick="window.location.href='ContactControllerServlet'">List Contact</button>    
</html>
