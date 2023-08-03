<%@page  import="model.*"  contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>
<jsp:useBean id="LIB" class="model.Library" scope="application"/>
<!-- start the middle column -->

<section>
    <m:MyTagHandler color="red">
       Welcome to FPT Library Management System 
    </m:MyTagHandler>
           
    <p>Thanks for visiting. Make yourself at home. We 
    hope you like it as much as we do.</p>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
