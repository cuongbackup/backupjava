<%@page isErrorPage="true" contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Error Page</h1>

    <p><%=exception.getMessage() %></p>
  

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
