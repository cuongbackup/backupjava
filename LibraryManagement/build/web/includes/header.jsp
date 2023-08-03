<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="m" uri="/WEB-INF/tlds/mytag_library" %>
<jsp:useBean class="model.Counter" id="count" scope="application"/>
<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Trường ĐẠI HỌC FPT </title>
    <link rel="shortcut icon" href="/lib/images/favicon.ico">
    <link rel="stylesheet" href="/lib/styles/main.css">
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>

    <header>
        <img src="/lib/images/logo.jpg" 
             alt="Trường Đại học FPT" width="243" height="85" >
        <h1>FPT University</h1>
        <h2>Trường Đại học FPT - Cơ sở Đà Nẵng</h2>
    </header>
    
    <nav id="nav_bar">
        <ul>
            
            <li><a href="/lib/search.jsp">
                    Searching</a></li>
            <li><a href="/lib/staff/staff.jsp">
                    Staff</a></li>
            <li><a href="">
                    News</a> - <m:LoginTagHandler>-${count.count}</m:LoginTagHandler></li>
        </ul>
    </nav>