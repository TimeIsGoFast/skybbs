<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>写帖子</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/examples/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/css/editormd.css" />
        <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
        <script src="${pageContext.request.contextPath }/static/assets/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath }/static/assets/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layer/default/layer.css" />
        
    </head>
    <body>
     <form action="${pageContext.request.contextPath }/blog/savePostDetail.do" method="post"  enctype="multipart/form-data" onsubmit="return toVaild()">
        <div id="layout" style="width:90%;margin:10px auto;">
         
            <header>
               
				<div class="row" style="margin-top:10px;">
				<h2>&nbsp;&nbsp;添加文章</h2>
				<div class="col-md-9" style="margin-bottom:10px;">
				<input type="text" class="form-control" name="title" placeholder="请输入标题，不超过100字" aria-describedby="basic-addon1" id="title">
				</div>
				<br/>
			    <div class="form-group col-md-4">
				    <input type="file" id="attachFile" onchange="chekFileSize()" name="attachFile">
				    <p class="help-block">选择你要提交的附件,不大于20M!</p>
				 </div>
				 <div class="row col-md-3">
				     <div class="col-md-3">
				       <p style="line-height:30px;font-size:15px;text-align:center;">模块</p>
				     </div>
				     <div class="col-md-9">
						 <select class="form-control" name="themeId">
						  <c:forEach items="${themes}" var="Theme">
						  	<option value="${Theme.id}">${Theme.themeName }</option>
						  </c:forEach>
						  
						</select>
					</div>
				 </div>
				  <div class="col-md-2">
				  	<input type="submit" id="" class="btn btn-danger" value="  提交文章    "/>
				  </div>
				 </div> 
            </header>
            <div id="test-editormd">
                <textarea style="display:none;" name="content">
				</textarea>
            </div>
           
        </div>
        </form> 
         <script src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/editormd.js"></script>
        <script src="${pageContext.request.contextPath }/static/layer/layer.js"></script>
        <script type="text/javascript">
			var testEditor;
			var path = '${pageContext.request.contextPath}';

            $(function() {                
                var testEditor = editormd("test-editormd", {
                    width: "90%",
                    height: 640,
                    markdown : "",
                    path :path+"/static/markdown/lib/",
                    //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为 true
                    //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为 true
                    //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为 true
                    //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为 0.1
                    //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为 #fff
                    imageUpload : true,
                    imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                    imageUploadURL : path+"/blog/imgUpload.do",
                    
                    /*
                     上传的后台只需要返回一个 JSON 数据，结构如下：
                     {
                        success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
                        message : "提示的信息，上传成功或上传失败及错误信息等。",
                        url     : "图片地址"        // 上传成功时才返回
                     }
                     */
                });
            });
            //file size validate,add by weilong 2019-06-25
            function chekFileSize(){
            	var fileSize =  document.getElementById('attachFile').files[0];
            	if(fileSize.size>20971520){
            		
            		layer.alert('上传的文件不能大于20M', {icon: 6});
            		var obj = document.getElementById('attachFile'); 
            		obj.outerHTML=obj.outerHTML;
            		
            		
            	}
            }
        
            //validate form before submit,add by weilong,20190628
            function toVaild(){
            	var title = $("#title").val();
            	if(title=""||title.length==0){
            		layer.alert('标题不能为空！', {icon: 6});
            		return false;
            	}
            	return true;
            }
        </script>
    </body>
</html>