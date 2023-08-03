<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_admin.jsp" %>

<!-- start the middle column -->

<section>
  <h2>Uploaded Image</h2>
  <%
    //byte[] image = (byte[]) request.getAttribute("image");
    out.println(request.getAttribute("data")+"</P>");
    //out.println("<img src='data:image/jpeg;base64," + javax.xml.bind.DatatypeConverter.printBase64Binary(image) + "'/>");
    out.println("<img src='"+request.getAttribute("path")+"'/>");
  %>
  

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
