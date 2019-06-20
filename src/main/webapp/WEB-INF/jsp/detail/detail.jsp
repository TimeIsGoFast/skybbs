<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
 <link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/font-awesome-4.7.0/css/font-awesome.min.css">
 <link href="${pageContext.request.contextPath }/static/css/detail.css" rel="stylesheet">
<%--  <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/examples/css/style.css" /> --%>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/css/editormd.preview.css" />
 <script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
 <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
 <title>详情</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="container-fluid" style="margin-top:80px;">
	  <div class="row">
	     <div class="col-md-1"></div>
	 	 <div class="col-md-10 panel panel-default">
			  <div class="panel-body">
				 <div class="row">
				    <div class="col-md-10">
				    	<button type="button" class="btn btn-success">发帖&nbsp;&nbsp;<i class="fa fa-caret-down" aria-hidden="true"></i></button>
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
				 		<p>查看： <span>${postDetail.watchNumber}</span> | 回复: <span>${postDetail.repeatNum}</span></p>
				 		<div class="username">
				 			<p style="text-align:center;">${postTitle.author}</p>
				 		</div>
				 		<div class="img">
				 		  <img src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="帅的被人砍">
				 		</div>
				 		
				 	</div>
				 	
				 	<div class="col-md-10">
				 	    <div class="content_div">
					 		<div class="content_title">
					 			<h3>&nbsp;&nbsp;&nbsp;${postTitle.title}</h3>
					 			<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发表于: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${postTitle.postTime}" /></h5>
					 		</div>
					 		<div>
					 			<div id="layout">
							            <div id="test-editormd-view2">
							                <textarea id="append-test" style="display:none;">
${postDetail.content}						
		
		</textarea>         
							            </div>
							        </div>
					 		</div>


				 		</div>
				 	</div>
				 </div>
				 <div class="row title_box" >
				 	 	<div class="col-md-8 title_box_font">评论</div>
		   		 </div>
		   		 <div class="comment_class">
			   		 <div class="row">
			   		   <br/>
			   		     <textarea class="form-control" rows="3" placeholder="添加评论"></textarea>
			   		     <br/>
			   		     <button class="btn btn-danger" style="float:right;" type="submit">   评论    </button>
			   		 </div>
			   		 <hr>
					 <div class="row comments">
					 		<ul class="media-list">
							  <li class="media">
							    <div class="media-left">
							      <a href="#">
							        <img class="media-object" src="${pageContext.request.contextPath }/static/images/logo2.jpg" alt="...">
							      </a>
							    </div>
							    <div class="media-body">
							      <h4 class="media-heading">小曾的明天</h4>
							      <h5>发表时间：2018-06-13 08:11:00</h5>
							    		很好的文章。
							    	
	                               <div class="row coment_body_P">
	                                 <div class="col-md-11">
	                                 	<a href="${pageContext.request.contextPath }/index/downloadFile.do">下载</a>
		                                <a href="#"><i class="fa fa-reply" aria-hidden="true"></i>回复</a> &nbsp;&nbsp;&nbsp;
		                               	<a href="#"><i class="fa fa-thumbs-up" aria-hidden="true"></i> 支持</a> &nbsp;&nbsp;&nbsp;
		                               	<a href="#"><i class="fa fa-thumbs-down" aria-hidden="true">反对</i></a> 
	                                 </div>
	                               	 <div class="col-md-1">
	                               	 #37
	                               	 </div>	
	                               	</div>
							    </div>
							  </li>
							</ul>
					 </div>
				 </div>
			  </div>
	 	 </div>
	 	 
	 	 <div class="col-md-1"></div>
	 	 
	  </div>
	</div>
 		<script src="${pageContext.request.contextPath }/static/markdown/examples/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/marked.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/prettify.min.js"></script>
        
        <script src="${pageContext.request.contextPath }/static/markdown/lib/raphael.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/underscore.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/sequence-diagram.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/flowchart.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/lib/jquery.flowchart.min.js"></script>

        <script src="${pageContext.request.contextPath }/static/markdown/editormd.js"></script>
        <script type="text/javascript">
            $(function() {
                var testEditormdView, testEditormdView2;
                
               
                    
                testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
                    htmlDecode      : "style,script,iframe",  // you can filter tags decode
                    emoji           : true,
                    taskList        : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,  // 默认不解析
                });
            });
        </script>
 <div id="footer" class="footer">
  	 <p>版权所有：XXX公司</p>
 </div>
 
 
</body>
</html>