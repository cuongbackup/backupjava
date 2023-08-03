
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
        <jsp:include page = "header.jsp"></jsp:include>
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>QuikSet</h2>
                    <p>Food Manager</p>
                </div>
            </div>

            <div id="container">
                <hr>
                <input type="submit" value="Add Food" onclick="window.location.href = 'add-food-form.jsp';
                        return false;"
                       class="add-food-button"
                       />
                <div id="content">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Type</th>
                                <th>Price</th>
                                <th>Amount</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tempFood" items="${foodlist}">
                            <c:url var="tempLink" value="FoodControllerServlet">
                                <c:param name="command" value="LOAD"></c:param>
                                <c:param name="foodId" value="${tempFood.id}"></c:param>

                            </c:url>
                            <c:url var="deleteLink" value="FoodControllerServlet">
                                <c:param name="command" value="DELETE"></c:param>
                                <c:param name="foodId" value="${tempFood.id}"></c:param>

                            </c:url>

                            <tr>
                                <td> ${tempFood.name}</td>
                                <td> ${tempFood.type}</td>
                                <td> ${tempFood.price}</td>
                                <td> ${tempFood.amount}</td>
                                <td> <a href="${tempLink}">Update</a></td>
                                <td><a href="${deleteLink}" onclick="if (!(confirm('Sure?')))
                                    return false">Delete</a></td>

                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
