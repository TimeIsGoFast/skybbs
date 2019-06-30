
 var tables;

   $(document).ready(function () {
	   tables = $("#dataTables-example").myDataTableUtil('#dataTables-example', path+'/admin/getPostPage.do', 'post',
				[
		            {"data": 'id' },
		            {"data": 'title' },
		            {"data": 'author' },
		            {"data": 'postTime' },
		            {"data": 'hotNumber' }
        
		        ],
		        [
		        	{"width": "10%", "targets": 0},
		            {"width": "50%", "targets": 1},
		            {"width": "10%", "targets": 2},
		            {"width": "15%", "targets": 3},
		            {"width": "10%", "targets": 4},
		            {
		             "width": "5%",
		             "targets": 5,
		             "render": function (data, type, row, meta) {
		                    var id = row.id;
		                    return '<td >'+
                                    '<button class="btn btn-danger" title="删除" onclick="deletePost('+id+')"><i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;删除</button>'+
                                    '<button type="button" class="btn btn-success" onclick="movePost('+id+')"><i class="fa fa-hand-o-left" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;移动</button>'
		                    		'</td>';
		                }

		            }
		            
		        ]
	   )
		tables.fnDraw(false); 
	   /* $('#dataTables-example').dataTable();*/
	    /*$("#dataTables-example").dataTable();*/
	    $("#main-menu li a").removeClass("active-menu");
		$("#sessionInfo").addClass("active-menu");
		
   });
  
$(function(){
	
	
	/*$("#exportBtn").click(function(){
		
		var deskgroupId = $("#desktopId").val();
		var passTime = $("#pass_time").val();
		$.ajax({
			type:'post',
			url:path+'/session/export.do',
			dataType:'json',
			data:{'passTime':passTime,'deskgroupId':deskgroupId},
			success:function(result){
		
			},
			error:function(){
				$(".error_message").text("出现未知错误！");
			}		
			
		});
		window.location.href=path+"/session/export.do?deskgroupId="+deskgroupId+"&passTime="+passTime;
		rel="external nofollow"
	});*/
	

	
});

//the delete post function
function deletePost(id){
	layer.msg('你确定要删除这条记录吗？', {
		  time: 0 //不自动关闭
		  ,btn: ['确定', '取消']
		  ,yes: function(index){
		    layer.close(index);
			$.ajax({
				type:'post',
				url:path+'/admin/deletePost.do',
				dataType:'json',
				data:{'titleId':id},
				success:function(result){
					console.log(result);
					if(result.success){
						layer.alert('删除成功！', {icon: 6});
						window.location.reload();
					}else{
						layer.msg('删除失败！', {icon: 5});
					}
					
				},
				error:function(){
					$(".error_message").text("出现未知错误！");
				}		
				
			});
		  }
		});

	
}

//move post
function movePost(id){
	$('#moveModal').modal({
        show: true,
    })
}

 