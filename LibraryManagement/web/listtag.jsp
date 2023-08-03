<%@page  import="model.*"  contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>
<!-- start the middle column -->

<section>
    <m:showTable page="0" pagesize="20" title="List of Book" list="${list}" headerRow="${Book.getHeaderRow()}"/>  
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
