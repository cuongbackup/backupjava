<%-- 
    Document   : home-page
    Created on : May 26, 2022, 4:41:40 PM
    Author     : Ly Quynh Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" name="viewport"
              content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Home Page</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark"> <a class="navbar-brand" href="#"><i
                    class="fa fa-home"></i> Home Page</a>

            <div id="navbarNavDropdown" class="navbar-collapse collapse">
                <ul class="navbar-nav mr-auto">
                    
                    <li class="nav-item"><a class="nav-link" id="listEmpsLink" href="#">List of User</a></li>

                </ul>

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" style="color: yellow" href="#"><i
                                class="fa fa-user-circle-o"></i>
                            ${userLogin.userName}</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/logout"><i
                                class="fa fa-user-times"></i> Logout</a></li>
                </ul>
            </div>
        </nav>


        <div class="container">
            <br />
            <h4>Welcome to User Management System, ${userLogin.userName}</h4>
        </div>


        <div class="row fixed-bottom" style="border-top: 1px solid #ccc; background-color: #222">
            <div class="col-md-12">
                <p style="margin: 10px auto; text-align: center; color: #ccc">&copy;
                    Copyright 2022</p>
            </div>
        </div>

        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/home-page.js"></script>
    </body>

</html>