<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>消息</title>
	<link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
 	<link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
 	<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
</head>
<style>
body{
  background-color: #e6e6e6;

}
.jumbotron{
	height:900px;
}
.panel-default {
    width:700px;
    margin:200px auto;
    height:500px;
}
</style>
<body>
<div class="jumbotron">
  <div class="panel-default">
   <h1>Hello ${user.name}!</h1>
   <p>${message}</p>
   <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/index.do" role="button">返回主页</a></p>
   </div>
</div>




</body>
</html>