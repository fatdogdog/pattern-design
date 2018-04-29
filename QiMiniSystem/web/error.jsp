<%-- 
    Document   : error
    Created on : 2018-3-2, 20:16:57
    Author     : DELL
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>My JSP 'error.jsp' starting page</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

    </head>

    <body>
        <table align="center">
            <h2>Wrong user name or password！ </h2><br/>
        </table>
        <table align="center">
            <tr><input type="button" value="Try Again" onClick="window.location.href = 'login.jsp'"></a></tr>
            <tr>&nbsp;</tr>
            <tr><input type="button" value="New Register" onClick="window.location.href = 'register.jsp'"></a></tr>
        </table>
    </body>
</html>