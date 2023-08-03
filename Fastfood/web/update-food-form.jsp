
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page = "header.jsp"></jsp:include>
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>QuikSet</h2>
                    <p>Food Manager</p>
                </div>
            </div>
                <hr>
                <form action="FoodControllerServlet" method="GET">
                    <input type="hidden" name="command" value="UPDATE">
                    <input type="hidden" name="foodId" value="${THE_FOOD.id}">
                <table border="0">

                    <tbody>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value="${THE_FOOD.name}"></td>
                        </tr>
                        <tr>
                            <td>Type:</td>
                            <td><input type="text" name="type" value="${THE_FOOD.type}"></td>
                        </tr>
                        <tr>
                            <td>Price: </td>
                            <td><input type="text" name="price" value="${THE_FOOD.price}"></td>
                        </tr>
                        <tr>
                            <td>Amount: </td>
                            <td><input type="text" name="amount" value="${THE_FOOD.amount}"></td>
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
