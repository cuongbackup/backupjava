<%@page import="model.*" contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<!-- start the middle column -->
<section>
    <h1>Book Borrow</h1>
    <form action="borrow" method="POST">
    <table border="0">
        <tr><td>Book ID</TD><td><input type="text" name="bookID" value="" size="20" /></TD></tr>
        <tr><td>User ID</TD><td><input type="text" name="userID" value="" size="20" /></TD></tr>
        <tr><td>Description</TD><td><input type=textarea name="description" rows="4" cols="20"/></TD></tr>
    </table><HR>
    <input type="submit" value="Add Log" />
</form>


</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
