<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_admin.jsp" %>
<jsp:useBean id="book" class="model.Book" scope="session"/>
<jsp:setProperty name="book" property="*"/> 
<!-- start the middle column -->

<section>
    <h1>Add new book</h1>
<form action="/lib/staff/newbook" method="POST">
    <table border="0">
        <tr><td>Book ID</TD><td>${param.paramID}</TD></tr>
        <tr><td>Book Title</TD><td>${param.title}</TD></tr>
        <tr><td>Author</TD><td>${param.tacgia}</TD></tr>
        <tr><td>Publish year</TD><td>${param.pubYear}</TD></tr>
        <tr><td>Description</TD><td>${param.description}</TD></tr>
        <tr><td>Quantity</TD><td>${param.quantity}</TD></tr>
        <tr><td>Category</TD><td>${param.category}</TD></tr>
    </table><HR>
    <input type="submit" value="Add" /><input type="Button" value="Back" onclick="javascript:history.go(-1);">
</form>
        

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
