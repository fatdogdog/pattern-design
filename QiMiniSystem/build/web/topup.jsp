<%-- 
    Document   : topup
    Created on : 2018-4-30, 12:52:51
    Author     : Bubkl
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.QI.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
          <a class="navbar-brand" href="#">BACKEND</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            <li><a href="./book">AllBOOKS</a></li>
            <li><a href="./addbook.jsp">ADDBOOK</a></li>
            <li><a href="./discount">DISCOUNT</a></li>
            <li class="active"><a href="./topup">TOPUP</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <%Admin p = (Admin) session.getAttribute("loginPerson");%> <%=p.getAccount()%> 
                  <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="./login-register.jsp">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <div id="successAlert" class="alert alert-success hide">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <center>Topup success!</center>
</div>
      <!-- Example row of columns -->
      <div class="col-md-3" style="margin-bottom:10px;">
	<div class="form-group">
		<label for="name">Choose account</label>
		<select class="form-control" id="account" name="account">
                    <%
            List<String> acclist = (List<String>) session.getAttribute("accounts");
            
            for (String acc : acclist) {
        %>
        <option><%=acc%></option>
        <%
            }
        %>
		</select>
	</div>
              <div class="form-group">
    <label for="exampleInputEmail1">Amount</label>
    <input type="text" class="form-control" id="amount" name="amount" >
  </div>
                <button class="btn btn-default" onclick="topup()">Submit</button>
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
    <script>
        function topup(){
            
            $.ajax({
                type: "POST",
                url: "./topup",
                data: {"account": $("#account").val(), "amount": $("#amount").val()},
                success: function(msg){
                    if(msg=="success"){
                        $("#successAlert").attr("class","alert alert-success");
                        $("#amount").val("");
                    } else{
                        $("#faildAlert").attr("class","alert alert-danger");
                    }
                }
            })
        }
    </script>
  </body>
</html>
