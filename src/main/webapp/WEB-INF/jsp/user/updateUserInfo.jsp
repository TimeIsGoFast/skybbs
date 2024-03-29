<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
     <link href="${pageContext.request.contextPath }/static/css/cssReset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/css/perfectInfo.css" rel="stylesheet">

    <title>完善信息</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/user/updateUser.do"  method="post" enctype="multipart/form-data" onsubmit="return toVaild()">
<div class="content">

    <div class="input">

        <p class="headerP">完善信息&nbsp;&nbsp;<b id="message" style="font-size:1em;"></b></p>
       
    </div>
   <input type="hidden" id="uid" name="id" value="${user.id}"> 
    <div class="input">
        <span>昵&nbsp;&nbsp;&nbsp;&nbsp;称</span>
        <div class="div1">
            <input type="text" name="name" placeholder="" id="nickname" value="${user.name}">
        </div>
    </div>
    <div class="input">
        <span>手机号</span>
        <div class="div1">
            <input type="text" name="tel" placeholder="" id="tel" value="${user.tel}">
        </div>
    </div>
    <div class="input">
        <span>公&nbsp;&nbsp;&nbsp;&nbsp;司</span>
        <div class="div1">
            <input type="text" name="company" placeholder="" id="mail" value="${user.company}">
        </div>
    </div>
    <div class="input">
        <span>生&nbsp;&nbsp;&nbsp;&nbsp;日</span>
        <div class="div1">
            <input type="date" name="birth" placeholder="" id="birth" value="${birth}">
        </div>
    </div>
    <div class="control-group js_uploadBox">
    <div class="input">
        <span style="font-size: 1.3em">头像上传</span>
        <div class="div3">
            <input type="file" class="js_upFile" name="imgfile" placeholder="" id="imgfile">
        </div>
    </div>
    <div class="input">
        <span>预&nbsp;&nbsp;&nbsp;&nbsp;览</span>
        <div class="div3">
	      	 <c:if test="${ !empty user.logoUrl}">
	      	  <div class="js_showBox "><img id="_img" class="js_logoBox" src="${user.logoUrl}" width="100px" ></div>
      
	      	 </c:if>
	      	  <c:if test="${ empty user.logoUrl}">
	      	  <div class="js_showBox "><img id="_img" class="js_logoBox" src="${pageContext.request.contextPath }/static/images/logo3.png" width="100px" ></div>
	      	 </c:if>

        </div>
    </div>
       </div>  

    <input type="submit" value="确认提交" class="submit1">
</div>
</form>

</body>
<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.uploadView.js"></script>
<script>
$(".js_upFile").uploadView({
	uploadBox: '.js_uploadBox',//设置上传框容器
	showBox : '.js_showBox',//设置显示预览图片的容器
	width : 100, //预览图片的宽度，单位px
	height : 100, //预览图片的高度，单位px
	allowType: ["gif", "jpeg", "jpg", "bmp", "png"], //允许上传图片的类型
	maxSize :2, //允许上传图片的最大尺寸，单位M
	success:function(e){
		$("#message").text('上传成功');
	
	}
});

//页面刷新执行
$(document).ready(function(){
	getinfo();
	
});
//利用ajax的到uid和昵称
function getinfo(){
	var uid='${uid}';
	$("#birth").val();
/* 	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/anon/perfectInfo/getInfoByuid.do',
		data:{'uid':uid},
		dataType:'json',
		success:function(data){
			$("#uid").val(data.uid);
			$("#nickname").val(data.nickname);
			$("#mail").val(data.mail);
			$("#tel").val(data.tel);
			$("#name").val(data.name);
			$("#birth").val(data.birth);
			$("#_img").attr("src","${pageContext.request.contextPath }/upload/touxiang/"+data.headimg);
		},
		error:function(){
			$("#message").text('页面初始化失败！');
		}
		
	}); */
	
}

//validate form before submit
function toVaild(){
	var name = $("#nickname").val();
	var tel = $("#tel").val();
	var telReg=/^[1][3,4,5,7,8][0-9]{9}$/;
	if(name.length==0){
		$("#message").text('昵称不能为空！');
		return false;
	}


	if(!telReg.test(tel)){
		$("#message").text("手机号码格式不正确！");
		return false;
	}
}

</script>

</html>