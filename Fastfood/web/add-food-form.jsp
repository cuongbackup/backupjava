
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/add-food-style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page = "header.jsp"></jsp:include>
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>QuikSet</h2>
                    <p>Food Manager</p>
                </div>
            </div>
            <form action="FoodControllerServlet" method="GET">
                <input type="hidden" name="command" value="ADD" />

                <table border="0">
                    <tbody>
                        <tr>
                            <td><label>Name: </label></td>
                            <td> <input type="text" name="name" value="" /></td>
                        </tr>

                        <tr>
                            <td><label>Type: </label></td>
                            <td><input type="text" name="type" value="" /></td>
                        </tr>
                        <tr>
                            <td><label>Price: </label> </td>
                            <td><input type="text" name="price" value="" /></td>
                        </tr>
                        <tr>
                            <td><label>Amount: </label> </td>
                            <td><input type="text" name="amount" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save" class="save" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <p>
                <a href="FoodControllerServlet"> Back to the List</a>
            </p>
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
