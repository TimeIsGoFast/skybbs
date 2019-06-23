$(function(){
	getDetail();
})

function getDetail(){
	$.ajax({
		type:'post',
		url:path+'/index/getComments.do',
		dataType:'json',
		data:{
			'commentId': titleId,
			'page': 1,
			'row': 20
		},
		success:function(res){
			if(res.list.length>0){
				$('#media-list').empty();
				$.each(res.list, function(key,value){
					var linkNum = '';
					var treadNum = '';
					if(value.comment.linkNum != 0){
						linkNum = value.comment.linkNum;
					}
					if(value.comment.treadNum != 0){
						treadNum = value.comment.treadNum;
					}
					$('#media-list').append('<li id="media'+value.comment.id+'" class="media"><div class="media-left">'+
						'<a href="#"><img class="media-object" src="'+path+'/static/images/logo3.png"></a></div>'+
						'<div class="media-body"><div class="row"><h4 class="media-heading col-md-8">'+value.comment.createName+'</h4>'+
						'<h5 class="col-md-4" style="text-align:right;">#'+(key+1)+' 发表时间：'+value.comment.createDate+'</h5>'+'</div><p class="list-content">'+value.comment.comment+'</p>'+
						'<div class="row coment_body_P"><div class="col-md-12">'+
	                    '<a onclick="showApply('+value.comment.id+')"><i class="fa fa-reply" aria-hidden="true"> 回复</i></a>&nbsp;&nbsp;&nbsp;'+
	                    '<a onclick="doSupport('+value.comment.id+')" class="reply-support"><i class="fa fa-thumbs-up" aria-hidden="true"> 支持 '+linkNum+'</i></a>&nbsp;&nbsp;&nbsp;'+
	                    '<a onclick="doAgainst('+value.comment.id+')" class="reply-against"><i class="fa fa-thumbs-down" aria-hidden="true"> 反对 '+treadNum+'</i></a></div></div></div>'+
	                    '<div id="reply-div'+value.comment.id+'" class="media-body-reply reply-div"><textarea id="reply-context'+value.comment.id+'" class="form-control"></textarea>'+
	                    '<div class="btn-group"><button class="btn btn-primary" onclick="doReply('+value.comment.id+')">回复</button><button class="btn" onclick="hideApply('+value.comment.id+')">取消</button></div></div>'+
						'</li>')
	                if(value.replys.length>0){
	                	$.each(value.replys, function(key1,value1){
	                		$('#media-list').append('<li><div class="media-body media-body-reply"><span class="media-heading list-name">'+value1.fromName+'</span>'+
	                			'<span class="reply-action">&nbsp;回复&nbsp;</span><span class="media-heading list-name">'+value1.toName+'：</span>'+
	                			'<span class="list-content">'+value1.content+'</span><span style="float:right">'+value1.createDate+'</span></div></li>')
	                	})
	                }
				})
			}
		}
	})
}

function doComment(){
	if(!$('#detail-comment').val()){
		alert('请输入评论的内容');
		return;
	}
	$.ajax({
		type:'post',
		url:path+'/index/saveComment.do',
		dataType:'json',
		data:{
			'comment': $('#detail-comment').val(),
			'titleId': titleId,
			'detailId': detailId,
		},
		success:function(res){
			$('#detail-comment').val('');
			getDetail();
		}
	})
}

function showApply(id){
	$('#reply-div'+id).show();
}

function hideApply(id){
	$('#reply-div'+id).hide();
}

function doReply(id){
	if(!$('#reply-context'+id).val()){
		alert('请输入回复的内容');
		return;
	}
	$.ajax({
		type:'post',
		url:path+'/index/saveReply.do',
		dataType:'json',
		data:{
			'commentId': id,
			'comment': $('#reply-context'+id).val(),
			'titleId': titleId,
			'detailId': detailId,
		},
		success:function(res){
			$('#reply-context'+id).val('');
			hideApply(id);
			getDetail();
		}
	})
}

function doLOT(id, type){
	$.ajax({
		type:'post',
		url:path+'/index/linkOrTread.do',
		dataType:'json',
		data:{
			'commentId': id,
			'type': type
		},
		success:function(res){
			getDetail();
		}
	})
}

function doSupport(id){
	doLOT(id, 'link');
}

function doAgainst(id){
	doLOT(id, 'tread');
}



