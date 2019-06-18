<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>sunshine</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    <link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/css/index.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
    <title>主页</title>
</head>
<body>

<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="container-fluid" style="margin-top:80px;">
	  <div class="row">
	     <div class="col-md-1"></div>
	 	 <div class="col-md-10 panel panel-default">
			  <div class="panel-body">
			  		<div class="row title_box" >
				 	 	<div class="col-md-8 title_box_font">模块</div>
		   			</div>
			    	<div class="row" >
			    		<c:forEach items="${themes}" var="Theme">
			    			<div class="col-md-3 title_div" id="theme_choose">
			    			<a href="javascript:void(0);" id="theme_id_${Theme.id}" onclick="selectThemeClick(${Theme.id})" >${Theme.themeName}</a>
			    			<p>主题: ${Theme.themeNumber}, 帖数: ${Theme.postNumber}</p>
			    			<p>最后发表: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${Theme.lastUpdateDate}" /></p>
			    		</div>
			    		
			    		</c:forEach>
			    		
			    	</div>
			  </div>
	 	 </div>
	 	 <div class="col-md-1"></div>
	  </div>
	</div>
  <div class="container-fluid" style="margin-top:30px;">
	  <div class="row">
	     <div class="col-md-1"></div>
	 	 <div class="col-md-10 panel panel-default">
			  <div class="panel-body">
			    <div class="row" >
			 	 	<ul class="nav nav-pills" role="tablist" id="type_choose">
						<c:forEach items="${postTypes}" var="postType">
							<c:choose>
							    <c:when test="${postType.typeId ==1}">
							        <li role="presentation"  class="active" id="type_id_${postType.typeId}"><a href="javascript:void(0);"  onclick="selectTypeClick('${postType.typeId}')" >${postType.itemValue}</a></li>
							    </c:when>
							    <c:otherwise>
							         <li role="presentation" id="type_id_${postType.typeId}"><a href="javascript:void(0);" onclick="selectTypeClick('${postType.typeId}')"> ${postType.itemValue}</a></li>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
		   		</div>
		   		<div>
		   		<div class="row title_box" >
			 	 	<div class="col-md-8 title_box_font">帖子标题</div>
			 	 	<div class="col-md-1 title_box_font">作者</div>
			 	 	<div class="col-md-1 title_box_font">人气</div>
			 	 	<div class="col-md-2 title_box_font">发布时间</div>
		   		</div>
		    	<div id="title_content">
		   	
		   		</div>
		   		
		   		
		   		<div class="row">
			   		<nav aria-label="...">
					  <ul class="pager">
					    <li class="previous " id="previous_page"><a href="javascript:void(0);"><span aria-hidden="true">&larr;</span>上一页</a></li>
					    <li class="next" id="next_page"><a href="javascript:void(0);">下一页<span aria-hidden="true">&rarr;</span></a></li>
					  </ul>
					</nav>
		   		</div>
			  </div>
	 	 </div>
	 	 <div class="col-md-1"></div>
	  </div>
	</div>
    <input type="hidden" value="" id="type_id_value">
    <input type="hidden" value="" id="theme_id_value">
    <input type="hidden" value="" id="page_num">
    <input type="hidden" value="" id="prePage_num">
    <input type="hidden" value="" id="nextpage_num">
    <input type="hidden" value="" id="row_num">



  <div id="footer" class="footer">
  	 <p>版权所有：proven设计与制作</p>
  </div>

</body>

<script src="${pageContext.request.contextPath }/static/js/index.js"></script>
<script>
 var path="${pageContext.request.contextPath }";
</script>

</html>