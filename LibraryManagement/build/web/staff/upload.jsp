<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_admin.jsp" %>

<!-- start the middle column -->

<section>
  <h2>Upload Image</h2>
  <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="data" size="20"><br><br>  
    <input type="file" name="file"><br><br>
    <input type="submit" value="Upload">
  </form>

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
