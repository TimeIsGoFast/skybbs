<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
 <link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/font-awesome-4.7.0/css/font-awesome.min.css">
 <link href="${pageContext.request.contextPath }/static/css/detail.css" rel="stylesheet">
 <script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
 <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
 <title>详情</title>
</head>
<body>
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
        <li class="active"><a href="#">详情 <span class="sr-only">(current)</span></a></li>
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
				 <div class="row">
				    <div class="col-md-8">
				    	<button type="button" class="btn btn-danger">发帖&nbsp;&nbsp;<i class="fa fa-caret-down" aria-hidden="true"></i></button>
				    </div>
				    <div class="col-md-2">
				    	<button type="button" class="btn btn-default"><i class="fa fa-backward" aria-hidden="true"></i> &nbsp;返回列表</button>
				    </div>
				      <div class="col-md-1">
				    	<button type="button" class="btn btn-default"><i class="fa fa-caret-left" aria-hidden="true"></i>&nbsp;上一篇</button>
				    </div>
				     <div class="col-md-1">
				    	<button type="button" class="btn btn-default">下一篇 &nbsp;<i class="fa fa-caret-right" aria-hidden="true"></i> </button>
				    </div>
				 </div>
				 
				 <div class="row bolg_detail">
				 	<div class="col-md-2 left_top">
				 		<p>查看：<span>100112</span> | 回复:<span>46</span></p>
				 		<div class="username">
				 			<p>帅的被人砍</p>
				 		</div>
				 		<div class="img">
				 		  <img src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="帅的被人砍">
				 		</div>
				 		
				 	</div>
				 	
				 	<div class="col-md-9">
				 		<div class="content_title">
				 			<h3>[线网线路] 【城市交通】杭州地铁线路图 [20190111更新]</h3>
				 			<h4>发表于 2016-1-18 22:23 </h4>
				 		</div>
				 		<div>
				 			<p>
				 			gframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Mapping [/blog/detail.do] to HandlerExecutionChain with handler [com.proven.business.controller.BlogController@2795fe72] and 1 interceptor
  [org.springframework.web.servlet.DispatcherServlet] - Last-Modified value for [/skybbs/blog/detail.do] is: -1
  [org.springframework.web.bind.annotation.support.HandlerMethodInvoker] - Invoking request handler method: public java.lang.String com.proven.business.controller.BlogController.detail()
  [org.springframework.web.servlet.DispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
  [org.springframework.web.servlet.DispatcherServlet] - DispatcherServlet with name 'dispatcherServlet' processing GET request for [/skybbs/blog/detail.do]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Matching patterns for request [/blog/detail.do] are [/blog/detail.*]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - URI Template variables for request [/blog/detail.do] are {}
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Mapping [/blog/detail.do] to HandlerExecutionChain with handler [com.proven.business.controller.BlogController@2795fe72] and 1 interceptor
  [org.springframework.web.servlet.DispatcherServlet] - Last-Modified value for [/skybbs/blog/detail.do] is: -1
  [org.springframework.web.bind.annotation.support.HandlerMethodInvoker] - Invoking request handler method: public java.lang.String com.proven.business.controller.BlogController.detail()
  [org.springframework.web.servlet.DispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
  [org.springframework.web.servlet.DispatcherServlet] - DispatcherServlet with name 'dispatcherServlet' processing GET request for [/skybbs/blog/detail.do]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Matching patterns for request [/blog/detail.do] are [/blog/detail.*]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - URI Template variables for request [/blog/detail.do] are {}
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Mapping [/blog/detail.do] to HandlerExecutionChain with handler [com.proven.business.controller.BlogController@2795fe72] and 1 interceptor
  [org.springframework.web.servlet.DispatcherServlet] - Last-Modified value for [/skybbs/blog/detail.do] is: -1
  [org.springframework.web.bind.annotation.support.HandlerMethodInvoker] - Invoking request handler method: public java.lang.String com.proven.business.controller.BlogController.detail()
  [org.springframework.web.servlet.DispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
  [org.springframework.web.servlet.DispatcherServlet] - DispatcherServlet with name 'dispatcherServlet' processing GET request for [/skybbs/blog/detail.do]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Matching patterns for request [/blog/detail.do] are [/blog/detail.*]
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - URI Template variables for request [/blog/detail.do] are {}
  [org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping] - Mapping [/blog/detail.do] to HandlerExecutionChain with handler [com.proven.business.controller.BlogController@2795fe72] and 1 interceptor
  [org.springframework.web.servlet.DispatcherServlet] - Last-Modified value for [/skybbs/blog/detail.do] is: -1
  [org.springframework.web.bind.annotatio
				 			</p>
				 		</div>
				 	</div>
				 </div>
				 <div class="row title_box" >
				 	 	<div class="col-md-8 title_box_font">评论</div>
		   		 </div>
				 <div class="row comments">
				 		<ul class="media-list">
						  <li class="media">
						    <div class="media-left">
						      <a href="#">
						        <img class="media-object" src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="...">
						      </a>
						    </div>
						    <div class="media-body">
						      <h4 class="media-heading">Media heading</h4>
						     ispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
						    </div>
						  </li>
						</ul>
				 </div>
				 		 <div class="row comments">
				 		<ul class="media-list">
						  <li class="media">
						    <div class="media-left">
						      <a href="#">
						        <img class="media-object" src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="...">
						      </a>
						    </div>
						    <div class="media-body">
						      <h4 class="media-heading">Media heading</h4>
						     ispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
						    </div>
						  </li>
						</ul>
				 </div>
				 		 <div class="row comments">
				 		<ul class="media-list">
						  <li class="media">
						    <div class="media-left">
						      <a href="#">
						        <img class="media-object" src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="...">
						      </a>
						    </div>
						    <div class="media-body">
						      <h4 class="media-heading">Media heading</h4>
						     ispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
						    </div>
						  </li>
						</ul>
				 </div>
				 		 <div class="row comments">
				 		<ul class="media-list">
						  <li class="media">
						    <div class="media-left">
						      <a href="#">
						        <img class="media-object" src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="...">
						      </a>
						    </div>
						    <div class="media-body">
						      <h4 class="media-heading">Media heading</h4>
						     ispatcherServlet] - Rendering view [org.springframework.web.servlet.view.JstlView: name 'detail/detail'; URL [/WEB-INF/jsp/detail/detail.jsp]] in DispatcherServlet with name 'dispatcherServlet'
  [org.springframework.web.servlet.view.JstlView] - Forwarding to resource [/WEB-INF/jsp/detail/detail.jsp] in InternalResourceView 'detail/detail'
  [org.springframework.web.servlet.DispatcherServlet] - Successfully completed request
						    </div>
						  </li>
						</ul>
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
</html>