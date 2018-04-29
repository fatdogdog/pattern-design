<%-- 
    Document   : book
    Created on : 2018-4-28, 22:15:30
    Author     : Bubkl
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.QI.model.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body style="padding-top:70px">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            <li class="active"><a href="./book">AllBOOKS</a></li>
            <li><a href="./addbook.jsp">ADDBOOK</a></li>
            <li><a href="./discount">DISCOUNT</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <%Admin p = (Admin) session.getAttribute("loginPerson");%> <%=p.getAccount()%> 
                  <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="./logout">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="container">
      <!-- Example row of columns -->
      <div class="col-md-12" style="margin-bottom:10px;">
  <table class="table table-striped">
        <caption>All Books</caption>
        <tr>
            <th></th>
            <th><center>Book Number</center></th>
            <th><center>Book Name</center> </th>
            <th><center>Author</center></th>
            <th><center>Price</center></th>
            <th><center>Category</center></th>
            <th><center>Amount</center></th>
            <th><center>Operating</center></th>
        </tr>
        <%
            List<Book> booklist = (List<Book>) session.getAttribute("allbook");
            for (Book bk : booklist) {
        %>
        <tr>
            <td align="center"><img src="./upload/<%=bk.getPath()%>" height="50" width="50"/></td>
            <td align="center"><%=bk.getNumber()%></td>
            <td align="center"><%=bk.getTitle()%></td>
            <td align="center"><%=bk.getWriter()%></td>
            <td align="center"><%=bk.getPrice()%></td>
            <td align="center"><%=bk.getCategory()%></td>
            <td align="center"><%=bk.getAmount()%></td>
            <td align="center">
                <button class="btn btn-xs" onClick="window.location.href = 'updatebookServlet?number=<%=bk.getNumber()%>'">Edit</button>
                <button class="btn btn-danger btn-xs" onClick="window.location.href = 'deletebookServlet?number=<%=bk.getNumber()%>'">Delete</button>
            </td>
        </tr>
        <%
            }
        %>

    </table>
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
