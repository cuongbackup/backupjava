<%@page import="javax.swing.event.MenuDragMouseEvent"%>
<%@page import="com.dao.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>     
        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <h2>Menu and Price list</h2>
                        <%
                            RestaurentDAO restaurentDAO = new RestaurentDAO();
                            int foodID1 = RestaurentDAO.get().get().getId();
                            
                            %>
                        <jsp:useBean id="menus" class="com.dao.RestaurentDAO" scope="application"></jsp:useBean>
                        <jsp:setProperty property="id" name="user" value="NewPerson"></jsp:setProperty>
                        <c:if test="${not empty noContent}">
                            <h3>${noContent}</h3>
                        </c:if>
                        <c:if test="${empty noContent}">


                            <div class="menu-container">
                                <div class="order">
                                    <span>Menu <jsp:getProperty property="id" name="menus"></jsp:getProperty></span>
                                        <span class="float-right">Price</span>
                                    </div>
                                    <div class="title">
                                        <span><jsp:getProperty property="name" name="menus"></jsp:getProperty></span>
                                    <span class="float-right"><jsp:getProperty property="price" name="menus"></jsp:getProperty></span>
                                    </div>
                                    <div class="descriptment">
                                        <span>Content <jsp:getProperty property="content" name="menus"></jsp:getProperty></span>
                                    </div>
                                </div>

                        </c:if>
                        <div class="paging">
                            <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                                <c:if test="${page != j}">
                                    <a href="MenuController?page=${j}" >${j}</a> |
                                </c:if>
                                <c:if test="${page == j}">
                                    ${j} |
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <%@include file="includes/container.jsp" %>
                </div>
                <%@include file="includes/footer.jsp" %>
            </div>
        </div>
    </body>
</html>