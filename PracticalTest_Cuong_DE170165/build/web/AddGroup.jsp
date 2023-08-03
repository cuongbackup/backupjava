<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a Contact</h1>
        <form action="GroupControllerServlet" method="GET">
            <input type="hidden" name="command" value="ADD" />
            <table border="0">
                <tbody>
                    <tr>
                        <td><label>Group Name: </label></td>
                        <td> <input type="text" name="groupName" value="" /></td>
                    </tr>

                    <tr>
                        <td><label>Description: </label> </td>
                        <td><input type="text" name="description" value="" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <input type="submit" value="Add" class="save" />
        <button onclick="window.location.href = 'GroupControllerServlet'">Return to group list</button>        
    </body>
</html>
