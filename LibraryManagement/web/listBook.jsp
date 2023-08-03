<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>
<!-- start the middle column -->

<section>
    <h1>List of Books</h1>
<Table>
    <TR><TH>Book ID</TH><TH>Title</TH><TH>Author</TH><TH>Description</TH><TH>Publish year</TH><TH>Category</TH></TR>
    <c:forEach items="${books}" var="b"> 
    <TR><TD>${b.bookID}</TD><TD>${b.title}</TD><TD>${b.tacgia}</TD><TD>${b.description}</TD><TD>${b.pubYear}</TD><TD>${b.category}</TD></TR>
    </c:forEach>
</table>    

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
