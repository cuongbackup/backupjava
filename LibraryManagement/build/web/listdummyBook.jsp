<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left.jsp" %>
<!-- start the middle column -->
<section>
    <c:set var="page" value="${param.page}"/>
    <c:set var="pagesize" value="${param.pagesize}"/>
    <c:if test="${page==null || empty page}">
        <c:set var="page" value="${page}"/>
        <c:set var="pagesize" value="${pagesize}"/>
    </c:if>
    <c:if test="${page==null || empty page}">
        <c:set var="page" value="0"/>
        <c:set var="pagesize" value="50"/>
    </c:if>
    <h1>${title}  Page ${page+1}</h1>
<Table>
    ${headerRow}
    <c:forEach var="i" begin="${page*pagesize}" end="${(page+1)*pagesize-1}"> 
    ${list[i].dataRow}    
    </c:forEach>
</table>    
<A href="?page=0&pagesize=${pagesize}">First</A>
    <c:set var="totalpage" value="${list.size()/pagesize}"/>
    <c:forEach var="i" begin="1" end="${5<totalpage?5:totalpage}">
     <A href="?page=${(page+i+totalpage)%totalpage}&pagesize=${pagesize}">${(page+i+totalpage)%totalpage+1}</A>
    </c:forEach>
<A href="?page=${totalpage-1}&pagesize=${pagesize}">Last</A>
</section>
<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
