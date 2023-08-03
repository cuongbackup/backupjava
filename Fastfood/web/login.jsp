

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center><h1>Login Here</h1></center>
    <center>
        <div>
            <form action="LoginServlet" method ="POST">
                <table>
                    <tr>
                        <td>User name</td>
                        <td><input type ="text" class="form-control" name ="username"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type ="password" class="form-control" name ="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center"><input class ="btn btn-success" type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>