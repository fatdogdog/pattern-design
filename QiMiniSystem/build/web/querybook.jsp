<%-- 
    Document   : querybook
    Created on : 2018-3-3, 6:09:14
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

        <title>My JSP 'querybook.jsp' starting page</title>

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
        <form action="querybookServlet" method="post">
            <table align="center">
                <caption>Input the Book Information：</caption>
                <tr>
                    <td>Book Number</td>
                    <td><input type="text" name="number"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>！The book number can not be empty！</td>
                </tr>
                <tr>	
                    <td>Book Name</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input type="text" name="writer"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>！The price can not be lower than zero！</td>
                </tr>
                <tr>
                    <td></td>
                    <td>!Please enter the information correctly!</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"/>
                        <input type="button" value="Cancle" onClick="window.location.href = 'hellobook.jsp'"></td>
                </tr>

            </table>
        </form>
    </body>
</html>
