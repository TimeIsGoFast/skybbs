
 var tables;

   $(document).ready(function () {
	   tables = $("#dataTables-example").myDataTableUtil('#dataTables-example', path+'/admin/getUserPage.do', 'post',
				[
		            {"data": 'uid' },
		            {"data": 'name' },
		            {"data": 'tel' },
		            {"data": 'mail' },
		            {"data": 'enabled' },
		            {"data": 'remark' },
		            {"data": 'company' },
		            {"data": 'birth' },
		            {"data": 'logoUrl' },
		            {"data": 'createDate' }
        
		        ],
		        [
		        	{"defaultContent": "","targets": "_all"},
		        	{"width": "10%", "targets": 0},
		        	{"width": "10%", "targets": 1},
		        	{"width": "10%", "targets": 2},
		            {"width": "10%", "targets": 3},
		            {"width": "5%", "targets": 4},
		            {"width": "10%", "targets": 5},
		            {"width": "10%", "targets": 6},
		            {"width": "10%", "targets": 7},
		            {"width": "15%", "targets": 8},
		            {"width": "10%", "targets": 9}

		            
		        ]
	         
	   )
		tables.fnDraw(false); 
	   /* $('#dataTables-example').dataTable();*/
	    /*$("#dataTables-example").dataTable();*/
	    $("#main-menu li a").removeClass("active-menu");
		$("#userInfo").addClass("active-menu");
		
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


 