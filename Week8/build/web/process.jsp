<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-
              8">

        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.
              css" integrity="sha384-
              zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn
              " crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h3>Showing the information <br> </h3>
            <hr>
            <h5>Welcome, ${ param.name } <br>
                Value is ${ sessionScope.user } <br>
                Hello, ${cookie.name.value}
            </h5>
            <a href="../index.html">Back</a>
        </div>


    </body>
</html>