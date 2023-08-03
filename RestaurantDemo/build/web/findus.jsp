<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>Find us</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link href="css/findus.css" rel="stylesheet" type="text/css"/>
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <h2>Find us</h2>
                        <div class="info">
                            <div class="contact">
                                <h3>Address and Contact</h3>
                                <p>${address}</p>
                            </div>
                            <div class="tel-mail">
                                <p>
                                    <span>Tel: </span>
                                    ${tel}
                                </p>
                                <p>
                                    <span>Email: </span>
                                    ${mail}
                                </p>
                            </div>
                        </div>
                        <div class="opening">
                            <h3>Opening Hours</h3>
                            <c:forEach var="i" items="${openHours}">
                                <p>${i}</p>
                            </c:forEach>

                        </div>
                        <div class="map">
                   
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3726.6203653527464!2d108.26116610612797!3d15.970848238264606!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142116949840599%3A0x365b35580f52e8d5!2zxJDhuqFpIGjhu41jIEZQVCAoRlBUIHVuaXZlcnNpdHkp!5e0!3m2!1sen!2s!4v1676407258072!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>



                    </div>
                    <%@include file="includes/container.jsp" %>
                </div>
                <%@include file="includes/footer.jsp" %>
            </div>
        </div>
    </body>
</html>