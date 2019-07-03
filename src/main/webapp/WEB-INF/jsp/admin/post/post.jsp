<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子管理</title>
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
     <link href="${pageContext.request.contextPath}/static/css/input_date.css" rel="stylesheet" />
    
</head>
<p></p>
 <div class="row">
     <div class="col-md-12">
         <!-- Advanced Tables -->
         <div class="panel panel-default">
             <div class="panel-body">
                 <div class="">
                     <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                         <thead>
                             <tr>
                                 <th>id</th>
                                 <th>themeId</th>
                                 <th>typeId</th>
                                 <th>标题</th>
                                 <th>作者</th>
                                 <th>发表时间</th>
                                 <th>热度</th>
                                 <th>操作</th>
                             </tr>
                         </thead>
                   
                     </table>
                 </div>
                 
             </div>
         </div>
         <!--End Advanced Tables -->
     </div>
 </div> 
 
 <div class="modal fade" id="moveModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">帖子</h4>
            </div>
            <div class="modal-body">
            	<form class="form-horizontal">
            	  <input type="hidden" id="post_id" value="">
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">选择主题</label>
				    <div class="col-sm-10">
				          <select class="form-control" id="selectTheme">
							  <c:forEach items="${themes}" var="Theme">
							  	<option value="${Theme.id}">${Theme.themeName }</option>
							  </c:forEach>
							</select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">选择类型</label>
				    <div class="col-sm-10">
				       
						<c:forEach items="${types}" var="Type">
							  <label class="radio-inline" id="typeIds">
								  <input type="radio" name="typeRadioOptions" id="typeRadio${Type.typeId}" value="${Type.typeId}">${Type.itemValue }
							  </label>
						</c:forEach>
						
				    </div>
				  </div>

				</form>
        
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="editPostBtn">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/dataTable-util.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin/post/post.js"></script>


