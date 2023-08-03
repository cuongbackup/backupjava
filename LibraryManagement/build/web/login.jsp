<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Login page</h1>
<form action="login" method="POST">
    <table border="0">
        <tr><td>User ID</TD><td><input type="text" name="uid" value="" size="20" /></TD></tr>
        <tr><td>Password</TD><td><input type="password" name="pass" value="" size="20" /></TD></tr>
    </table><HR>
    <input type="submit" value="Login" />
</form>
        

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
