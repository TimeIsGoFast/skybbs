$(function(){
	//when page load, auto trigger this function
	init();
	
	$(".theme_click").click(function(){
		alert();
	});
	
	$("#previous_page a").click(function(){
		var prePage = $("#prePage_num").val();
		if(prePage==0||prePage==''){
			return;
		}
		$("#page_num").val(prePage);
		init();
		
	});
	
	$("#next_page a").click(function(){
		var nextPage = $("#nextpage_num").val();
		if(nextPage==0||nextPage==''){
			return;
		}
		$("#page_num").val(nextPage);
		init();
	});
	
	
	
});
//click theme model event
function selectThemeClick(themeId){
	$("#theme_id_value").val(themeId);
	$("#theme_choose a").css("color","#337ab7");
	$("#theme_id"+themeId).css("color","#ff0000");
	$("#title_content").empty();
	init();
}

//click type event
function selectTypeClick(typeId){
	$("#type_id_value").val(typeId);
	$("#type_choose li").removeClass("active");
	$("#type_id_"+typeId).addClass("active");
	$("#title_content").empty();
	init();
}

function init(){
	var type_id=$("#type_id_value").val();
	var theme_id=$("#theme_id_value").val();
	var page = $("#page_num").val();
	var row = 20;
	
	if(page==""){
		page = 1;
	}
		$.ajax({
			type:'post',
			url:path+'/index/getPostTitleData.do',
			dataType:'json',
			data:{'typeId':type_id,"themeId":theme_id,"page":page,"row":row},
			success:function(result){
				$("#title_content").empty();
				var datas = result.list;
				pageSetting(result.prePage,result.nextPage);
				var content="";
				$.each(datas, function(i,item){
					content+='<div class="row tiezi">'+
			   			'<div class="col-md-8 "><a href="#">'+item.title+'</a></div>'+
				 	 	'<div class="col-md-1 ">'+item.author+'</div>'+
				 	 	'<div class="col-md-1 ">'+item.hotNumber+'</div>'+
				 	 	'<div class="col-md-2 ">'+item.updateDate+'</div>'+
			   		'</div>'
				 	 	
				});
				
				$("#title_content").append(content);
			},
			error:function(){
				console.log("ajax function error!")
			}
	

    });

}

//page setting
function pageSetting(prePage,nextPage){
	if(prePage==0){
		$("#previous_page").addClass("disabled");
	}else{
		$("#previous_page").removeClass("disabled");
		$("#prePage_num").val(prePage);
	}
	if(nextPage==0){
		$("#next_page").addClass("disabled");
	}else{
		$("#next_page").removeClass("disabled");
		$("#nextpage_num").val(nextPage);
	}
}