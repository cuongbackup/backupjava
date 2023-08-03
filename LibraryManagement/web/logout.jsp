<%@page  import="model.*"  contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Library Management System</h1>

    <p>Bye bye..${USER.fullName}</p>
    <% session.invalidate();%>
    <c:redirect url="index.jsp"/>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
