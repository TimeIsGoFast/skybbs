<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员联系方式</title>
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
   <h2>欢迎来到skybbs!</h2>
   <p>如果你有什么建议或者有任何疑问，你可以通过以下方式来联系管理员，以下是联系方式：</p>
   <c:forEach items="${configs}" var="Config">
   <p>${Config.itemValue}：${Config.desc}</p>
   </c:forEach>
 
   </div>
</div>




</body>
</html>