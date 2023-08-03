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
        <form action="ContactControllerServlet" method="GET">
            <input type="hidden" name="command" value="ADD" />
            <table border="0">
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td> <input type="text" name="firstName" value="" /></td>
                    </tr>

                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>	
                            <label>Group: </label> 
                            <select name="groupName">
                                <c:forEach items="${requestScope.listGroup}" var="group">
                                    <option value="${group.groupName}">${group.groupName} - ${group.description }</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Phone Number: </label> </td>
                        <td><input type="text" name="phoneNumber" value="" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <input type="submit" value="Add" class="save" />
        <input type="submit" value="Return to contact list" onclick="window.location.href = 'ContactControllerServlet';
                return false;"/>        
    </body>
</html>
