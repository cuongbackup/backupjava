<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Update book</h1>
<form action="doupdatedummy.jsp" method="POST">
    <table border="0">
        <tr><td>Book ID</TD><td><input type="text" name="bookID" value="${b.bookID}" size="20" /></TD></tr>
        <tr><td>Book Title</TD><td><input type="text" name="title" value="${b.title}" size="20" /></TD></tr>
        <tr><td>Author</TD><td><input type="text" name="tacgia" value="${b.tacgia}" size="20" /></TD></tr>
        <tr><td>Publish year</TD><td><input type="text" name="pubYear" value="${b.pubYear}" size="20" /></TD></tr>
        <tr><td>Description</TD><td><input type="text" name="description" value="${b.description}" size="20" /></TD></tr>
        <tr><td>Quantity</TD><td><input type="text" name="quantity" value="${b.quantity}" size="20" /></TD></tr>
        <tr><td>Category</TD><td><input type="text" name="category" value="${b.category}" size="20" /></TD></tr>
    </table><HR>
    <input type="submit" value="Update" />
</form>
        

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
