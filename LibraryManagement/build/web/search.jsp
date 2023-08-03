<%@page contentType="text/html" errorPage="error.jsp"  import="model.*" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Book Searching</h1>
    <form action="bsearch" method="POST">
        <label>Search Criteria</label><select name="sCriteria">
            <option value="bid">Book ID</option>
            <option value="tittle">Tittle</option>
            <option value="author">Author</option>
            <option value="yearpub">Publish Year</option>
            <option value="cat">Category</option>
        </select><br>
        <label>Search Value</label><input type="text" name="sValue"/><br>
        <input type="submit" value="Search" />
    </form>
</section>

<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
