<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>重置密码</title>
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    <link href="${pageContext.request.contextPath}/static/css/cssReset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/font-awesome-4.7.0/css/font-awesome.min.css">

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
<div class="_register" id="choseRegister">
    <form id="register_form" method="post">
        <div class="div1">
            <input type="text" name="uid" id="uid" placeholder="账户" >
        </div>
        <div class="div1">
            <input type="password" name="password"  id="oldPwd" placeholder="原密码" >
        </div>
         <div class="div1">
            <input type="password" name="password"  id="newPwd" placeholder="新密码" >
        </div>
        <div class="div2">
            <input type="password" name="confirm" id="confirmPwd" placeholder="确认密码" >
        </div>

    </form>
    <input type="button" value="更改密码" class="submit1" onclick="resetPwdbtn()">
</div>

</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
<script>
 	//reset password
	function resetPwdbtn(){
		var oldPwd = $("#oldPwd").val();
		var newPwd = $("#newPwd").val();
		var confirmPwd = $("#confirmPwd").val();
		var uid=$("#uid").val();
		
		if(newPwd!=confirmPwd){
			$(".error_message").text("两次密码应该相同!");
			return;
		}
		
		//register js method
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/resetPwd.do',
			data:$("#register_form").serialize(),
			dataType:'json',
			success:function(result){
				console.log(result);
				if (result.success) {
					window.location.href="${pageContext.request.contextPath}/renderLogin.do";
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