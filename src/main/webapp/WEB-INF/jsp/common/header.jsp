<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
      <a class="navbar-brand" href="${pageContext.request.contextPath }/index.do">虚拟桌面爱好者</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath }/index/chat.do" target="_blank">聊天机器人</a></li>

      </ul>
<!--       <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索">
        </div>
        <button type="submit" class="btn btn-default">提问</button>
      </form> -->
      <ul class="nav navbar-nav navbar-right">
         <c:if test="${ !empty user.name }">
              <li><a href="${pageContext.request.contextPath }/user/updateInfo.do?userId=${user.id}" target="_blank">${user.name}</a></li>   
         </c:if>
         <c:if test="${empty user.name }">
             <li><a href="${pageContext.request.contextPath }/renderLogin.do">登录</a></li>
         </c:if>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设置 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <!-- <li><a href="#">我的主页</a></li> -->
            <li><a href="${pageContext.request.contextPath }/blog/render.do" target="_blank">写帖子</a></li>
         	<c:choose>
			    <c:when test="${not empty user}">
			    	<li><a href="${pageContext.request.contextPath }/blog/render.do" target="_blank">写帖子</a></li>
			    </c:when>
			    <c:otherwise>
			    <li><a href="${pageContext.request.contextPath }/renderLogin.do" target="_blank">写帖子</a></li>
			    </c:otherwise>
		  </c:choose>
            <li><a href="${pageContext.request.contextPath }/user/updateInfo.do?userId=${user.id}" target="_blank">个人资料</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="${pageContext.request.contextPath }/logout.do">退出</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>