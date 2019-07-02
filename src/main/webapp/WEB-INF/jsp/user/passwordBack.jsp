<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    <link href="${pageContext.request.contextPath}/static/css/cssReset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/font-awesome-4.7.0/css/font-awesome.min.css">
    
<script type="text/javascript">
</script>
</head>
<body>
<div class="return_index"> 
	<a href="#" onClick="javascript :history.back(-1);"><i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;返回上一页</a>
</div>
<div class="message">
    <img src="${pageContext.request.contextPath}/static/images/logo1.png">
    <p class="p2">SKYBBS</p>
    <p class="p1">让知识成为你最宝贵的财富</p>
</div>
<p class="error_message"></p>
<div class="_login"  id="choseLogin">
    <form id="fm" method="post">
        <div class="div1">
            <input type="text" name="username" id="username" placeholder="账户">
        </div>
    </form>
    <input type="button" value="点击找回" class="submit1" onclick="login()">
</div>


</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script>
    //登录选择
    function _login(){
    	$(".error_message").text("");
          $("#choseLogin").show();
          $("#choseRegister").hide();
          $("#nav_login").css("color","#eb283e");
          $("#nav_register").css("color","#666");
    }
   
	
	//注册
	function register_button(){
			
		//register js method
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/register.do',
			data:$("#register_form").serialize(),
			dataType:'json',
			success:function(result){
				console.log(result);
				if (result.success) {
					window.location.href="${pageContext.request.contextPath}/index/message.do?type=register";
				} else {			
					$(".error_message").text(result.msg);
				}
				
			},
			error:function(){
				$(".error_message").text("出现未知错误！");
			}
			
					
		});
		
		
	}

	

</script>
</html>