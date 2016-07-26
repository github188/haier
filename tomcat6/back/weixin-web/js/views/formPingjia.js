$(function () {
	initBtn();
	initOrderTrack();
});


function initBtn(){
	
	//点赞
	$("#tap_dianzan a").bind('click', function(){
		var cur_class = $(this).attr("class");
		$("#tap_dianzan a").each(function(){
			var pre_class = $(this).attr("class");
			$(this).attr("class", pre_class.replace("-active",""));
		});
		$(this).attr("class", cur_class.replace("-active","")+'-active');
		var pj_value = $(this).attr("attr_zan");
		$("#dianzan-hidden").val(pj_value);
		if(pj_value == '3'){
			$("#tap_dianping-cha-detail").show();
		} else {
			$("#tap_dianping-cha-detail").hide();
		}
	});
	
	//提交评价
	$("#pingjiaBtn").bind('click', function(){
		var dianzan = $.trim($("#dianzan-hidden").val());
  		var pingjiatxt = $.trim($("#mypingjia").val());
  		var chaReason = dianzan == '3' ? $("input[name='dianpin-cha-reason']:checked").val():'';
  		mui.toast('您的评价发布成功');return false;
  		var jsonData = {
			"dianzan":dianzan,
			"pingjiatxt":pingjiatxt,
			"cha-reason":chaReason,
		};
		//alert(JSON.stringify(jsonData));
		$.ajax({ 
			type:"POST", 
			url:"http://115.28.231.67:3027/api/haier/1.0/order/newOrder", 
			contentType: "application/json; charset=utf-8",
			dataType:"json", 
			data: JSON.stringify(jsonData),
			success:function(data){
		   		mui.toast('您的评价发布成功');
		   	}
		});
	});
	
	//语音录入评价
	$("#yuyinBtn").bind('click', function(){
		alert('语音录入');
	
	});
}

function initOrderTrack()
{
	var orderCode = $("#orderCode").val();
	var jsonData = {
		"orderCode":orderCode
	};

	if(orderCode != '') {
		$.ajax({ 
			type:"GET",
			url:"serviceOrderListTracker",
			//contentType: "application/json; charset=utf-8",
			dataType:"json",
			data: jsonData,
			success:function(data){
		   	//	alert(JSON.stringify(data));
		   		var code = typeof data.code != 'undefined' ? data.code : '';
		   		if(code.toString() == '0') {
		   			//返回成功
		   			var html = '';
		   			var status = '';
		   			var classname = '';
		   			$.each( data.info, function(i, n){
			   			status = n.status;
			   			classname = status == '0' ? 'tree-active' : 'tree';
			   			html += '<li class="clearfix">';
						html += '	<div class="service-itme-name '+classname+'"><span>'+n.description+'</span></div>';
						html += '	<div class="service-itme-content">';
						html += '		<p>'+time2Ymd(n.updatetime)+'</p>';
						html += '	</div>';
						html += '	<hr>';
						html += '</li>';
					});
					$("#serviceTract").html(html);
			   	} else {
			   		mui.toast(data.message);
			   	}
		   	}
		});
		
	}
}

function time2Ymd(time){
	var date = new Date(time);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds();
	return Y+M+D+h+m+s;
}