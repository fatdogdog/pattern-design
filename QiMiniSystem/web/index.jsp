<%-- 
    Document   : index
    Created on : 2018-4-25, 18:11:17
    Author     : Bubkl
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.QI.model.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Knowledge Bakery</title>

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

  <body style="padding-top:70px" >
      
      <!-- Modal -->
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm</h4>
      </div>
      <div class="modal-body" id='content'> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Wait</button>
        <button type="button" class="btn btn-primary" onclick="buy()">Buy it</button>
      </div>
    </div>
  </div>
</div>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="./index">BOOK STORE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            <li><a href="./mybook">MY BOOKS</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <%Person p = (Person) session.getAttribute("loginPerson");%> <%=p.getAccount()%> 
                  <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="./profile">profile</a></li>
                <li><a href="./message.jsp">message</a></li>
                <li><a href="./login-register.jsp">logout</a></li>
              </ul>
            </li>
          </ul>
            <form class="navbar-form navbar-right" action="index" method="post">
            <div class="form-group">
              <input type="text" name="title" placeholder="enter something..." class="form-control">
            </div>
            <button type="submit" class="btn btn-success">search</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="container">
              <div id="successAlert" class="alert alert-success hide">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <center>Purchase success!</center>
</div>
      
      <div id="faildAlert" class="alert alert-danger hide">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <center>Your balance is not enough</center>
</div>
        
        <div id="initAlert" class="alert alert-success hide">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <center>Welcome to our system and you have got 5 pounds!</center>
</div>
      <!-- Example row of columns -->
      <div class="row" style="margin-bottom:10px;margin-left:6px;">
          order by:
          <a href="/QiMiniSystem/index?order=price" class="btn btn-default btn-xs" role="button">price</a>
          <a href="/QiMiniSystem/index?order=sales" class="btn btn-default btn-xs" role="button">sales</a>
      </div>
      <div class="row">
        <%
            List<Book> booklist = (List<Book>) session.getAttribute("booklist");
            for (Book bk : booklist) {
        %>
        <div class="col-md-2">
		  <div style="margin-bottom:20px;">
			<center>
				<img src="./upload/<%=bk.getPath()%>" height="150" width="150"/>
			</center>
		  </div>
          <p><%=bk.getTitle()%></p>
		  <p>￡: <%=bk.getPrice()%> </p>
		  <p>sales: <%=bk.getSales()%> </p>
          <p>
			<center>
				<a class="btn btn-default" onclick="confirm('<%=bk.getNumber()%>', '<%=bk.getPrice()%>')" role="button">Buy now</a>
				<a class="btn btn-default" href="#" role="button">wish list</a>
			</center>
		  </p>
        </div>
        <%
            }
        %>
        
		
	   </div>
	  

      <hr>

      <footer>
        <p>&copy; 2016 Company, Inc.</p>
      </footer>
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
        window.onload=function(){ 
            $('#successAlert').bind('closed.bs.alert', function () {
                 window.location.href = "./index"
            })
            show();
        }
                
    </script>
    <script>
        var number = '';
        var price = 0;
        var unread = "<%=session.getAttribute("unread")%>";
        
        function show(){
            if(unread=="true"){
                $("#initAlert").attr("class","alert alert-success");
            }
        }
        
        function confirm(num, price){
            number = num;
            price = price;
            content = "It will cost you ￡" + price;
            $("#content").html(content);
            $("#confirmModal").modal();
        }
        
        function buy(){
            
            $("#confirmModal").modal('hide');
            $.ajax({
                type: "POST",
                url: "./buy",
                data: {"number": number, "account": "<%=p.getAccount()%>"},
                success: function(msg){
                    if(msg=="success"){
                        $("#successAlert").attr("class","alert alert-success");
                    } else{
                        $("#faildAlert").attr("class","alert alert-danger");
                    }
                }
            })
        }
    </script>
  </body>
</html>

