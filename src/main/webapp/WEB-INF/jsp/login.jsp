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
	<a href="${pageContext.request.contextPath}/index.do" ><i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;返回主页</a>
</div>
<div class="message">
    <img src="${pageContext.request.contextPath}/static/images/logo1.png">
    <p class="p2">SKYBBS</p>
    <p class="p1">让知识成为你最宝贵的财富</p>
</div>
<div class="navs-slider">
    <a href="#" onclick="_login()" id="nav_login">登录</a>
    <a href="#" onclick="register()" id="nav_register">注册</a>
</div>
<p class="error_message">${activeSuccess}</p>
<div class="_login"  id="choseLogin">
    <form id="fm" method="post">
        <div class="div1">
            <input type="text" name="username" id="username" placeholder="账户">
        </div>
        <div class="div2">
            <input type="password"  name="password" id="password" placeholder="密码">
        </div>

    </form>
    <input type="button" value="登录" class="submit1" onclick="login()">
</div>
<div class="_register" style="display: none" id="choseRegister">
    <form id="register_form" method="post">
        <div class="div1">
            <input type="text" name="uid" id="_uid" placeholder="账户" >
        </div>
        <div class="div1">
            <input type="text" name="nickName"  id="_name" placeholder="昵称或姓名" >
        </div>
        <div class="div1">
            <input type="text" name="email"  id="_email" placeholder="邮箱" >
        </div>
         <div class="div1">
            <input type="text" name="tel"  id="_tel" placeholder="手机号" >
        </div>
        <div class="div2">
            <input type="password" name="password" id="_password" placeholder="密码(密码不小于6位)" >
        </div>


    </form>
    <input type="button" value="注册skybbs" class="submit1" onclick="register_button()">
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
    //注册选择
    function register(){
    	$("#_password").val("");
    	$("#_uid").val("");
    	$(".error_message").text("");
        $("#choseLogin").hide();
        $("#choseRegister").show();
        $("#nav_login").css("color","#666");
        $("#nav_register").css("color","#eb283e");

    }
    
    var loginUrl = 'login.do';
	var successUrl = 'index.do';
	
	function login() {
   /*  var username=$("#username");
    var password=$("#password");
	   $.ajax({
		   type:'post',
		   data:{'username':username,'password':password},
		   url:loginUrl,
		   dataType:'json',
		   success:function(result){
			   var result = eval('(' + result + ')');
			   if(result.success){
				   window.location = successUrl;
			   }else{
				   
				   alert("登陆失败");
			   }
		   },
		   error:function(){
			   alert("请求失败");
		   }
	   }) */
		$('#fm').form('submit', {
			url : loginUrl,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					window.location = successUrl;
				} else {			
					$(".error_message").text(result.msg);
				}
			}
		});
	}   
	//注册
	function register_button(){
		var uid = $("#_uid").val();
		var name = $("#_name").val();
		var pwd = $("#_password").val();
		var tel = $("#_tel").val();
		var email = $("#_email").val();
		var reg = /^[0-9A-Za-z]{6,}$/;
		var accountReg = /^[0-9A-Za-z]{5,}$/;
		var mailReg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
		var telReg=/^[1][3,4,5,7,8][0-9]{9}$/;
		if(!accountReg.test(uid)){
			$(".error_message").text("账号不能小于5位，不能有特殊字符！");
			return;
		}
		if(!mailReg.test(email)){
			$(".error_message").text("邮箱类型不正确！");
			return;
		}
		if(!reg.test(pwd)){
			$(".error_message").text("密码长度不小于六位！");
			return;
		}
		if(!telReg.test(tel)){
			$(".error_message").text("手机号码格式不正确！");
			return;
		}
		
		
		
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/register.do',
			data:$("#register_form").serialize(),
			dataType:'json',
			success:function(result){
				console.log(result);
				if (result.success) {
					$("#username").val(uid);
					$("#password").val(pwd);
					_login();
					$(".error_message").text("注册成功！请查看邮箱来激活账号！");
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