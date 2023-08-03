<%-- 
    Document   : login
    Created on : May 25, 2022, 11:22:53 AM
    Author     : Ly Quynh Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/register-user.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="label-login">
                <p>LOGIN</p>
            </div>
            <p id="error">${loginFail}</p>
            <div class="div-login">
                <form action="<%=request.getContextPath()%>/login" method="post" name="frm-login" onsubmit = "return validateLogin()">
                    <table id="tbl-login">

                        <tr>
                            <td>User Name <span>*</span></td>
                            <td><input type="text" name="userName" id="userName"
                                       placeholder="Enter user name" value = ""/></td>
                        </tr>
                        <tr>
                            <td>Password <span>*</span></td>
                            <td><input type="password" name="password" id="password"
                                       placeholder="Enter password" value = ""/></td>
                        </tr>


                        <tr>
                            <td></td>
                            <td>
                                <button type="submit"
                                        name="login">Login</button>
                                <a href = "<%=request.getContextPath()%>/register" id = "link-register">Click here to Register</a>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/resources/js/login.js"></script>
    </body>
</html>
