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
	<div class="backPwd">
        <div class="div1">
            <input type="text" name="uid" id="uid" placeholder="账户">
        </div>
         <div class="div1">
            <input type="text" name="confirm" id="verifyCode" placeholder="验证码" > <button class="sendCodeBtn" onclick="sendCode()">发送验证码</button>
        </div>
    </div>
    <input type="button" value="点击找回" class="submit1" onclick="changeUserPwd()">
    
</div>


</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>

<script>
   
   
	
	//send code
	function sendCode(){
		
		var uid = $("#uid").val();
		if(uid.length==0){
			$(".error_message").text("账户不能为空！");
		}
		
		//register js method
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/sendVerifyCode.do',
			data:{'uid':uid},
			dataType:'json',
			success:function(result){
				console.log(result);
				if (result.success) {
					$(".error_message").text("已发送验证码到你的邮箱");
				} else {			
					$(".error_message").text(result.msg);
				}
				
			},
			error:function(){
				$(".error_message").text("出现未知错误！");
			}
			
					
		});
		
		
	}
	
	//change user password
	function changeUserPwd(){
		var uid = $("#uid").val();
		if(uid.length==0){
			$(".error_message").text("账户不能为空！");
		}
		
		var verifyCode = $("#verifyCode").val();
		if(verifyCode.length==0){
			$(".error_message").text("验证码不能为空！");
		}
		
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/changeUserPwd.do',
			data:{'uid':uid,'code':verifyCode},
			dataType:'json',
			success:function(result){
				console.log(result);
				if (result.success) {
					$(".error_message").text("已发送新密码到你邮箱，请查看！");
					setTimeout(function(){
						window.location.href="${pageContext.request.contextPath}/renderLogin.do";
					},5000);

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