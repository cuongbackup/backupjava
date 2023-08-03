<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp">
            Add new item:<input type ="text" name="theItem"/>
            <input type="submit" value="Submit" />

        </form>


        <%
            List<String> items = (List<String>) session.getAttribute("myToDoList");
 
            if (items == null) {
                items = new ArrayList<String>();
                session.setAttribute("myToDoList", items);
            }
            String theItem = request.getParameter("theItem");
            if (theItem != null) {
                items.add(theItem);
            }
        %>
        <hr>0 <b>To List Items</b> </br>
        <ol>
            <% for (String temp : items) {
                    out.println("<b><li>" + temp + "</li></b>");
                }
            %>
        </ol>
    </body>
</html>