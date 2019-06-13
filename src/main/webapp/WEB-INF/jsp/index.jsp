<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>sunshine</title>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    <link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/css/index.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
    <title>主页</title>
</head>
<body>
<%--   <div class="header">
      <div class="center">
      <ul>
          <li>
              <a href="${pageContext.request.contextPath }/index.do">首页</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath }/anon/translation.do">小工具</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath }/anon/suibi/render.do">发布</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath }/anon/tuling/render.do">聊天机器人</a>
          </li>
      </ul>
          <div class="login">
              <ul>
                 <c:if test="${ !empty user.name }">
                   <li><a href="${pageContext.request.contextPath }/anon/perfectInfo/render.do" target="_blank">${user.name}</a></li>
                    <li><a href="${pageContext.request.contextPath }/logout.do">退出</a></li>
                 </c:if>
                 <c:if test="${empty user.name }">
                 <li><a href="${pageContext.request.contextPath }/renderLogin.do">登录</a></li>
                 </c:if>
                 
              </ul>
          </div>

      </div>

  </div> --%>

 <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">虚拟桌面爱好者</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath }/blog/chat.do">聊天机器人</a></li>
   <!--      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li> -->
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索">
        </div>
        <button type="submit" class="btn btn-default">提问</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Zeng,Weilong</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设置 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">我的主页</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">写帖子</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">退出</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid" style="margin-top:80px;">
	  <div class="row">
	     <div class="col-md-1"></div>
	 	 <div class="col-md-10 panel panel-default">
			  <div class="panel-body">
			  		<div class="row title_box" >
				 	 	<div class="col-md-8 title_box_font">模块</div>
		   			</div>
			    	<div class="row">
			    		
			    		<div class="col-md-3 title_div">
			    			<a href="#">Citrix虚拟化</a>
			    			<p>主题: 5万, 帖数: 97万</p>
			    			<p>最后发表: 2019-6-11 19:05</p>
			    		</div>
			    		<div class="col-md-3 title_div">
			    			<a href="#">VMware虚拟化</a>
			    			<p>主题: 5万, 帖数: 97万</p>
			    			<p>最后发表: 2019-6-11 19:05</p>
			    		</div>
			    		<div class="col-md-3 title_div">
			    			<a href="#">Window Server</a>
			    			<p>主题: 5万, 帖数: 97万</p>
			    			<p>最后发表: 2019-6-11 19:05</p>
			    		</div>
			    		<div class="col-md-3 title_div">
			    			<a href="#">Linux</a>
			    			<p>主题: 5万, 帖数: 97万</p>
			    			<p>最后发表: 2019-6-11 19:05</p>
			    		</div>
			    		<div class="col-md-3 title_div">
			    			<a href="#">Java 技术</a>
			    			<p>主题: 5万, 帖数: 97万</p>
			    			<p>最后发表: 2019-6-11 19:05</p>
			    		</div>
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
			 	 	<ul class="nav nav-pills" role="tablist">
					  <li role="presentation" class="active"><a href="#">推荐</a></li>
					  <li role="presentation"><a href="#">关注</a></li>
					  <li role="presentation"><a href="#">热门</a></li>
					</ul>
		   		</div>
		   		<div class="row title_box" >
			 	 	<div class="col-md-8 title_box_font">帖子标题</div>
			 	 	<div class="col-md-1 title_box_font">作者</div>
			 	 	<div class="col-md-1 title_box_font">人气</div>
			 	 	<div class="col-md-2 title_box_font">发布时间</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		<div class="row tiezi">
		   			<div class="col-md-8 "><a href="#">如何配置虚拟桌面信息？</a></div>
			 	 	<div class="col-md-1 ">weilong,zeng</div>
			 	 	<div class="col-md-1 ">15324</div>
			 	 	<div class="col-md-2 ">2018-06-07</div>
		   		</div>
		   		
		   		<div class="row">
			   		<nav aria-label="...">
					  <ul class="pager">
					    <li class="previous disabled"><a href="#"><span aria-hidden="true">&larr;</span>上一页</a></li>
					    <li class="next"><a href="#">下一页<span aria-hidden="true">&rarr;</span></a></li>
					  </ul>
					</nav>
		   		</div>
			  </div>
	 	 </div>
	 	 <div class="col-md-1"></div>
	  </div>
	</div>




  <div id="footer" class="footer">
  	 <p>版权所有：XXX公司</p>
  </div>

</body>

<script src="${pageContext.request.contextPath }/static/js/index.js"></script>

</html>