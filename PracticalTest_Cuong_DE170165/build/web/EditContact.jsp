
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                    <h1>Edit a Contact</h1>
                <form action="ContactControllerServlet" method="GET">
                    <input type="hidden" name="command" value="UPDATE">
                    <input type="hidden" name="contactId" value="${THE_CONTACT.id}">
                <table border="0">

                    <tbody>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value="${THE_CONTACT.name}"></td>
                        </tr>
                        <tr>
                            <td>Type:</td>
                            <td><input type="text" name="type" value="${THE_CONTACT.type}"></td>

                        </tr>
                        <tr>
                            <td>Price: </td>
                            <td><input type="text" name="price" value="${THE_CONTACT.price}"></td>
                        </tr>
                        <tr>
                            <td>Amount: </td>
                            <td><input type="text" name="amount" value="${THE_CONTACT.amount}"></td>
                        </tr>
                        <tr>
                    <input type="submit" value="UPDATE" class="save" />
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
